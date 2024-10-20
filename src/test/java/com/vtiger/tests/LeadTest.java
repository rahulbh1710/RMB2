package com.vtiger.tests;

import org.testng.annotations.Test;

import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

public class LeadTest extends BaseTest {
	

	@Test
	public void TC03_createleadwithMandatoryFields()
	{
		String TCName="TC03_createleadwithMandatoryFields";
		Logger = extent.createTest(TCName);
		 lp = new LoginPage(driver,Logger);
		lp.login(data.get(TCName).get("Userid"), data.get(TCName).get("Password"));
		ldp= new LeadPage(driver,Logger);
		ldp.ClickNewLead();
		ldp.createLeadWithMandatoryfields(data.get(TCName).get("LastName"), data.get(TCName).get("Company"));
		ldp.clickLogout();
	}

}
