package com.comcast.crm.Listners;

import java.io.File;
import java.util.Date;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.generic.baseUtility.BaseClass;

public class ListnersImplementation implements ITestListener, ISuiteListener{
	ExtentReports extentReports;
	ExtentTest test;

	@Override
	public void onStart(ISuite iSuite) {
		Reporter.log("Report Configuraion", true);
		Date d=new Date();
		String date=d.toString().replaceAll(" ", "_").replaceAll(":", "_");
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter("./AdvanceReport/"+date+"ninja.html");
		extentSparkReporter.config().setDocumentTitle("NinjaCRM report");
		extentSparkReporter.config().setReportName("CRM_Report");
		extentSparkReporter.config().setTheme(Theme.DARK);
		
		 extentReports = new ExtentReports();
		 extentReports.attachReporter(extentSparkReporter);
		 extentReports.setSystemInfo("OS", "Windows");
		 extentReports.setSystemInfo("Browser", "Chrome");
		 	
	}
	
	@Override
	public void onFinish(ISuite iSuite) {
		Reporter.log("Backup of the report", true);
		extentReports.flush();
	}
	
	@Override
	public void onTestStart(ITestResult result) { 
		String testCase=result.getMethod().getMethodName();
		//Reporter.log(""+testCase+"Execution started", true);
		 test = extentReports.createTest(testCase);
		test.log(Status.INFO, ""+testCase+"Execution started");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		String testCase=result.getMethod().getMethodName();
		//Reporter.log(""+testCase+"Execution passed", true);
		test.log(Status.PASS, ""+testCase+"Execution passed");
}
	@Override
	public void onTestFailure(ITestResult result) {
		String testCase=result.getMethod().getMethodName();
		//Reporter.log(""+testCase+"Execution failed", true);
		test.log(Status.FAIL, ""+testCase+"Execution failed");
		TakesScreenshot screenshot=(TakesScreenshot)BaseClass.sdriver;
		String src = screenshot.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(src);
		
//		File src= screenshot.getScreenshotAs(OutputType.FILE);
//		Date d=new Date();
//		String date=d.toString().replaceAll(" ", "_").replaceAll(":", "_");
//		File dest=new File("./Screenshot/"+date+"errorShots.png");
//		try {
//			FileHandler.copy(src, dest);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		String testCase=result.getMethod().getMethodName();
		//Reporter.log(""+testCase+"Execution skipped", true);
		test.log(Status.SKIP, ""+testCase+"Execution skipped");
}
}