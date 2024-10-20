package com.vtiger.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class commonMethods {

	public WebDriver driver;
	public WebDriverWait wait;
	private  ExtentTest Logger;

	public commonMethods(WebDriver driver,ExtentTest Logger) {

		this.driver = driver;
		this.Logger= Logger;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	public void EnterValue(WebElement elm, String val,String msg) 
	{
		try

		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.clear();
			elm.sendKeys(val);
			Logger.pass(msg+ "    <a href='"+getscreenshot() +"'>Screenshot</a>");
		} catch (Exception e) {
			e.printStackTrace();
			Logger.fail(e.getMessage()+ "    <a href='"+getscreenshot() +"'>Screenshot</a>");
		}

	}
	public void ClickElement(WebElement elm,String msg)
	{
		try

		{
			wait.until(ExpectedConditions.elementToBeClickable(elm));
			elm.click();
			Logger.pass(msg+ "    <a href='"+getscreenshot() +"'>Screenshot</a>");
		} catch (Exception e) {
			e.printStackTrace();
			Logger.fail(e.getMessage()+ "    <a href='"+getscreenshot() +"'>Screenshot</a>");
		}

	}
	public void SelectVisbleText(WebElement elm,String val,String msg) {
		try

		{
			wait.until(ExpectedConditions.elementToBeSelected(elm));
			Select s = new Select(elm);
		s.selectByVisibleText(val);
		Logger.pass(msg+ "    <a href='"+getscreenshot() +"'>Screenshot</a>");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Logger.fail(e.getMessage()+ "    <a href='"+getscreenshot() +"'>Screenshot</a>");
		}

	}
	
	public void checkdisplay(WebElement elm,String msg) {
		try

		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.isDisplayed();
			Logger.pass(msg+ "    <a href='"+getscreenshot() +"'>Screenshot</a>");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Logger.fail(e.getMessage()+ "    <a href='"+getscreenshot() +"'>Screenshot</a>");
		}

	}
	public String getscreenshot() 
	{
		DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
		Date d = new Date();
		String str = f.format(d);
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/screenshots/image"+str+".png";
		//Move image file to new destination
		File DestFile=new File(path);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		
	}
}
