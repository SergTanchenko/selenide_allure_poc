package com.stanchenko.lib;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.junit.ScreenShooter.failedTests;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.ScreenShooter;

/**
 * (c) Swissquote 26.02.15
 *
 * @author Sergii Tanchenko (o_stanch)
 */
public class AbstractTest {

	@Rule
	public ScreenShooter photographer = failedTests().to("target/screenshots");

	private static WebDriver driver;

	@BeforeClass
	public static void startBrowser() {
		WebDriverRunner.setWebDriver(getChromeInstance());
		driver = WebDriverRunner.getWebDriver();
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().maximize();
		clearBrowserCache();
	}

	@AfterClass
	public static void closeBrowser() {
		driver.close();
	}

	private static WebDriver getChromeInstance() {
		ChromeDriverService service = new ChromeDriverService.Builder()
			.usingDriverExecutable(new File(System.getProperty("user.home") + "/chromedriver"))
			.usingAnyFreePort()
			.build();
		try {
			service.start();
		}
		catch (IOException e) {
			System.out.println("Chrome Service wasn't started! \n" + e.getMessage());
		}
		return new ChromeDriver(service);
	}
}
