package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.commonMethods;

public class HeaderPage {
	
	
	
	public WebDriver driver;
	public commonMethods cm;
	private  ExtentTest Logger;

	
	

	public HeaderPage(WebDriver driver,ExtentTest Logger) {

		this.driver = driver;
		this.Logger= Logger;
		PageFactory.initElements(driver, this);
	   cm = new commonMethods(driver,Logger);
	}

	

	@FindBy(linkText = "Logout")
	WebElement lnkLogout;
	
	@FindBy(linkText = "New Lead")
	WebElement lnkNewLead;
	
	
	@FindBy(linkText = "Leads")
	WebElement lnkleads;
	
	@FindBy(linkText = "New Account")
	WebElement lnkNewAccount;
	
	public void clickLogout()
	{
		cm.ClickElement(lnkLogout,"Logout link has been clicked");
	}

	
	public void ClickNewLead()
	{
		cm.ClickElement(lnkNewLead,"NewLead link has been clicked");
	}

	
	public void clickLeads()
	{
		cm.ClickElement(lnkleads,"Leads link has been clicked");
	}

	public void clickNewAccount()
	{
		cm.ClickElement(lnkNewAccount,"NewAccount link has been clicked");
	}

}
