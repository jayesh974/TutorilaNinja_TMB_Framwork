package com.tn.pages;

import org.openqa.selenium.By;

public final class SuccessPage extends BasePage{
	
	protected SuccessPage() {}
	
	By accountCreatedMsg = By.xpath("//h1[text()='Your Account Has Been Created!']");
	
	public String VerifySuccessMsg(){
		String msg = getText(accountCreatedMsg);
		System.out.println(msg);
		return msg;
	}

}
