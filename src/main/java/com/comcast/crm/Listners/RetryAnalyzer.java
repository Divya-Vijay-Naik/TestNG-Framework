package com.comcast.crm.Listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	
	// whenever the testscript is getting failed by default it will get true value
	
	//if we want to rerun the testcases multiple times
	int retryCount=0;
	int maxRetryCount=3;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retryCount<maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}

}
