package com.test.TWG.Tests;

import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.test.TWG.PageObject.Login;
import com.test.TWG.PageObject.Search;

import io.appium.java_client.MobileElement;

public class TC_AddToCart_003 extends BaseClass {
  @Test
  public void AddItemsToCartByBrowse() {
	  try {
		  if(isElementPresentBy(Search.btnBrowse)) {
			  driver.findElement(Search.btnBrowse).click();
			  logger.log(LogStatus.PASS, "User clicked the browse button successfully");
		  }
		  else {
			  logger.log(LogStatus.FAIL, "Browse option is not available");
		  }
		  
		  List<MobileElement> options = driver.findElements(Search.lstResultsItems);
		  for(MobileElement option : options) {
			  option.click();
			  break;
		  }
		  
		  List<MobileElement> productItems = driver.findElements(Search.lstProductItems);
		  for(MobileElement productItem : productItems) {
			  productItem.click();
			  if(isElementPresentBy(Search.btnAddToCart)) {
				  driver.findElement(Search.btnAddToCart).click();
				  logger.log(LogStatus.PASS, "Item added to cart successfully");
			  }
			  else {
				  captureScreen(driver,"AddItemsToCartByBrowse");
				  logger.log(LogStatus.FAIL, "Add to Cart option is not available");
			  }
			  break;
		  }
		  
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  }
  @Test
  public void AddItemsToCartBySearch() {
	  try {
		  if(isElementPresentBy(Search.btnSearch)) {
			  driver.findElement(Search.btnSearch).click();
			  logger.log(LogStatus.PASS, "User clicked the search button successfully");
		  }
		  else {
			  logger.log(LogStatus.FAIL, "Search option is not available");
		  }
		  if(isElementPresentBy(Search.txtSearch)) {
			  driver.findElement(Search.txtSearch).sendKeys("Books");
			  logger.log(LogStatus.PASS, "User entered the search option successfully");
		  }
		  else {
			  logger.log(LogStatus.FAIL, "No option to enter Search keyword");
		  }
		  WebDriverWait wait = new WebDriverWait(driver,30);
		  wait.until(ExpectedConditions.elementToBeClickable(Search.lstResults));
		  
		  List<MobileElement> results = driver.findElements(Search.lstResults);
		  for(MobileElement result : results) {
			  result.click();
			  break;
		  }
		  
		  wait.until(ExpectedConditions.elementToBeClickable(Search.lstProductItems));
		  List<MobileElement> productItems = driver.findElements(Search.lstProductItems);
		  for(MobileElement productItem : productItems) {
			  productItem.click();
			  if(isElementPresentBy(Search.btnAddToCart)) {
				  driver.findElement(Search.btnAddToCart).click();
				  logger.log(LogStatus.PASS, "Item added to cart successfully");
			  }
			  else {
				  captureScreen(driver,"AddItemsToCartBySearch");
				  logger.log(LogStatus.FAIL, "Add to Cart option is not available");
			  }
			  break;
		  }
		  //Assertion
		  String itemsCount = driver.findElement(Search.btnActionCart).getAttribute("index");
		  if(Integer.parseInt(itemsCount) > 0)  {
			  logger.log(LogStatus.PASS, "Items are available in cart and can proceed with Payment");
		  }
		  else {
			  captureScreen(driver,"AddItemsToCartBySearch-Cart faile");
			  logger.log(LogStatus.FAIL, "Items are not available in cart");
		  }
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  }
}
