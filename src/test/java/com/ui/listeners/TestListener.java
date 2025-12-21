package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
	
	Logger logger = LoggerUtility.getLogger(this.getClass());

	// Invoked each time before a test will be invoked
	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
	}

	// Invoked each time a test succeeds.
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " "+" PASSED");
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " "+" PASSED");
	}

	// Invoked each time a test fails.
	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " "+" FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " "+" FAILED");
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
		Object testClass = result.getInstance();
		BrowserUtility browserUtility = ((TestBase)testClass).getInstance();
		String screenshotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
		ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	}

	// Invoked each time a test is skipped.
	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " "+" SKIPPED");
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " "+" SKIPPED");
	}

	// Invoked before running all the test methods belonging to the classes inside
	// the test tag
	public void onStart(ITestContext context) {
		logger.info("Test suite started");
		ExtentReporterUtility.setupSparkReporter("/report.html");
	}

	// Invoked after running all the test methods belonging to the classes inside
	// the test tag
	public void onFinish(ITestContext context) {
		logger.info("Test suite completed");
		ExtentReporterUtility.flushReport();
	}

}
