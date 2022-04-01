package com.tn.pages;

import org.openqa.selenium.By;
import com.tn.enums.WaitStrategy;

public class YourStorePage extends BasePage{
	
	private final By myAccoutnDrpdwn = By.xpath("//span[text()='My Account']//parent::a");
	private final By linkRegister = By.xpath("//a[text()='Register']");
	private final By linkLogin = By.xpath("//a[text()='Login']");
	private final By searchBox = By.xpath("//input[@name='search']");
	
	public YourStorePage clickOnMyAccountDrpDown() {
		click(myAccoutnDrpdwn, WaitStrategy.CLICKABLE, "linkmyAccount");	
		return this;
	}
	
	public LoginPage clinkOnLoginLink() {
		click(linkLogin, WaitStrategy.CLICKABLE,"inkLogin");
		return new LoginPage();
	}
	
	public RegisterPage clinkOnRegisterLink() {
		click(linkRegister, WaitStrategy.CLICKABLE,"inkLogin");
		return new RegisterPage();
	}
	

}
