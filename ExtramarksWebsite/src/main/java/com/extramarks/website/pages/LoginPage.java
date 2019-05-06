package com.extramarks.website.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.extramarks.website.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(xpath="/html/body/header/nav/div/div[1]/a/img")
	WebElement logo;
	
	@FindBy(linkText="Login")
	WebElement loginbutton;
	
	@FindBy(id="usernameLogin")
	WebElement username;
	
	@FindBy(id="passwdLogin")
	WebElement password;
	
	@FindBy(linkText="LOG IN")
	WebElement submitbutton;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	public boolean pageLogo(){
		return logo.isDisplayed();
	}
}
