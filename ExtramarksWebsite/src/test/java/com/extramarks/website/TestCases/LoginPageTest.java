package com.extramarks.website.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.extramarks.website.base.TestBase;
import com.extramarks.website.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	public LoginPageTest(){
		super();
	}
	@Test
	public void loginPageTest(){
		launchBrowser();
		loginpage = new LoginPage();
	}
	@Test
	public void pageLogo(){
		boolean flag = loginpage.pageLogo();
		Assert.assertTrue(flag);
	}
}
