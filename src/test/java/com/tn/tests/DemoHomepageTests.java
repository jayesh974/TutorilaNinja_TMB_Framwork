package com.tn.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.tn.driver.DriverManager;

public final class DemoHomepageTests extends BaseTest{
	
	private DemoHomepageTests() {}
	
	@Test
	public void test1() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation Testing", Keys.ENTER);

	}
	
	@Test
	public void test2() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation Testing", Keys.ENTER);

	}

}
