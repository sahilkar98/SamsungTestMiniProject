package com.cyient.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWrapper;
import com.cyient.page.OrderPhoneTestPage;

public class OrderPhoneTest extends WebDriverWrapper {

	@Test
	public void placeOrderTest() throws InterruptedException, IOException {

		OrderPhoneTestPage od = new OrderPhoneTestPage(driver);
		od.cilckOnSearch();
		od.enterNameOfMobile();
		od.clickOnMobile();
		od.clickOnBuyNow();
		od.clickOnContinue();
		od.clickOnPayNow();

		Assert.assertEquals(od.getTotalSavings(), "₹33000.00");
		Assert.assertEquals(od.getDiscount(), "₹6000.00");
		
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("C:\\study\\Automation_Testing\\Cyient_java_Workspace\\SamsungApplicationTest\\src\\test\\resources\\screenshots\\test3.png"));

	}

}
