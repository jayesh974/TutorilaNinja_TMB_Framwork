package com.tn.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.tn.annotations.FrameworkAnnotation;
import com.tn.reports.ExtentLogger;
import com.tn.reports.ExtentReport;

public class ListenerClass implements ITestListener , ISuiteListener{

	public void onStart(ISuite suite) {
			ExtentReport.initReports();
	}

	public void onFinish(ISuite suite) {
			ExtentReport.flushReports();
	}

	public void onTestStart(ITestResult result) {
//	ExtentReport.createTest(result.getMethod().getMethodName());    // to get method name
	ExtentReport.createTest(result.getMethod().getDescription());   // to get method description of method
	ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
			.author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
			.category());

	}

	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+" is passed .");
	}

	public void onTestFailure(ITestResult result) {
		
			ExtentLogger.fail(result.getMethod().getMethodName(), true);
			ExtentLogger.fail(result.getThrowable().toString());
//			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		
	}

	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+" is skiped .");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		/*
		 * We are having just one test in our suite. So we dont have any special implementation as of now
		 */
	}

	public void onStart(ITestContext context) {
		/*
		 * We are having just one test in our suite. So we dont have any special implementation as of now
		 */
	}

	public void onFinish(ITestContext context) {
		/*
		 * We are having just one test in our suite. So we dont have any special implementation as of now
		 */
	}
	

}
