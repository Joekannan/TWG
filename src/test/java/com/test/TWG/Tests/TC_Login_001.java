package com.test.TWG.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.TWG.PageObject.Login;

public class TC_Login_001 extends BaseClass{
  @Test
  public void UserLogin() {
	  try {
		  if(isElementPresentBy(Login.btnNavigation)) {
			  driver.findElement(Login.btnNavigation).click();
			  logger.log(LogStatus.PASS, "User clicked the navigation button successfully");
		  }
		  else {
			  logger.log(LogStatus.FAIL, "Navigation option is not available");
		  }
		  if(isElementPresentBy(Login.btnLogin)) {
			  driver.findElement(Login.btnLogin).click();
			  logger.log(LogStatus.PASS, "User clicked the Login button successfully");
		  }
		  else {
			  logger.log(LogStatus.FAIL, "Log in option is not available");
		  }
		  if(isElementPresentBy(Login.txtEmail)) {
			  driver.findElement(Login.txtEmail).sendKeys("Testing@gmail.com");
			  logger.log(LogStatus.PASS, "User entered the email address successfully");
		  }
		  else {
			  logger.log(LogStatus.FAIL, "Enter Email option is not available");
		  }
		  if(isElementPresentBy(Login.txtPassword)) {
			  driver.findElement(Login.txtPassword).sendKeys("Password123");
			  logger.log(LogStatus.PASS, "User entered the password successfully");
		  }
		  else {
			  logger.log(LogStatus.FAIL, "Enter Password option is not available");
		  }
		  if(isElementPresentBy(Login.btnSignin)) {
			  driver.findElement(Login.btnSignin).click();
			  logger.log(LogStatus.PASS, "User clicked Sign in button successfully");
		  }
		  else {
			  logger.log(LogStatus.FAIL, "Sign In option is not available");
		  }
		  
		  WebDriverWait wait = new WebDriverWait(driver,30);
		  wait.until(ExpectedConditions.elementToBeClickable(Login.btnNavigation));
		  
		  //Insert Assert condition
		  if(isElementPresentBy(Login.btnNavigation)) {
			  driver.findElement(Login.btnNavigation).click();
			  if(isElementPresentBy(Login.lblLoggedinUser)) {
				  String username = driver.findElement(Login.lblLoggedinUser).getText();
				  if(username.equals("testing@gmail.com")) {
					  AssertJUnit.assertTrue(true);
					  logger.log(LogStatus.PASS, "User logged in successfully");
				  }
				  else {
					  captureScreen(driver,"loginTest");
					  AssertJUnit.assertFalse(false);
					  logger.log(LogStatus.FAIL, "User failed to log in");
				  }
			  }
		  }
		  
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  

	  
  }
}
