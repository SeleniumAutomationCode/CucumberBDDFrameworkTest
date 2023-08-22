package com.iGreenData.Common.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.iGreenData.baseSetup.baseClass;

public class ValidationUtils extends baseClass{

	public void validatePageTitle(WebDriver driver, String expectedTitle,
			String stepDesc) {
		try {
			System.out.println("Title: " + driver.getTitle());
			Assert.assertEquals(driver.getTitle(), expectedTitle);
			test.pass("Passed" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShotMethod(driver)).build());
		} catch (AssertionError e) {
			test.fail("Failed" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShotMethod(driver)).build());
			throw new AssertionError(
					"Unable To Validate the page url " + e.getMessage());
		}
	}

	public void validatePageUrl(WebDriver driver, String expectedURL,
			String stepDesc) {
		try {
			System.out.println("Title: " + driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
			test.pass("Passed" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShotMethod(driver)).build());
		} catch (AssertionError e) {
			test.fail("Failed" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShotMethod(driver)).build());
			throw new AssertionError(
					"Unable To Validate the page url " + e.getMessage());
		}
	}

	public void validateText(WebDriver driver, By element, String expectedValue,
			String stepDesc) {
		try {
			WebElement ele = WebdriverWaitUtils
					.waitUntillVisbilityOfElementLocated(driver, 20, element);
			Assert.assertTrue(ele.getText().concat(expectedValue), true);
			test.pass("Passed" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShotMethod(driver)).build());
		} catch (AssertionError e) {
			test.fail("Failed" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShotMethod(driver)).build());
			throw new AssertionError(
					"Unable To Validate Text " + e.getMessage());
		}
	}

	public void validateElementIsExists(WebDriver driver, By element,
			String stepDesc) {
		try {
			WebElement ele = WebdriverWaitUtils
					.waitUntillVisbilityOfElementLocated(driver, 20, element);
			Assert.assertTrue(ele.isDisplayed());
			test.pass("Passed" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShotMethod(driver)).build());
		} catch (AssertionError e) {
			test.fail("Failed" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShotMethod(driver)).build());
			throw new AssertionError(
					"Unable To Validate the element is presented or not"
							+ e.getMessage());
		}
	}
}
