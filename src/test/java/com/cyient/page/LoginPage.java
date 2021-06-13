package com.cyient.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {

	private WebDriver driver;
	private By profileLocator = By.xpath("//a[@aria-label='Log-In']");
	private By loginLocator = By.xpath("//a[contains(text(),'Log-In/Sign-Up')]");
	private By sendUsernameLocator = By.xpath("//input[@id='iptLgnPlnID']");
	private By sendPasswordLocator = By.xpath("//input[@id='iptLgnPlnPD']");
	private By clickOnSigninButtonLocator = By.xpath("(//button[contains(text(),'Sign in')])[2]");
	private By getErrorMessageLocator = By.xpath("//div[contains(text(),'Incorrect ID or password.')]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnLogin() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(profileLocator)).perform();
		driver.findElement(loginLocator).click();
		Thread.sleep(3000);
	}

	public void sendUsername(String username) {
		driver.findElement(sendUsernameLocator).sendKeys(username);
	}

	public void sendPassword(String password) {
		driver.findElement(sendPasswordLocator).sendKeys(password);
	}

	public void clickOnSigninButton() {
		driver.findElement(clickOnSigninButtonLocator).click();
	}

	public String getErrorMessage() {
		String OValue = driver.findElement(getErrorMessageLocator).getText().trim();

		return OValue;

	}
}
