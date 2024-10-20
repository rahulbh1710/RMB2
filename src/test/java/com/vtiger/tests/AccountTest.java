package com.vtiger.tests;


import org.testng.annotations.Test;

import com.vtiger.pages.AccountPage;
import com.vtiger.pages.LoginPage;


public class AccountTest extends BaseTest {
	
	
	@Test
	public void TC04_CreateNewAccount()
	{
		String TCName="TC04_CreateNewAccount";
		Logger = extent.createTest(TCName);
		 lp = new LoginPage(driver,Logger);
		lp.login(data.get(TCName).get("Userid"), data.get(TCName).get("Password"));
		 ac = new AccountPage(driver,Logger);
		ac.clickNewAccount();
		ac.createAccount(data.get(TCName).get("AcoountName"));
		ac.clickLogout();
	}

}
