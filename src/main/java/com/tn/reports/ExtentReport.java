package com.tn.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tn.enums.CategoryType;
import com.tn.reports.ExtentManager;
import com.tn.constants.FrameworkConstants;

public final class ExtentReport {


	private ExtentReport() {}

	private static ExtentReports extent;

	
	public static void initReports() {
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath()); 
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("TN Report");
			spark.config().setReportName("Tutorial Ninja Project");
		}
	}

	public static void flushReports() {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		
			try {
				Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

	
	public static void createTest(String testcasename) {
		ExtentManager.setExtentTest(extent.createTest(testcasename));
	}
	
	public static void addAuthors(String[] authors) {
		for(String temp:authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}
	}
	
	public static void addCategories(CategoryType [] categories) {
		for(CategoryType temp:categories) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}
	


}
