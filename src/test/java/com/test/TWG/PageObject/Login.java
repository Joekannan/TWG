package com.test.TWG.PageObject;

import org.openqa.selenium.By;

public class Login {
	
	public static final By btnNavigation = By.className("android.widget.ImageButton");
	public static final By btnLogin = By.id("nz.co.thewarehouse.wow.qat:id/btn_login");
	public static final By txtEmail = By.id("nz.co.thewarehouse.wow.qat:id/email");
	public static final By txtPassword = By.id("nz.co.thewarehouse.wow.qat:id/password");
	public static final By btnSignin = By.id("nz.co.thewarehouse.wow.qat:id/login_btn");
	public static final By lblLoggedinUser = By.id("nz.co.thewarehouse.wow.qat:id/tv_user_email");
}
