package com.ksuryawa.tests;

import com.ksuryawa.pages.OrganeHRMLoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public final class LoginTest extends BaseTest {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private LoginTest() {
	}

	@Test
	public void loginLogoutTest() {

		String title = new OrganeHRMLoginPage().enterUserName("Admin")
				.enterPassword("password")
				.clickOnLoginButton()
				.clickWelcome()
				.clickLogout()
				.getTitle();

		Assertions.assertThat(title)
				.isEqualTo("OrangeHRM")
				.isNotEmpty();

	}

}