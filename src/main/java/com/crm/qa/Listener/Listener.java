package com.crm.qa.Listener;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.crm.qa.Base.BasePage;


public class Listener extends BasePage implements ITestListener,ISuiteListener{

	public Listener() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext arg0) {
		
		Reporter.log("Testing has Finished");
		System.out.println("Testing has Finished");
	}

	public void onStart(ITestContext arg0) {
		
		System.out.println("Testing has Started");
		
	}

	public void onTestFailure(ITestResult arg0) {
		
		test.info("Test case "+arg0.getName()+" has Failed");
		test.log(Status.SKIP, MarkupHelper.createLabel("Test case "+arg0.getName()+" has Skipped", ExtentColor.RED));
		
		try {
			captureScreenshot(arg0.getName());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	public void onTestSkipped(ITestResult arg0) {
		
		Reporter.log("Test case "+arg0.getName()+" has Skipped", 3);
		test.log(Status.SKIP, MarkupHelper.createLabel("Test case "+arg0.getName()+" has Skipped", ExtentColor.YELLOW));
	}

	public void onTestStart(ITestResult arg0) {
		
		Reporter.log("Test case "+arg0.getName()+" has Started", 3);
		test.log(Status.INFO,"Test case "+arg0.getName()+" has Started");
	}

	public void onTestSuccess(ITestResult arg0) {
		
		Reporter.log("Test case "+arg0.getName()+" has Passed", 1);
		test.log(Status.SKIP, MarkupHelper.createLabel("Test case "+arg0.getName()+" has Passed", ExtentColor.GREEN));
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
