package com.stanchenko.lib;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.ScreenShooter;

/**
 * Created by Sergii Tanchenko on 05.03.2015.
 */
public class AbstractTest {

	private static final String IE_REMOTE_DRIVER_URL = "http://172.30.148.8:4455/wd/hub";


	@Rule
	public ScreenShooter makeScreenShotOnFailure = ScreenShooter.failedTests().to("target/selenide");

	private static WebDriver driver;

	@BeforeClass
	public static void startBrowser() {
		WebDriverRunner.setWebDriver(getChromeInstance());
		driver = WebDriverRunner.getWebDriver();
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().maximize();
		//		clearBrowserCache();
	}

	@AfterClass
	public static void closeBrowser() {
		if (driver != null) {
			driver.close();
		}
	}

	private static WebDriver getChromeInstance() {
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File(getChromeDriverPath()))
				.usingAnyFreePort()
				.build();
		try {
			service.start();
		} catch (IOException e) {
			System.out.println("Chrome Service wasn't started! \n" + e.getMessage());
		}
		return new ChromeDriver(service);
	}

	private static WebDriver getIEInstance() {
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setJavascriptEnabled(true);
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setCapability("nativeEvents", true);
		capabilities.setCapability("ie.validateCookieDocumentType", false);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		URL ieRemoteUrl = null;
		try {
			String urlStr = System.getProperty(IE_REMOTE_DRIVER_URL);
			ieRemoteUrl = new URL(IE_REMOTE_DRIVER_URL);
		}
		catch (MalformedURLException e) {
			System.out.println((e.getMessage()));
		}

		if (ieRemoteUrl != null) {
			return new RemoteWebDriver(ieRemoteUrl, capabilities);
		} else {
			return new RemoteWebDriver(capabilities);
		}
	}

	/**
	 * Chrome driver should be placed in home directory.
	 *
	 * @return path to chromedriver
	 */
	private static String getChromeDriverPath() {
		StringBuilder commonPath = new StringBuilder(System.getProperty("user.home"));

		String osName = System.getProperty("os.name");

		if (osName != null && osName.toLowerCase().contains("windows")) {
			// For jenkins: C:\\chromedriver.exe
			commonPath.append("\\chromedriver.exe");
		} else {
			// For Ubuntu
			commonPath.append("/chromedriver");
		}
		return commonPath.toString();
	}
}
