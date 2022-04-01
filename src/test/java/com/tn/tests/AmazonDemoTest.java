package com.tn.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.tn.annotations.FrameworkAnnotation;
import com.tn.enums.CategoryType;
import com.tn.pages.AmazonHomePage;


public final class AmazonDemoTest extends BaseTest{

	
	private AmazonDemoTest() {}

	/**
	 * Test Name mentioned here should match the column name "testname" in excel sheet.This is mandatory to run this
	 * test. Otherwise it will be ignored. <p>
	 * The match has to be there in both of the RUNMANAGER and TESTDATA sheet.
	 * Set the authors who have the created the test which will be logged to the reports.
	 * Set the category which this particular test case belongs to
	 * @param data HashMap containing all the values of test data needed to run the tests
	 */
	
	@Test
	@FrameworkAnnotation(author= {"Jayesh","Sachin"}, 
	category = {CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
	public void amazonTest(Map<String,String> data) {

		String title =new AmazonHomePage().clickHamburger()
				.clickComputer()
				.clickOnSubMenuItem(data.get("menutext")).getTitle();
	
//		Assertions.assertThat(title).isNotNull();	
		Assert.assertNotNull(title);
	}

	
}
