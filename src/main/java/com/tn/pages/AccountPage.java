package com.tn.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import com.google.common.util.concurrent.Uninterruptibles;
import com.tn.driver.DriverManager;
import com.tn.enums.WaitStrategy;

public final class AccountPage extends BasePage {
	
	protected AccountPage(){}
	
	private final By linklogout = By.linkText("Logout");
	
	public String getTitle(){
		return DriverManager.getDriver().getTitle();
	}
	
	public LoginPage ClickOnLogOutLink()
	{
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		click(linklogout, WaitStrategy.CLICKABLE,"Logout linked");
		return new LoginPage();
	}

}
