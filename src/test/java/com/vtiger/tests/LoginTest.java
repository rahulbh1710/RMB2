package com.vtiger.tests;



import org.testng.annotations.Test;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

public class LoginTest extends BaseTest {
	

	@Test
	public void TC02_validLogin() {
        
		String TCName="TC02_validLogin";
		Logger = extent.createTest(TCName);
		 lp = new LoginPage(driver,Logger);
		lp.login(data.get(TCName).get("Userid"), data.get(TCName).get("Password"));
		hp=new HomePage(driver,Logger);
		hp.verifyPipeline();
		hp.clickLogout();

	}

	@Test
	public void TC01_InvalidLogin() {
		String TCName="TC01_InvalidLogin";
		Logger = extent.createTest(TCName);
		 lp = new LoginPage(driver,Logger);
		lp.login(data.get(TCName).get("Userid"), data.get(TCName).get("Password"));
	}

}
