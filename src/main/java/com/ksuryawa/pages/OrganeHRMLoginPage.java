package com.ksuryawa.pages;

import com.ksuryawa.reports.ExtentLogger;
import org.openqa.selenium.By;

/**
 * @author Kapil Suryawanshi
 * 20/06/2022
 */
public final class OrganeHRMLoginPage extends BasePage {


	private static final By txtUserName = By.id("txtUsername");
	private static final By txtPassword = By.id("txtPassword");
	private static final By btnLogin = By.id("btnLogin");

	public OrganeHRMLoginPage enterUserName(String userName) {
		sendKeys(txtUserName, userName);
		ExtentLogger.pass( userName + " entered on page");
		return this;
	}

	public OrganeHRMLoginPage enterPassword(String password) {
		sendKeys(txtPassword, password);
		ExtentLogger.pass( password + " entered on page");
		return this;
	}

	public OrangeHRMHomePage clickOnLoginButton() {
		click(btnLogin);
		return new OrangeHRMHomePage();
	}

	public String getTitle() {
		return getPageTitle();
	}
}