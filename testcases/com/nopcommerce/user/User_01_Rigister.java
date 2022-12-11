package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Rigister extends BaseTest  {
	
	@Parameters("browser")
	@BeforeClass
  public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		firstName = "duc";
		lastName = "thuan";
		emailAddress = "thuan" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		wrongPassword = "1238283182";
		lessThanSixCharacterPassword = "1234";
  }
  @Test
  public void Register_01_Empty_Data() {
	  homePage = homePage.clickToRegisterLink();
	  registerPage = PageGeneratorManager.getRegisterPage(driver);
	  registerPage = registerPage.clickRegisterButton();
	  Assert.assertEquals(registerPage.getErrorMessageAtFristNameTextbox(), "First name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	  
  }
  @Test
  public void Register_02_Invalid_Email() {
	  homePage = homePage.clickToRegisterLink();
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox("1233");
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputConfirmPasswordTextbox(password);
	  registerPage.clickRegisterButton();
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
  }
  @Test
  public void Register_03_Valid_Information() {
	  homePage = homePage.clickToRegisterLink();
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputConfirmPasswordTextbox(password);
	  registerPage.clickRegisterButton();
	  Assert.assertEquals(registerPage.getRegisterSuccesMessage(), "Your registration completed");
	  
  }
  @Test
  public void Register_04_Email_Already_Exists() {
	  registerPage = registerPage.clickLogoutLink();
	  homePage = homePage.clickToRegisterLink();
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputConfirmPasswordTextbox(password);
	  registerPage.clickRegisterButton();
	  Assert.assertEquals(registerPage.getExistsEmailErrorMessage(), "The specified email already exists");
	 
  }
  @Test
  public void Register_05_Password_Less_Than_6_Characters() {
	  homePage = homePage.clickToRegisterLink();
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(lessThanSixCharacterPassword);
	  registerPage.inputConfirmPasswordTextbox(lessThanSixCharacterPassword);
	  registerPage.clickRegisterButton();
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
  }
  @Test
  public void Register_06_Password_Other_Confirm_Password() {
	  homePage = homePage.clickToRegisterLink();
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputConfirmPasswordTextbox(wrongPassword);
	  registerPage.clickRegisterButton();
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  private WebDriver driver;
  private String firstName,lastName,emailAddress,password,wrongPassword,lessThanSixCharacterPassword;
  private HomePageObject homePage;
  private RegisterPageObject registerPage;

}
