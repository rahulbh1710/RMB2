package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

public class AccountPage extends HeaderPage{
	
	


	public AccountPage(WebDriver driver, ExtentTest Logger) {

		super(driver,Logger);
		
	}

	


	@FindBy(name = "accountname")
	WebElement tbaccountname;
	
	
	@FindBy(name = "button")
	WebElement btnSave;
	
	public void createAccount(String val)
	{
		setAccountName(val);
		 clickSave();
	}

	public void setAccountName(String val)
	{
		cm.EnterValue(tbaccountname, val,"Text" +val+ "has been entered into username field");
	}
    
	public void clickSave()
	{
		cm.ClickElement(btnSave,"Save button has been clicked");
	}
}
