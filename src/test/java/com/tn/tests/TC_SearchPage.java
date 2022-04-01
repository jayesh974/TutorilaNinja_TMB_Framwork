package com.tn.tests;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tn.annotations.FrameworkAnnotation;
import com.tn.enums.CategoryType;
import com.tn.pages.SearchPage;
import com.tn.pages.YourStorePage;

public final class TC_SearchPage extends BaseTest{
	
	
	private TC_SearchPage() {}

	
	@Test
	@FrameworkAnnotation(author= {"Jayesh"},category= {CategoryType.SMOKE})
	public void VerifySearchingWithExistingProduct_TC001(Map<String,String> data) {
		
		List<WebElement> productList = new SearchPage().getProductsMeetingSearchCriteria("samsung");
		System.out.println("Product of Search Result are ...");
		
		for (WebElement ele : productList) {
			String pro = ele.getText();
			System.out.println(pro);
		}
	}
	
	@Test
	@FrameworkAnnotation(author= {"Jayesh"},category= {CategoryType.SMOKE})
	public void VerifySearchingWithNonExistingProduct_TC002(Map<String,String> data) {
		
		String msg = new SearchPage().getNoProductMatchTitle("oneplus");
		
		Assert.assertEquals(msg, "There is no product that matches the search criteria.");
		
	}
	
	@Test
	@FrameworkAnnotation(author= {"Jayesh"},category= {CategoryType.SMOKE})
	public void VerifySearchingWithoutProductNmae_TC003(Map<String,String> data) {
		
		String msg = new SearchPage().getNoProductMatchTitle("");
		
		Assert.assertEquals(msg, "There is no product that matches the search criteria.");
		
	}
	
	@Test
	@FrameworkAnnotation(author= {"Jayesh"},category= {CategoryType.SMOKE})
	public void VerifySearchingAfterLogin_TC004(Map<String,String> data) {
		
		String title = 
				new YourStorePage()
				.clickOnMyAccountDrpDown().clinkOnLoginLink()
		        .enterEmailAddress(data.get("username")).enterPassword(data.get("password"))
		        .clickOnLoginBtn().getTitle();
		
		System.out.println(title);
		
		List<WebElement> productList = new SearchPage().getProductsMeetingSearchCriteria("samsung");
		System.out.println("Product of Search Result are ...");
		
		for (WebElement ele : productList) {
			String pro = ele.getText();
			System.out.println(pro);
		}
		
	}
	
	@Test
	@FrameworkAnnotation(author= {"Jayesh"},category= {CategoryType.SMOKE})
	public void VerifySearchUsingTextFromProductDesc_TC007(Map<String,String> data) throws InterruptedException {
		List<WebElement> productlist =
		              new SearchPage()
		             .clickForProductSearch("")
		             .enterProductInsearchCriteriaSearchBox("imac")
		             .clickOnSearchInProductDescCheckBox()
		             .clickOnSearchBtnWithSearchCriteria()
		              .getSearchResultProductList();
		
		System.out.println("007 Product of Search Result are ...");
		
		for (WebElement ele : productlist) {
			String pro = ele.getText();
			System.out.println(pro);
		
		}
			
	}
	
}
