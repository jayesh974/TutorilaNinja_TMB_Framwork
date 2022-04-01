package com.tn.pages;

import org.openqa.selenium.By;
import com.tn.enums.WaitStrategy;

public final class RegisterPage extends BasePage{

	public RegisterPage() {}

	private final By firstname = By.name("firstname");
	private final By lastname = By.name("lastname");
	private final By email = By.name("email");
	private final By telephone = By.name("telephone");
	private final By password = By.name("password");
	private final By confirmpwd = By.name("confirm");
	private final By newsletterRadioBtn = By.xpath("//input[@type = 'radio' and @value = '0']");
	private final By agreeCheckBox = By.name("agree");
	private final By continueBtn = By.cssSelector("[value=Continue]");
	private final By warningMsg = By.cssSelector("div[class *=alert-dismissible]");

	public RegisterPage SetFirstname() {
		sendKeys(firstname, "Jayesh", WaitStrategy.PRESENCE,"First Name");
		return this;
	}

	public RegisterPage SetEmail() {
		sendKeys(email, "jayesh211@gmail.com", WaitStrategy.PRESENCE,"Email Id");
		return this;
	}

	public RegisterPage SetLastname(){
		sendKeys(lastname, "Gangurde", WaitStrategy.PRESENCE,"Last Name");
		return this;
	}

	public RegisterPage SetTelePhone() {
		sendKeys(telephone, "7276460956", WaitStrategy.PRESENCE,"Mobile No. ");
		return this;
	}

	public RegisterPage SetPassword() {
		sendKeys(password, "jayesh@974", WaitStrategy.PRESENCE,"Password");
		return this;
	}

	public RegisterPage SetConfirmPassword(){
		sendKeys(confirmpwd, "jayesh@974", WaitStrategy.PRESENCE,"Confirm Password");
		return this;
	}

	public RegisterPage ClickOnRadioBtn() {
		click(newsletterRadioBtn, WaitStrategy.CLICKABLE, "NewsLetter Radio Btn ");
		return this;
	}

	public RegisterPage ClickOnCheckbox() {
		click(agreeCheckBox, WaitStrategy.CLICKABLE, "Agree Policy CheckBox ");
		return this;
	}

	public SuccessPage ClickOnContinueBtn() {
		click(continueBtn, WaitStrategy.CLICKABLE, "Contnue Btn ");
		return new SuccessPage();
	}

	public String WarnigMsg() {
	   return getText(warningMsg);
	}

}
