	package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectsNopcommerce.user.UserAddressesPageObject;
import pageObjectsNopcommerce.user.UserCustomerInfoPageObject;
import pageObjectsNopcommerce.user.UserHomePageObject;
import pageObjectsNopcommerce.user.UserLoginPageObject;
import pageObjectsNopcommerce.user.PageGeneratorManager;
import pageObjectsNopcommerce.user.UserRegisterPageObject;
import pageObjectsNopcommerce.user.UserRewardPointsPageObject;

public class Dynamic_Locator extends BaseTest {
	@Parameters("browser")
	@BeforeClass
  public void beforeClass (String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		firstName = "duc";
		lastName = "thuan";
		registeredEmail = "dthuan" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		
		homePage = homePage.clickToRegisterLink();
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(registeredEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputConfirmPasswordTextbox(password);
		registerPage.clickRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccesMessage(), "Your registration completed");
		
  }

	@Test
	  public void Switch_Page_01() {
		homePage = homePage.clickToLoginLink();
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage = loginPage.loginPageNop(registeredEmail, password);
		homePage = homePage.clickMyAccountLink();
		customerInfoPage = PageGeneratorManager.getCustomerInfoPage(driver);
		addressesPage = (UserAddressesPageObject) customerInfoPage.openPagesAtMyAccountByName(driver, "Addresses");
		rewardPointsPage = (UserRewardPointsPageObject) addressesPage.openPagesAtMyAccountByName(driver, "Reward points");
		rewardPointsPage.openPagesAtMyAccountByName(driver, "Customer infor");
		
		 
	 }

	@AfterClass
	public void afterClass() {
		 driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName, registeredEmail, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressesPageObject addressesPage;
	private UserRewardPointsPageObject rewardPointsPage;

}

