package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(id="txtUsername")
	public WebElement username;
	
	@FindBy(id="txtPassword")
	public WebElement password;
	
	@FindBy(id="btnLogin")
	public WebElement signIn;
	
	@FindBy(linkText="Welcome Admin")
	public WebElement welcomeLink;
	
	
	public LoginPage() {
		PageFactory.initElements(super.d,this );
	}

	public void login(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		signIn.click();
	}
	
	public boolean  verifyPageText() {
		return welcomeLink.isDisplayed();
	}
	
	public String verifyLinkText() {
		return welcomeLink.getText();
	}
	
	public String verifyPageTitle() {
		return d.getTitle();
	}
	
	
}
