package com.iGreenData.Common.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverWaitUtils {

	static WebDriverWait wait;
	public static WebElement waitUntillVisbilityOfElementLocated(
			WebDriver driver, int seconds, By element) {
		try {
			return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(
					ExpectedConditions.visibilityOfElementLocated(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static WebElement waitUntillelementToBeClickable(
			WebDriver driver, int seconds, By element) {
		try {
			return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(
					ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
