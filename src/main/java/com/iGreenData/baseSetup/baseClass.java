package com.iGreenData.baseSetup;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;
import com.iGreenData.extentReports.reportConfig;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass extends reportConfig{

	public WebDriver driver;
	public WebDriver setupBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new ChromeDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public void launchURL(WebDriver driver, String url) {
		try {
			driver.get(url);
		} catch (Exception e) {

		}
	}

	@After
	public void quitDriver() {
		try {
			driver.quit();
		} catch (Exception e) {
		}
	}
	
	public ExtentTest startTestCase(String testCase) {
		try {
			test = startTestCase(testCase);
		} catch (Exception e) {
			test.fail("Unable to create test case "+e.getMessage());
		}
		return null;
	}
	
	public String takeScreenShotMethod(WebDriver driver) {
		String screenShotFormat = "";
		try {
			TakesScreenshot ts= (TakesScreenshot)driver;
			String base64EncodedScreenshot =  ts.getScreenshotAs(OutputType.BASE64);
			 screenShotFormat = "data:image/png;base64,"+base64EncodedScreenshot;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return screenShotFormat;
	}
}
