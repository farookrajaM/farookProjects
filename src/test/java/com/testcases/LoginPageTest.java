package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.pages.LoginPage;


public class LoginPageTest extends BaseClass {
	LoginPage loginPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void appLaunch() {
		launching();
		loginPage=new LoginPage();
		loginPage.login(p.getProperty("username"), p.getProperty("password"));
	}
	
	@Test
	public void verifyLoginPageTitleText() {
		String Title = loginPage.verifyPageTitle();
		Assert.assertEquals(Title, "OrangeHRM");
	}
	
	@Test
	public void verifyLinkTextLoginPage() {
		String LinkText = loginPage.verifyLinkText();
		Assert.assertEquals(LinkText, "Welcome Admin");
	}
	
	@Test
	public void verifyPageTextLoginPage() {
		boolean b = loginPage.verifyPageText();
		Assert.assertTrue(b);
	}
	
	@AfterMethod
	public void appQuit(){
		d.quit();
	}
}
