package com.vtiger.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.commonMethods;

public class LoginPage {
	public WebDriver driver;
	public commonMethods cm;
	private  ExtentTest Logger;

	public LoginPage(WebDriver driver,ExtentTest Logger) {

		this.driver = driver;
		this.Logger= Logger;
		PageFactory.initElements(driver, this);
		 cm = new commonMethods(driver,Logger);
	}

	

	@FindBy(name = "user_name")
	WebElement tbuserid;

	@FindBy(name = "user_password")
	WebElement tbpwd;

	@FindBy(name = "Login")
	WebElement btnlogin;
	
	@FindBy(name = "login_theme")
	WebElement slcTheme;

	public void login(String userid, String pwd) {
		SetUserid(userid);
		Setpassword(pwd);
		Clicklogin();

	}

	public String verifyUsernameEditable(String val) {
		cm.EnterValue(tbuserid, val,"Text" +val+ "has been entered into username field");
		return tbuserid.getAttribute("value");
	}
	
	public void SetUserid(String val)
	{
		cm.EnterValue(tbuserid, val,"Text" +val+ "has been entered into username field");
	}
	public void Setpassword(String val)
	{
		cm.EnterValue(tbpwd, val,"Text" + val+ "has been entered into password field");
	}
	public void Clicklogin()
	{
		cm.ClickElement(btnlogin,"Loginbutton has been clicked");
	}

	public void SelectDropdown(String val)
	{
		cm.SelectVisbleText(slcTheme, val,"Text" +val+ "has been selected from theme dropdown");
	}
}
