package com.tn.pages;

import org.openqa.selenium.By;
import com.tn.driver.DriverManager;
import com.tn.enums.WaitStrategy;
import com.tn.utils.DecodeUtils;

public final class LoginPage extends BasePage{

	private final By linkLogin = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li[2]");
	private final By emailAddress = By.cssSelector("[name=email]");
	private final By pwd = By.cssSelector("[name=password]");
	private final By Btnlogin = By.cssSelector("[value=Login]");
	private final By account_BreakDrum = By.xpath("//ul[@class='breadcrumb']");


	public LoginPage enterEmailAddress(String emailid) {
		sendKeys(emailAddress, emailid, WaitStrategy.PRESENCE,"email address");
		return this;
	}

	public LoginPage enterPassword(String password) {
		sendKeys(pwd, DecodeUtils.getDecodedString(password), WaitStrategy.PRESENCE,"password");
		return this;
	}

	public AccountPage clickOnLoginBtn() {
		click(Btnlogin, WaitStrategy.CLICKABLE,"Login Btn");
		return new AccountPage();
	}
	
	public String getTitle(){
		return DriverManager.getDriver().getTitle();
	}

}
