package com.tn.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.tn.annotations.FrameworkAnnotation;
import com.tn.enums.CategoryType;
import com.tn.pages.RegisterPage;
import com.tn.pages.YourStorePage;

public final class TC_RegisterPageTests extends BaseTest{

	private TC_RegisterPageTests() {}
	
	@Test(priority = 1)
	@FrameworkAnnotation(author= {"Jayesh"},category = {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
	public void NewRegisterAccount(Map<String,String> data) {
		String msg = 
		 new YourStorePage()
		    .clickOnMyAccountDrpDown()
		    .clinkOnRegisterLink()
		    .SetFirstname()
		    .SetLastname()
		    .SetEmail()
		    .SetTelePhone()
		    .SetPassword()
		    .SetConfirmPassword()
		    .ClickOnRadioBtn()
		   .ClickOnCheckbox()
		   .ClickOnContinueBtn()
		   .VerifySuccessMsg();
		
		String expectedMsg = "Your Account Has Been Created!";
		Assert.assertEquals(msg, expectedMsg);
	}
	
	@Test(priority = 2)
	@FrameworkAnnotation(author= {"Jayesh"},category = {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
	public void ExistingUserDetails(Map<String,String> data) {
		
	 	
			new YourStorePage()
		      .clickOnMyAccountDrpDown()
		       .clinkOnRegisterLink()
		      .SetFirstname()
		      .SetLastname()
		      .SetEmail()
		      .SetTelePhone()
		      .SetPassword()
		      .SetConfirmPassword()
		      .ClickOnRadioBtn()
		      .ClickOnCheckbox()
		       .ClickOnContinueBtn();
			
			RegisterPage rp = new RegisterPage();
			String msg = rp.WarnigMsg();
			String expected = "Warning: E-Mail Address is already registered!";
			Assert.assertEquals(msg, expected);
					
	}
	
	
	
}
