package com.test.TWG.Tests;

import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class BaseClass {
  
	public static AndroidDriver driver;
	//Creating Extend Reports and Extext Test Reference Values
	public static ExtentReports report;
	public static ExtentTest logger;
	
	
	  @BeforeTest
	  public void setUp() {
		  	//Set the Desired Capabilities
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", "Samsung");
			caps.setCapability("udid", "ad07160308518ea20f");
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "8.0.0");
			caps.setCapability("appPackage", "nz.co.thewarehouse.wow.qat");
			caps.setCapability("appActivity", "nz.co.thewarehouse.wow.MainActivity");
			caps.setCapability("newCommandTimeout", 1200);	
			
			//Instantiate Appium Driver
			try {
				driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
				driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
				//Create object for Report with file path
				report = new ExtentReports("./Reports/TestReport.html");
				report.startTest("TWG Android app launched successfully");
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
	  }
	
	  @AfterTest
	  public void tearDown() {
		  driver.close();
		  driver.quit();
	  }
//Re-usable function to validate the presence of an element
	  public boolean isElementPresentBy(By by) {
		  
		  boolean blnFlag = false;
		  try {
			  if(driver.findElements(by).size()!=0) {
				  blnFlag = true;
			  }
			  else {
				  blnFlag = false;
			  }
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		return blnFlag;  
	  }
	  
	  
	  public String generatingRandomString(int targetStringLength) {
		  int leftLimit = 97; // letter 'a'
		  int rightLimit = 122; // letter 'z'
		  Random random = new Random();
		  StringBuilder buffer = new StringBuilder(targetStringLength);
		  for (int i = 0; i < targetStringLength; i++) {
			  int randomLimitedInt = leftLimit + (int) 
			  (random.nextFloat() * (rightLimit - leftLimit + 1));
			  buffer.append((char) randomLimitedInt);
		  }
		  String generatedString = buffer.toString();
		  System.out.println(generatedString);
		  return generatedString;
	  }
	  
	  public void captureScreen(WebDriver driver, String tname) throws IOException {
		  TakesScreenshot ts = (TakesScreenshot)driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  File target = new File(System.getProperty("user.dir")+ "/Screenshots/" +tname +".png");
		  FileUtils.copyFile(source, target);
		  System.out.println("Screenshot taken");
	}
}
