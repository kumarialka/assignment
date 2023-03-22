package com.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.ExtentManager;
import com.utility.MoveToElement;
import com.utility.PropertiesInit;

public class DynamicCRMDev extends PropertiesInit{
	WebDriver driver = null;
ExtentTest test;
ExtentReports reports;
	@BeforeTest
	public void init()
	{
		ExtentReports reports =ExtentManager.getReports();
		test=reports.createTest("Form Fill Test");
	}
	
	
	@Test
	public void fillForm() throws InterruptedException
	{
		
		
		test.log(Status.INFO, "Starting test case fill form");
		
		
		KervHomePage homepage= new KervHomePage();
		MoveToElement mv = new MoveToElement();
		Properties prop=propinit();
		 driver=homepage.launchBrowser();
		mv.windowHandle(driver);
		driver.manage().window().maximize();
		mv.javaScriptExecute(driver);
		driver.findElement(By.xpath(prop.getProperty("firstname"))).sendKeys("alka");
		driver.findElement(By.xpath(prop.getProperty("lastname"))).sendKeys("kumari");
		driver.findElement(By.id(prop.getProperty("email"))).sendKeys(prop.getProperty("mymail"));
		driver.findElement(By.id(prop.getProperty("phone"))).sendKeys(prop.getProperty("phoneno"));
		mv.uploadfile(driver);
		mv.clickelement(driver, prop.getProperty("Submit"));
		test.log(Status.PASS, "Test Passed");
		
		
		
	}
	@AfterTest
	public void closeBrowser()
	{
		reports.flush();
		driver.quit();
	}
	
	

}
