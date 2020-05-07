package com.NewsApp.tests;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Hook   {

	protected static AppiumDriver<MobileElement>driver= null;

	public static AppiumDriver<MobileElement> getDriver(){
		return driver;
	}
	@Before
	public void setUp() throws IOException
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.test.news");
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.test.news.features.login.presentation.LoginActivity");
		desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
		desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.SUPPORTS_APPLICATION_CACHE, "false");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
	}
	@After
	public void tearDown(){
		driver.closeApp();
	}
}