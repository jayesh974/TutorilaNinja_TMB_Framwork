package com.tn.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.tn.driver.DriverManager;
import com.tn.enums.WaitStrategy;

public class SearchPage extends BasePage{

	private final By productsMeetingSearchCriteria = By.xpath("//div[@class='row']//h4//a") ;
	private final By noProductMatchTitle = By.xpath("//div[@class='row']//div/p//following-sibling::p");
	private final By productDescriptionCheckBox = By.xpath("//input[@name='description']");
	private final By searchBoxWithSearchCriteria = By.xpath("//input[@name='search' and @placeholder='Keywords']");
	private final By searchBtnWithSearchCriteria = By.xpath("//input[@id='button-search']");

	
	public List<WebElement> getSearchResultProductList() {
		List<WebElement> productList = DriverManager.getDriver().findElements(productsMeetingSearchCriteria);
		return  productList;
	}
	
	public List<WebElement> getProductsMeetingSearchCriteria(String products) {
		return searchForProduct(products).getSearchResultProductList();
	}
	
	public SearchPage clickForProductSearch(String product) {
		searchForProduct(product);
		return this;
	}
	
	public String getNoProductMatchTitle(String product) {
		searchForProduct(product);
		return DriverManager.getDriver().findElement(noProductMatchTitle).getText();
	}
	
	public SearchPage clickOnSearchInProductDescCheckBox() {
		click(productDescriptionCheckBox, WaitStrategy.CLICKABLE, "Search in product descriptions");
		return this ;
	}
	
	public SearchPage enterProductInsearchCriteriaSearchBox(String product) throws InterruptedException {
		DriverManager.getDriver().findElement(searchBoxWithSearchCriteria).sendKeys(product);
		Thread.sleep(3000);
		return this ;
	}
	
	public SearchPage clickOnSearchBtnWithSearchCriteria() {
		click(searchBtnWithSearchCriteria, WaitStrategy.CLICKABLE, "Search Btn With Search Criteria");
		return this;
	}
	
	
}
