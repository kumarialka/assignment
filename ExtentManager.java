package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public  class ExtentManager {
	
	static ExtentReports reports;
	
 
	
	public static ExtentReports getReports()
	{
		if (reports==null)
		{
			reports = new ExtentReports();
			//sparkReporter = new ExtentSparkReporter("user.dir"+"\\reports");
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\amaresh\\eclipse-workspace\\Kerv\\Reports");
			
			
			sparkReporter.config().setReportName("Regression Tsting");
			sparkReporter.config().setDocumentTitle("Automation Reports");
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setEncoding("utf-8");
			reports.attachReporter(sparkReporter);
			ExtentTest test= reports.createTest("Form fill Test");
			
		}
		return reports;
	}

}
