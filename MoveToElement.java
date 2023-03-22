package com.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MoveToElement  {
	public Actions actions=null;
	public void movetoelement(WebDriver driver,String locator ) throws InterruptedException
	{
		
		actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath(locator))).build().perform();
		Thread.sleep(2000);
	}
	public void clickelement(WebDriver driver , String locator) throws InterruptedException
	{ 
		actions = new Actions(driver);
		actions.click(driver.findElement(By.xpath(locator))).build().perform();
		Thread.sleep(2000);
	}
	public void javaScriptExecute(WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1850)", "");
		Thread.sleep(2000);
	}
	public void clickonlist(WebDriver driver,String listlocator,String name, String namelocator)
	{
		int i=0;
	List<WebElement> li = new ArrayList<WebElement>();
	li= driver.findElements(By.xpath(listlocator));
	for ( i=0;i<li.size();i++)
	{
		if (li.get(i).getText().contains(name))
				{actions.click(driver.findElement(By.xpath(namelocator))).build().perform();
		break;
				}
		else
			continue;
				
	}}
	public WebDriver windowHandle(WebDriver driver) throws InterruptedException
	{
		String parentWindow =driver.getWindowHandle();
		Set<String> AllwindowHandles = driver.getWindowHandles();
		Iterator<String> it = AllwindowHandles.iterator();
		String main_window=it.next();
		String child_window =it.next();
		driver.switchTo().window(child_window);
		Thread.sleep(2000);
		return driver;
		
		
	}
	public void uploadfile(WebDriver driver) throws InterruptedException
	{
		WebElement upload_file = driver.findElement(By.id("resume"));
		upload_file.sendKeys("D:\\CV_alka_kumari.pdf");
		driver.findElement(By.xpath(" //label[contains(text(),'Yes, I agree')]")).click();
		/*actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Submit')]"))).build().perform();*/
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,100)", "");
	}
}
