package com.cyient.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWrapper;
import com.cyient.page.LoginPage;
import com.cyient.utilities.DataProviderUtils;

public class InvalidUserTest extends WebDriverWrapper {

	@Test(dataProvider = "inValidCredentialExcelData", dataProviderClass = DataProviderUtils.class)
	public void inValidCredentialExcelTest(String username, String password, String expectedValue)
			throws InterruptedException {

		LoginPage log = new LoginPage(driver);
		log.clickOnLogin();
		log.sendUsername(username);
		log.sendPassword(password);
		log.clickOnSigninButton();

		Assert.assertEquals(log.getErrorMessage(), expectedValue);

	}

	@Test(dataProvider = "inValidCredentialData", dataProviderClass = DataProviderUtils.class)
	public void inValidCredentialDataProviderTest(String username, String password, String expectedValue)
			throws InterruptedException {
		LoginPage log = new LoginPage(driver);
		log.clickOnLogin();
		log.sendUsername(username);
		log.sendPassword(password);
		log.clickOnSigninButton();

		Assert.assertEquals(log.getErrorMessage(), expectedValue);
	}

}
