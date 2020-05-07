package com.NewsApp.tests;

import com.NewsApp.Screens.LoginScreen;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginScreenSteps {

	private AppiumDriver<MobileElement> driver;
	private  LoginScreen login;
	
	public LoginScreenSteps(){
		this.driver = Hook.getDriver();
		 login = new LoginScreen(driver);
	}
	
	@Given("^The user opens app and validate News logo$")
	public void opensAppAndValidateLogo () throws Throwable {
		login.validateNewsLogoIsDisplayed();
	}

	@Then("^login screen with user name and password entries and login button is displayed$")
	public void validateUserNamePasswordIsDisplayed() throws Throwable {
		login.validateUserNameIsDisplayed();
		login.validatePasswordIsDisplayed();
		login.validateLoginButtonIsDisplayed();
	}
	
	@Given("^The user enter credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enterUserCredentials(String username,String password){
		login.enterUserName(username);
		login.enterPassword(password);
	}
	
	@When("^login button is clicked$")
	public void loginButtonIsClicked() throws Throwable {
      login.tapOnLogInButton();
	}
	
	@When("^error markers are displayed$")
	public void errorMarkersAreDisplayed() throws Throwable {
	}
	
	
} 
