package com.iGreenData.extentReports;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class reportConfig {

	public static ExtentReports _extentReport;
	public static ExtentTest test;
	String reportPath = System.getProperty("user.dir") + "/reports/";
	String sourceFile = reportPath + "index.html";

	@Before
	public void setupReport() {
		try {
			ExtentSparkReporter htmlReport =	new ExtentSparkReporter(sourceFile);
			htmlReport.config().setTheme(Theme.DARK);
			htmlReport.config().setDocumentTitle("IGreenData Automation");
			htmlReport.config().setReportName("Automation Test Report");
			htmlReport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
			htmlReport.config().setTimelineEnabled(true);
			_extentReport = new ExtentReports();
			_extentReport.setSystemInfo("Automation Tester", "Murthaja");
			_extentReport.setSystemInfo("Project", "IGreenData Application");
			_extentReport.setSystemInfo("OS", System.getProperty("os.name"));
			_extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
			_extentReport.attachReporter(htmlReport);
		} catch (Exception e) {
			Assert.fail("Exception while initialize the extent report "+e.getMessage());
		}
	}
	
	public ExtentTest startTestCase(String testCaseDesc) {
		test = _extentReport.createTest(testCaseDesc);
		return test;
	}
	
	@After
	public void endTestReport() {
		try {
			_extentReport.flush();
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyddMM_HHmm");
			String destinationFile = reportPath + "TestReport_" + now.format(formatter) + ".html";
			FileUtils.copyFile(new File(sourceFile), new File(destinationFile));
		} catch (Exception e) {
			test.fail("Exception while flush extent report "+e.getMessage());
			Assert.fail("Exception while flush extent report "+e.getMessage());
		}
	}
}
