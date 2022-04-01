package com.tn.driver;

import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.tn.constants.FrameworkConstants;
import com.tn.enums.ConfigProperties;
import com.tn.utils.PropertyUtils;

public final class Driver {

	private Driver() {}

//	private static WebDriver driver;

	public static void initDriver(String browser){
		if (Objects.isNull(DriverManager.getDriver())) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
				WebDriver driver = new ChromeDriver();
				DriverManager.setDriver(driver);
			}
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckoDriverPath());
				WebDriver driver = new FirefoxDriver();
				DriverManager.setDriver(driver);
			}
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));

		}
	}

	public static void quiteDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
