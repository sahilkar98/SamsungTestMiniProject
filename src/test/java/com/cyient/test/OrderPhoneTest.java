package com.cyient.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWrapper;
import com.cyient.page.OrderPhoneTestPage;

public class OrderPhoneTest extends WebDriverWrapper {

	@Test
	public void placeOrderTest() throws InterruptedException {

		OrderPhoneTestPage od = new OrderPhoneTestPage(driver);
		od.cilckOnSearch();
		od.enterNameOfMobile();
		od.clickOnMobile();
		od.clickOnBuyNow();
		od.clickOnContinue();
		od.clickOnPayNow();

		Assert.assertEquals(od.getTotalSavings(), "₹33000.00");
		Assert.assertEquals(od.getDiscount(), "₹6000.00");
	}

}
