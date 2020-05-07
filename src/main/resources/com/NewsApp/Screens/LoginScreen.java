package com.NewsApp.Screens;

import org.testng.SkipException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginScreen extends Screen {

	private AppiumDriver<MobileElement> driver;
	private int timeOut = 10;
	
	@AndroidFindBy(id = "com.test.news:id/textViewLogo")
	private MobileElement NewsLogo;
	
	@AndroidFindBy(id = "com.test.news:id/editTextUserName")
	private MobileElement Username;
	
	@AndroidFindBy(id = "com.test.news:id/editTextPassword")
	private MobileElement Password;
	
	@AndroidFindBy(id = "com.test.news:id/buttonLogin")
	private MobileElement LoginButton;
	
	
	
	
	public LoginScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void validateNewsLogoIsDisplayed(){
		ScreenObject.waitForElementVisibleAndClickable(NewsLogo, driver, timeOut);
		if (!this.NewsLogo.getText().equals("News"))
			throw new SkipException("LoginScreen page isn't displayed");
	}
	public void enterUserName(String username){
		ScreenObject.waitForElementVisibleAndClickable(Username, driver, timeOut);
		this.Username.clear();
		this.Username.sendKeys(username);
	}
	
	public void validateUserNameIsDisplayed(){
		ScreenObject.waitForElementVisibleAndClickable(Username, driver, timeOut);
		if (!this.Username.isDisplayed())
			throw new SkipException("Username is not displayed");
	}
	
	public void enterPassword(String password){
		ScreenObject.waitForElementVisibleAndClickable(Password, driver, timeOut);
		this.Password.clear();
		this.Password.sendKeys(password);
	}
	
	public void validatePasswordIsDisplayed(){
		ScreenObject.waitForElementVisibleAndClickable(Password, driver, timeOut);
		if (!this.Password.isDisplayed())
			throw new SkipException("Password is not displayed");
	}
	
	public void tapOnLogInButton(){
		ScreenObject.waitForElementVisibleAndClickable(LoginButton, driver, timeOut);
		this.LoginButton.click();
	}
	
	public void validateLoginButtonIsDisplayed(){
		ScreenObject.waitForElementVisibleAndClickable(LoginButton, driver, timeOut);
		if (!this.LoginButton.isDisplayed())
			throw new SkipException("LoginButton is not displayed");
	}
}
