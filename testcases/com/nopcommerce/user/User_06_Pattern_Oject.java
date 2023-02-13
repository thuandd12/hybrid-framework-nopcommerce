package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_Register_And_User;

import commons.BaseTest;
import pageObjectsNopcommerce.user.PageGeneratorManager;
import pageObjectsNopcommerce.user.UserHomePageObject;
import pageObjectsNopcommerce.user.UserLoginPageObject;
import pageObjectsNopcommerce.user.UserRegisterPageObject;

public class User_06_Pattern_Oject extends BaseTest {
	@Parameters("browser")
	@BeforeClass
  public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		firstName = "duc";
		lastName = "thuan";
		emailAddress = "dthuan" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		buttonRegister = "Register";
		labelGender = "Male";
		dOBD = "20";
		dOBM = "August";
		dOBY = "1997";
		
		
  }

	@Test
	public void Pattern_Oject_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		homePage = homePage.clickToRegisterLink();
		
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		log.info("Register - Step 02: Enter to Firstname textbox with value is '" + firstName + "'");
		registerPage.sendkeyToTextboxByID(driver, "FirstName", firstName);

		log.info("Register - Step 03: Enter to Lastname textbox with value is '" + lastName + "'");
		registerPage.sendkeyToTextboxByID(driver, "LastName", lastName);

		log.info("Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.sendkeyToTextboxByID(driver, "Email", emailAddress);

		log.info("Register - Step 05: Enter to Password textbox with value is '" + password + "'");
		registerPage.sendkeyToTextboxByID(driver, "Password", password);

		log.info("Register - Step 06: Enter to Confirm Password textbox with value is '" + password + "'");
		registerPage.sendkeyToTextboxByID(driver, "ConfirmPassword", password);

		log.info("Register - Step 07: Click to Register button");
		registerPage.clickToButtonByText(driver,buttonRegister);
		
		log.info("Register - Step 08: Click to Female radio button");
		registerPage.clickToRadioButtonByLabel(driver, labelGender);
		
		log.info("Register - Step 09: Click to 'Day' dropdown");
		registerPage.clickToDropdownByName(driver, "DateOfBirthDay",dOBD);
		
		log.info("Register - Step 10: Click to 'Month' dropdown");
		registerPage.clickToDropdownByName(driver, "DateOfBirthMonth",dOBM);
		
		log.info("Register - Step 11: Click to 'Year' dropdown");
		registerPage.clickToDropdownByName(driver, "DateOfBirthYear",dOBY);

		log.info("Register - Step 00: Verify succes massage");
		Assert.assertEquals(registerPage.getRegisterSuccesMessage(), "Your registration completed");
	}

	@Test
	public void Pattern_Oject_02_Login() { 

		homePage = homePage.clickToLoginLink();

		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPage.sendKeyToEmailTextBox(Common_01_Register_And_User.emailAddress);

		loginPage.sendKeyToPasswordTextBox(Common_01_Register_And_User.password);

		loginPage = loginPage.clickToLoginButton();

	}
	@Test
	  public void Pattern_Oject_03_Login() {
		
	}
	@AfterClass(alwaysRun = true)
	  public void afterClass() {
			closeBrowserDriver();
	  }
	  private WebDriver driver;
	  private String firstName,lastName,emailAddress,password,buttonRegister,labelGender,dOBD,dOBM,dOBY;
	  private UserHomePageObject homePage;
	  private UserRegisterPageObject registerPage;
	  private UserLoginPageObject loginPage;

	}


