package com.tn.tests;

import java.util.Map;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.tn.driver.Driver;

public class BaseTest {

	/*
	 * private , protected , default --> public
	 */

	protected BaseTest() {}

	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) { // Map<String,String>

		Map<String, String> map = (Map<String, String>) data[0];
		Driver.initDriver(map.get("browser"));
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quiteDriver();
	}

}
