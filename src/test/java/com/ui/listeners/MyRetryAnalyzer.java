 package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer{

	//private static final int MAX_NUMBER_OF_ATTEMPTS = 
		//	Integer.parseInt(PropertiesUtil.readProperty(Env.QA, "MAX_NUMBER_OF_ATTEMPTS")); // properties file always accept string only
	
	private static final int MAX_NUMBER_OF_ATTEMPTS = JSONUtility.readJSON(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
	private static int current_attempt = Integer.parseInt(PropertiesUtil.readProperty(Env.QA, "current_attempt"));
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(current_attempt<=MAX_NUMBER_OF_ATTEMPTS) {
			current_attempt++;
			return true;
		}
		
		return false;
	}

}
