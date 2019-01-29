package com.test.TWG.PageObject;

import org.openqa.selenium.By;

public class Search {
	
	public static final By btnBrowse = By.xpath(".//android.support.v7.app.ActionBar$Tab//android.widget.TextView [ @text='Browse']");
	public static final By btnSearch = By.id("nz.co.thewarehouse.wow.qat:id/action_search");
	public static final By txtSearch = By.id("nz.co.thewarehouse.wow.qat:id/tv_search");
	public static final By lstResults = By.className("android.view.ViewGroup");
	public static final By lstResultsItems = By.id("nz.co.thewarehouse.wow.qat:id/tile_position ");
	public static final By lstProductItems = By.id("nz.co.thewarehouse.wow.qat:id/product_item_container");
	public static final By btnAddToCart = By.id("nz.co.thewarehouse.wow.qat:id/add_to_cart");
	public static final By btnActionCart = By.id("nz.co.thewarehouse.wow.qat:id/action_cart");	
}
