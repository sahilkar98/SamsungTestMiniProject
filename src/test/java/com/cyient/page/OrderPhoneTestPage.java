package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class OrderPhoneTestPage {

	private WebDriver driver;
	private By cilckOnSearchLocator = By.xpath("(//a[@class='gnb__search-btn gnb__search-btn-js']/..)[2]");
	private By enterNameOfMobileLocator = By.xpath("//input[@id='gnb-search-keyword']");
	private By clickOnMobileLocator =By.xpath("//b[contains(text(),'Galaxy')]/..");
	private By clickOnBuyNowLocator=By.xpath("//span[contains(text(),'Buy Now')]");
	private By firstClickOnContinueLocator=By.xpath("//a[contains(text(),'CONTINUE')]");
	private By secondClickOnContinueLocator=By.xpath("//span[contains(text(),'Continue')]");
	private By clickOnPayNowLocator=By.xpath("//a[contains(text(),'Pay Now')]");
	private By getTotalSavingsLocator =By.xpath("(//p[contains(text(),'₹33000.00')])[2]");
	private By getDiscountLocator=By.xpath("//p[contains(text(),'₹6000.00')]");

	public OrderPhoneTestPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void cilckOnSearch() {
		driver.findElement(cilckOnSearchLocator).click();
	}

	public void enterNameOfMobile() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(enterNameOfMobileLocator)).sendKeys("galaxy s20 5g").pause(1000)
				.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void clickOnMobile() {
		driver.findElement(clickOnMobileLocator).click();
	}
	
	public void clickOnBuyNow() {
		driver.findElement(clickOnBuyNowLocator).click();
	}
	
	public void clickOnContinue() throws InterruptedException {
		driver.findElement(firstClickOnContinueLocator).click();
		Thread.sleep(3000);
		driver.findElement(secondClickOnContinueLocator).click();
	}
	
	public void clickOnPayNow() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(clickOnPayNowLocator).click();
	}
	
	public String getTotalSavings() {
		return driver.findElement(getTotalSavingsLocator).getText().trim();
		
	}
	
	public String getDiscount() {
		return driver.findElement(getDiscountLocator).getText().trim();
		
	}
	
}
