package com.nopcommerce.commons;
import commons.BaseTest;
import pageObjectsNopcommerce.user.UserHomePageObject;
import pageObjectsNopcommerce.user.PageGeneratorManager;
import pageObjectsNopcommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Common_02_Register_And_Cookies extends BaseTest {

	@Parameters("browser")
	@BeforeTest(description = "create new user for all classes test")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		firstName = "duc";
		lastName = "thuan";
		emailAddress = "thuan" + generateFakeNumber() + "@gmail.com";
		password = "123456";

		log.info("Pre-condition - Step 01: Navigate to 'Register' page");
		homePage = homePage.clickToRegisterLink();

		log.info("Pre-condition - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.inputToFirstNameTextbox(firstName);

		log.info("Pre-condition - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Pre-condition - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-condition - Step 05: Enter to Password textbox with value is '" + password + "'");
		registerPage.inputToPasswordTextbox(password);

		log.info("Pre-condition - Step 06: Enter to Confirm Password textbox with value is '" + password + "'");
		registerPage.inputConfirmPasswordTextbox(password);

		log.info("Pre-condition - Step 07: Click to Register button");
		registerPage.clickRegisterButton();

		log.info("Pre-condition - Step 08: Verify succes massage");
		Assert.assertEquals(registerPage.getRegisterSuccesMessage(), "Your registration completed"); 
		
		LoggedCookies = registerPage.getAllCookies(driver);
		
		
	}

	@AfterTest(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private String firstName, lastName;
	public static String emailAddress, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	public static Set<Cookie> LoggedCookies;

}

