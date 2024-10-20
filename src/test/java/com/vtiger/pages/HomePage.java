package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;


public class HomePage extends HeaderPage{
	


	public HomePage(WebDriver driver,ExtentTest Logger) {

		super(driver,Logger);
		
	}

	

	@FindBy(xpath = "//*[text()='My Pipeline']")
	WebElement lblPipeline;
	
	public void verifyPipeline()
	{
		
		cm.checkdisplay(lblPipeline,"pipeline graph is displayed");
		
		}

}
