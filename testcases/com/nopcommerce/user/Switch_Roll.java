package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobleConstaints;
import pageObjectsNopcommerce.admin.AdminDashboardPageObject;
import pageObjectsNopcommerce.admin.AdminLoginPageObject;
import pageObjectsNopcommerce.user.PageGeneratorManager;
import pageObjectsNopcommerce.user.UserHomePageObject;
import pageObjectsNopcommerce.user.UserLoginPageObject;
import pageObjectsNopcommerce.user.UserRegisterPageObject;

public class Switch_Roll extends BaseTest {
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
	}
	@Test
	  public void Roll_01_Switch_Roll_User_Page_To_Admin_Page() {
		homePage = PageGeneratorManager.getHomePage(driver);
		firstName = "duc";
		lastName = "thuan";
		registeredEmail = "dthuan" + generateFakeNumber() + "@gmail.com";
		userPassword = "123456";
		adminEmail = "admin@yourstore.com";
		adminPassword = "admin";
		
		homePage = homePage.clickToRegisterLink();
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(registeredEmail);
		registerPage.inputToPasswordTextbox(userPassword);
		registerPage.inputConfirmPasswordTextbox(userPassword);
		registerPage.clickRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccesMessage(), "Your registration completed");
		homePage = homePage.clickLogoutLink(driver);
		homePage = homePage.clickToLoginLink();
		userLoginPage = PageGeneratorManager.getLoginPage(driver);
		userLoginPage.sendKeyToEmailTextBox(registeredEmail);
		userLoginPage.sendKeyToPasswordTextBox(userPassword);
		userLoginPage = userLoginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinKDisplay());
		homePage = homePage.clickLogoutLink(driver);
		
		homePage.openPageUrl(driver, GlobleConstaints.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminLoginPage.loginAdminPage(driver, adminEmail, adminPassword);
		adminDashboard = PageGeneratorManager.getAdminDashboardPage(driver);
		Assert.assertTrue(adminDashboard.dashboardTextIsDeplay(driver));
		adminLoginPage = adminLoginPage.clickToLogoutAtAdminPage(driver);
		
	}
	@Test
	  public void Roll_02_Switch_Roll_User_Page_To_Admin_Page() {
		adminDashboard.openPageUrl(driver, GlobleConstaints.PORTAL_PAGE_URL);
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage = homePage.clickToLoginLink();
		
		
		
		
	}
	@AfterClass
	public void afterClass() {
		 //driver.quit();
	}
	private WebDriver driver;
	private String firstName, lastName, registeredEmail, userPassword,adminEmail,adminPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboard;

}
