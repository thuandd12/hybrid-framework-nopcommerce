package com.nopcommerce.user;

import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_02_LogIn extends BaseTest {
	@Parameters("browser")
	@BeforeClass
  public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		firstName = "duc";
		lastName = "thuan";
		registeredEmail = "dthuan" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		unRegisterEmail = "dinh" + generateFakeNumber() + "@gmail.com";
		wrongEmail = "123123";
		wrongPassword = "123321";
		
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
  public void Login_01_Empty_Data() {
	  registerPage = registerPage.clickLogoutLink();
	  homePage = homePage.clickToLoginLink();
	  loginPage = PageGeneratorManager.getLoginPage(driver);
	  loginPage = loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	  
  }
  @Test
  public void Login_02_Wrong_Email() {
	  homePage = homePage.clickToLoginLink();
	  loginPage.sendKeyToEmailTextBox(wrongEmail);
	  loginPage.sendKeyToPasswordTextBox(password);
	  loginPage = loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
  }
  @Test
  public void Login_03_Valid_Unregister_Email() {
	  homePage = homePage.clickToLoginLink();
	  loginPage.sendKeyToEmailTextBox(unRegisterEmail);
	  loginPage.sendKeyToPasswordTextBox(password);
	  loginPage = loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageUnregisterEmail(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
  }
  @Test
  public void Login_04_Registered_Email_Do_Not_Enter_Password() {
	  homePage = homePage.clickToLoginLink();
	  loginPage.sendKeyToEmailTextBox(registeredEmail);
	  loginPage = loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageUnregisterEmail(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	  
  }
  @Test
  public void Login_05_Registered_Email_Wrong_Password() {
	  homePage = homePage.clickToLoginLink();
	  loginPage.sendKeyToEmailTextBox(registeredEmail);
	  loginPage.sendKeyToPasswordTextBox(wrongPassword);
	  loginPage = loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageUnregisterEmail(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
  }
  @Test
  public void Login_06_Registered_Email_Enter_The_Correct_Password() {
	  homePage = homePage.clickToLoginLink();
	  loginPage.sendKeyToEmailTextBox(registeredEmail);
	  loginPage.sendKeyToPasswordTextBox(password);
	  loginPage = loginPage.clickToLoginButton();
	  Assert.assertTrue(homePage.isMyAccountLinKDisplay());
  }

  @AfterClass
  public void afterClass() {
		driver.quit();
  }
  private WebDriver driver;
  private String firstName,lastName,registeredEmail,unRegisterEmail,wrongEmail,password,wrongPassword;
  private HomePageObject homePage;
  private RegisterPageObject registerPage;
  private LoginPageObject loginPage;

}
