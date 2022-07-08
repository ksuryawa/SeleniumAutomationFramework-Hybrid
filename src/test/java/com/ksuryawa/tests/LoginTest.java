package com.ksuryawa.tests;

import com.ksuryawa.annotations.FrameworkAnnotations;
import com.ksuryawa.base.BaseTest;
import com.ksuryawa.entities.TestData;
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
	@FrameworkAnnotations
	public void loginLogoutTest(TestData data) {

		String title = new OrganeHRMLoginPage().enterUserName(data.getUsername())
				.enterPassword(data.getPassword())
				.clickOnLoginButton()
				.clickWelcome()
				.clickLogout()
				.getTitle();

		Assertions.assertThat(title)
				.isEqualTo("OrangeHRM")
				.isNotEmpty();
	}

	@FrameworkAnnotations
	@Test
	public void newTest(TestData data) {

		String title = new OrganeHRMLoginPage().enterUserName(data.getUsername())
				.enterPassword(data.getPassword())
				.clickOnLoginButton()
				.clickWelcome()
				.clickLogout()
				.getTitle();

		Assertions.assertThat(title)
				.isEqualTo("OrangeHRM")
				.isNotEmpty();

	}

}