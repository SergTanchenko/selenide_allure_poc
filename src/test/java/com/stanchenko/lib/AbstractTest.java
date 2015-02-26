package com.stanchenko.lib;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.codeborne.selenide.WebDriverRunner;

/**
 * (c) Swissquote 26.02.15
 *
 * @author Sergii Tanchenko (o_stanch)
 */
public class AbstractTest {

	@Before
	public void init() {
		WebDriverRunner.setWebDriver(getChromeInstance());
		WebDriver webDriver = WebDriverRunner.getWebDriver();

		webDriver.manage().window().setPosition(new Point(0, 0));
		webDriver.manage().window().maximize();
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
