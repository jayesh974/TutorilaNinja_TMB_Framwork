package com.tn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.tn.driver.DriverManager;
import com.tn.enums.WaitStrategy;
import com.tn.factories.ExplicitWaitFactory;
import com.tn.reports.ExtentLogger;

public class BasePage {

	protected void click(By by, WaitStrategy waitstrategy, String elementname) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.click();
		ExtentLogger.info(elementname + " is clicked");
	}

	protected void sendKeys(By by, String value, WaitStrategy waitstrategy, String elementname) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.sendKeys(value);
		try {
			ExtentLogger.pass(value + " is entered successfully in " + elementname, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected String getText(By by) {
		return DriverManager.getDriver().findElement(by).getText();
	}
	
	public SearchPage searchForProduct(String product) {
		DriverManager.getDriver().findElement(By.xpath("//input[@name='search']")).sendKeys(product,Keys.ENTER);
		ExtentLogger.pass(product + " is Entered and searched");
		return new SearchPage();
	
	}
	

}
