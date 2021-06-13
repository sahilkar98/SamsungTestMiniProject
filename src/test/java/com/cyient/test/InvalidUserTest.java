package com.cyient.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWrapper;
import com.cyient.page.LoginPage;
import com.cyient.utilities.DataProviderUtils;

public class InvalidUserTest extends WebDriverWrapper {

	@Test(dataProvider = "inValidCredentialExcelData", dataProviderClass = DataProviderUtils.class)
	public void inValidCredentialExcelTest(String username, String password, String expectedValue) throws Exception {

		LoginPage log = new LoginPage(driver);
		log.clickOnLogin();
		log.sendUsername(username);
		log.sendPassword(password);
		log.clickOnSigninButton();
		
		Assert.assertEquals(log.getErrorMessage(), expectedValue);
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("C:\\study\\Automation_Testing\\Cyient_java_Workspace\\SamsungApplicationTest\\src\\test\\resources\\screenshots\\test.png"));

	}

	@Test(dataProvider = "inValidCredentialData", dataProviderClass = DataProviderUtils.class)
	public void inValidCredentialDataProviderTest(String username, String password, String expectedValue)
			throws InterruptedException, Exception {
		LoginPage log = new LoginPage(driver);
		log.clickOnLogin();
		log.sendUsername(username);
		log.sendPassword(password);
		log.clickOnSigninButton();
		
		Assert.assertEquals(log.getErrorMessage(), expectedValue);
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("C:\\study\\Automation_Testing\\Cyient_java_Workspace\\SamsungApplicationTest\\src\\test\\resources\\screenshots\\test2.png"));
		
	}

}
