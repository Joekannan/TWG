package com.test.TWG.Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.TWG.PageObject.Login;
import com.test.TWG.PageObject.Register;

public class TC_Register_002 extends BaseClass{
  @Test
  public void registerUser() {
	  String email = generatingRandomString(6)+"@gmail.com";
	  try {
		  if(isElementPresentBy(Login.btnNavigation)) {
			  driver.findElement(Login.btnNavigation).click();
			  logger.log(LogStatus.PASS, "User clicked the navigation button successfully");
		  }
		  else {
			  logger.log(LogStatus.FAIL, "Navigation option is not available");
		  }
		  if(isElementPresentBy(Register.btnRegister)) {
			  driver.findElement(Register.btnRegister).click();
			  logger.log(LogStatus.PASS, "User clicked the register button successfully");
		  }
		  else {
			  logger.log(LogStatus.FAIL, "No option to click register button");
		  }
		  if(isElementPresentBy(Register.txtFirstName)) {
			  driver.findElement(Register.txtFirstName).sendKeys(generatingRandomString(6));
			  logger.log(LogStatus.PASS, "User entered first name successfully");
		  }
		  else {
			  logger.log(LogStatus.FAIL, "First name is not available");
		  }
		  if(isElementPresentBy(Register.txtLastName)) {
			  driver.findElement(Register.txtLastName).sendKeys(generatingRandomString(6));
			  logger.log(LogStatus.PASS, "User entered last name successfully");
		  }
		  else {
			  logger.log(LogStatus.FAIL, "Last Name is not available");
		  }
		  if(isElementPresentBy(Register.txtEmail)) {
			  driver.findElement(Register.txtEmail).sendKeys(email);
			  logger.log(LogStatus.PASS, "User entered the email address successfully");
		  }
		  else {
			  logger.log(LogStatus.FAIL, "Email option is not available");
		  }
		  if(isElementPresentBy(Register.txtPassword)) {
			  driver.findElement(Register.txtPassword).sendKeys("Password123");
			  logger.log(LogStatus.PASS, "User entered password successfully");
		  }
		  else {
			  logger.log(LogStatus.FAIL, "Password option is not available");
		  }
		  if(isElementPresentBy(Register.btnRegister)) {
			  driver.findElement(Register.btnRegister).click();
			  logger.log(LogStatus.PASS, "User clicked the register button successfully");
		  }
		  else {
			  logger.log(LogStatus.FAIL, "Register option is not available");
		  }
		  
		  WebDriverWait wait = new WebDriverWait(driver,30);
		  wait.until(ExpectedConditions.elementToBeClickable(Login.btnNavigation));
		  
		  //Insert Assert condition
		  if(isElementPresentBy(Login.btnNavigation)) {
			  driver.findElement(Login.btnNavigation).click();
			  if(isElementPresentBy(Login.lblLoggedinUser)) {
				  String username = driver.findElement(Login.lblLoggedinUser).getText();
				  if(username.equals(email)) {
					  Assert.assertTrue(true);
					  logger.log(LogStatus.PASS, "User logged in successfully after registration");
				  }
				  else {
					  captureScreen(driver,"registerUser");
					  Assert.assertFalse(false);
					  logger.log(LogStatus.FAIL, "User Registration failed");
				  }
			  }
		  }
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  
	  
  }
}
