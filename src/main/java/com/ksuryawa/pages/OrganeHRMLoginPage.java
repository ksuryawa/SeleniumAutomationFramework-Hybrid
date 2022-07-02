package com.ksuryawa.pages;

import com.ksuryawa.utils.DecodeUtils;
import com.ksuryawa.utils.PageActionsHelper;
import org.openqa.selenium.By;

/**
 * @author Kapil Suryawanshi
 * 20/06/2022
 */
public final class OrganeHRMLoginPage extends PageActionsHelper {


	private static final By txtUserName = By.id("txtUsername");
	private static final By txtPassword = By.id("txtPassword");
	private static final By btnLogin = By.id("btnLogin");

	public OrganeHRMLoginPage enterUserName(String userName) {
		sendKeys(txtUserName, userName,"Username");
		return this;
	}

	public OrganeHRMLoginPage enterPassword(String password) {
		sendKeys(txtPassword, DecodeUtils.getDecodedString(password),"Password");
		return this;
	}

	public OrangeHRMHomePage clickOnLoginButton() {
		click(btnLogin, "Login Button");
		return new OrangeHRMHomePage();
	}

	public String getTitle() {
		return getPageTitle();
	}
}