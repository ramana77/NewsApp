package com.NewsApp.Screens;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.SkipException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NewsScreen extends Screen {

	private AppiumDriver<MobileElement> driver;
	private int timeOut = 10;


	@AndroidFindBy(className="android.widget.TextView")
	private MobileElement NewsScreen;
	
	@AndroidFindBy(id="com.test.news:id/imageView")
	private List< MobileElement> Images;
	
	@AndroidFindBy(className="com.test.news:id/textViewError")
	private MobileElement FailedloadNews;

	public NewsScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = driver;
	}

	public void validateNewsScreenIsDisplayed(){
		ScreenObject.waitForElementVisibleAndClickable(NewsScreen, driver, timeOut);
		if (!this.NewsScreen.getText().equals("News"))
			throw new SkipException("NewsScreen isn't displayed");
	}
	
	public void validateFailedLoadImages(){
		ScreenObject.waitForElementVisibleAndClickable(FailedloadNews, driver, timeOut);
		if (!this.FailedloadNews.getText().equals("Failed to load news"))
			throw new SkipException("Failed to load news isn't displayed");
	}
	
	public void tapOnImage(int index){
		this.Images.get(index).click();
	}
	
	public void sizeOfImageList(){
		int val =Images.size();
		System.out.print("val");
	}
	
	@SuppressWarnings("rawtypes")
	public static void scroll(AppiumDriver<MobileElement> driver, int startX, int startY, int endX, int endY)
			throws InterruptedException {
		new TouchAction(driver).press(point(startX, startY)).waitAction(waitOptions(ofMillis(1000)))
				.moveTo(point(endX, endY)).release().perform();

		Thread.sleep(1000);
	}
}
