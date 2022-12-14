package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.AddressesPageObject;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointsPageObject;

public class Switch_Page_UI extends BaseTest {
	@Parameters("browser")
	@BeforeClass
  public void beforeClass(String browserName) {
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
	  public void Login_01_Swi() {
		homePage = homePage.clickMyAccountLink();
		
		customerInfoPage = PageGeneratorManager.getCustomerInfoPage(driver);
		customerInfoPage.openAddressesPage(driver);
		addressesPage = PageGeneratorManager.getAddressesPage(driver);
		addressesPage.openRewardPointsPage(driver);
		rewardPointsPage = PageGeneratorManager.getRewardPointsPage(driver);
		rewardPointsPage.openCustomerInfoPage(driver);
		
		 
	 }

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	private WebDriver driver;
	private String firstName, lastName, registeredEmail, password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerInfoPageObject customerInfoPage;
	private AddressesPageObject addressesPage;
	private RewardPointsPageObject rewardPointsPage;

}
