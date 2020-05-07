package com.NewsApp.Screens;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Screen extends ScreenObject
{
		/**
		 * Constructor
		 * @param driver Appium driver for android
		 */

		public Screen(AppiumDriver<MobileElement> driver)
	    {
	        super(driver);
	        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(60)), this);
	    }

	}