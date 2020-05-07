package com.NewsApp.tests;

import com.NewsApp.Screens.NewsScreen;
import com.NewsApp.Screens.Wifi;

import cucumber.api.java.en.Then;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class NewsScreenSteps {
	private AppiumDriver<MobileElement> driver;
	private  NewsScreen news;
	
	public NewsScreenSteps (){
		this.driver = Hook.getDriver();
		 news = new  NewsScreen(driver);
	}
	
	@Then("^user is taken to the news screen$")
	public void userTakentoNewsScreen() throws Throwable {
		news.validateNewsScreenIsDisplayed();
	}
	
	@Then("^There is internet connection$")
	public void thereIsInternetConnetion() throws Throwable {
		  Wifi wifi = new Wifi();
          wifi.turnWifiOn();
	}
	
	@Then("^Images are load and displayes on the list$")
	public void validteImagesList() {
       news.sizeOfImageList();
	}
	
	@Then("^There is no internet connection$")
	public void noInterNetConnection() throws Throwable {
          Wifi wifi = new Wifi();
          wifi.turnWifiOff();
	}
	
	@Then("^faied load new error message is dispayed$")
	public void failedLoadImages() {
		news.validateFailedLoadImages();

	}
}
