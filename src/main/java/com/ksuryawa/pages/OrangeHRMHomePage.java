package com.ksuryawa.pages;

import com.ksuryawa.utils.PageActionsHelper;
import org.openqa.selenium.By;

/**
 * @author Kapil Suryawanshi
 * 20/06/2022
 */
public final class OrangeHRMHomePage extends PageActionsHelper {

	//region Elements
	private final By linkWelcome = By.id("welcome");
	private final By linkLogout = By.xpath("//a[text()='Logout']");

	//endregion

	//region Methods
	public OrangeHRMHomePage clickWelcome() {
	click(linkWelcome, "Welcome link");
		return this;
	}

	public OrganeHRMLoginPage clickLogout() {
		click(linkLogout, "Logout button");
		return new OrganeHRMLoginPage();
	}
	//endregion
}