package com.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utility.ExtentManager;
import com.utility.MoveToElement;
import com.utility.PropertiesInit;

public class KervHomePage extends PropertiesInit{

	
		
		
	@Test
	public WebDriver launchBrowser() throws InterruptedException {
		


		
		MoveToElement mv = new MoveToElement();
		int i=0;
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		Properties prop=propinit();
		driver.get(prop.getProperty("url"));
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebDriverWait wait = new WebDriverWait(driver,10);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(prop.getProperty("Cookie"))));
		driver.findElement(By.id(prop.getProperty("Cookie"))).click();
		mv.movetoelement(driver, prop.getProperty("Career"));
		mv.clickelement(driver, prop.getProperty("Jobopportunity"));
		mv.javaScriptExecute(driver);
		mv.clickonlist(driver, prop.getProperty("namelocator"), prop.getProperty("name"), prop.getProperty("listlocator"));
		return driver;
		
		
		
	}
	
}
