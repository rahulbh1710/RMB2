package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

public class LeadPage  extends HeaderPage{
	


	public LeadPage(WebDriver driver,ExtentTest Logger) {

		super(driver,Logger);
		
	}

	@FindBy(name = "lastname")
	WebElement tblastname;
	
	@FindBy(name = "company")
	WebElement tbcompany;
	
	
	@FindBy(name = "button")
	WebElement tbbutton;
	
	
	public void createLeadWithMandatoryfields(String lname,String comp)
	{
		setLastName(lname);
		SetCompany(comp);
		clicksave();
	}

	public void setLastName(String val)
	{
		cm.EnterValue(tblastname, val,"Text" +val+ "has been entered into LastName field");
	}
	public void SetCompany(String val)
	{
		cm.EnterValue(tbcompany, val,"Text" +val+ "has been entered into Company field");
		
	}
	public void clicksave()
	{
		cm.ClickElement(tbbutton,"save button clicked");
	}
}
