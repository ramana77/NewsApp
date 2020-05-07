package com.NewsApp.Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ScreenObject {
	/**
	 * Keep reference to an external driver
	 */
	protected final AppiumDriver<MobileElement> driver;


	public ScreenObject(final AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	protected static Boolean waitForElementVisible(MobileElement mobileElement, AppiumDriver<?> driver, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		Boolean elementIsNotVisible = true;
		try {
			wait.until(ExpectedConditions.visibilityOf(mobileElement));
		} catch (WebDriverException e) {
			elementIsNotVisible = false;
		}
		return elementIsNotVisible;
	}

	protected static Boolean waitForElementVisibleAndClickable(MobileElement mobileElement, AppiumDriver<?> driver,
			int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		Boolean elementIsNotVisible = true;
		try {
			wait.until(ExpectedConditions.visibilityOf(mobileElement));
			wait.until(ExpectedConditions.elementToBeClickable(mobileElement));
		} catch (WebDriverException e) {
			elementIsNotVisible = false;
		}
		return elementIsNotVisible;
	}

	protected static Boolean waitForElementNotVisible(By by, AppiumDriver<?> driver, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		Boolean elementIsNotVisible = true;
		try {
			elementIsNotVisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch (WebDriverException e) {
			elementIsNotVisible = false;
		}
		return elementIsNotVisible;
	}

	protected static Boolean isElementVisible(MobileElement element, AppiumDriver<?> driver) {
		Boolean isElementVisible = false;
		try {
			if (element != null && element.isDisplayed()) {
				isElementVisible = true;
			} else {
				isElementVisible = false;
			}
		} catch (WebDriverException e) {
		}
		return isElementVisible;
	}
	
}