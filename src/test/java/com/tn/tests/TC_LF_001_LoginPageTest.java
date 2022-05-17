package com.tn.tests;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tn.annotations.FrameworkAnnotation;
import com.tn.enums.CategoryType;
import com.tn.pages.YourStorePage;

public final class TC_LF_001_LoginPageTest extends BaseTest {
	
	private TC_LF_001_LoginPageTest() {}
	
	@Test
	@FrameworkAnnotation(author= {"Jayesh"},category = {CategoryType.REGRESSION})
	public void VerifyLoginTest(Map<String,String> data) {
		
		String title = 
				new YourStorePage()
				.clickOnMyAccountDrpDown().clinkOnLoginLinkFromMyAccountDrpDown()
		        .enterEmailAddress(data.get("username")).enterPassword(data.get("password"))
		        .clickOnLoginBtn().ClickOnLogOutLink().getTitle();
		
		Assert.assertEquals(title, "Account Logout");
		
	}
	
	@Test
	@FrameworkAnnotation(author= {"Jayesh"},category = {CategoryType.REGRESSION,CategoryType.SANITY})
	public void VerifyLoginTestwithWrongCredentials(Map<String,String> data) {
		
		String title = 
				new YourStorePage()
				.clickOnMyAccountDrpDown().clinkOnLoginLinkFromMyAccountDrpDown()
		        .enterEmailAddress(data.get("username")).enterPassword(data.get("password"))
		        .clickOnLoginBtn().ClickOnLogOutLink().getTitle();
		
		Assert.assertEquals(title, "Account Logout");
		
	}
}
