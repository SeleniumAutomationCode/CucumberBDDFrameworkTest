package com.iGreenData.Common.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.iGreenData.baseSetup.baseClass;

public class CommonMethods extends baseClass {

	public void clickElement(WebDriver driver, By element, String stepDesc) {
		try {
			WebdriverWaitUtils.waitUntillVisbilityOfElementLocated(driver, 10, element).click();
			test.pass("Passed" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShotMethod(driver)).build());
		} catch (Exception e) {
			test.fail("Failed" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShotMethod(driver)).build());
		}
	}

	public void enterValue(WebDriver driver, By element, String enterValue, String stepDesc) {
		try {
			WebdriverWaitUtils.waitUntillVisbilityOfElementLocated(driver, 10, element).sendKeys(enterValue);
			test.pass("Passed" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShotMethod(driver)).build());
		} catch (Exception e) {
			test.fail("Failed" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShotMethod(driver)).build());
			throw new InvalidArgumentException("Unable To enter value on the element " + e.getMessage());
		}
	}

	public void selectByIndexFromDropDown(WebDriver driver, By element, int index, String stepDesc) {
		try {
			Select select = new Select(driver.findElement(element));
			select.selectByIndex(index);
			test.pass("Passed" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShotMethod(driver)).build());
		} catch (Exception e) {
			test.fail("Failed" + stepDesc,
					MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShotMethod(driver)).build());
			throw new InvalidArgumentException("Unable To Select the element " + e.getMessage());
		}
	}
}
