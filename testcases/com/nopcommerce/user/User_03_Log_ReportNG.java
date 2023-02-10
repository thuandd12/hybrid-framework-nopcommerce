package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectsNopcommerce.user.UserHomePageObject;
import pageObjectsNopcommerce.user.PageGeneratorManager;
import pageObjectsNopcommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_03_Log_ReportNG extends BaseTest  {
	
	@Parameters("browser")
	@BeforeClass
  public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		firstName = "duc";
		lastName = "thuan";
		emailAddress = "thuan" + generateFakeNumber() + "@gmail.com";
		password = "123456";
  }
  @Test
  public void Log_01_Register() {
	  log.info("Register - Step 01: Navigate to 'Register' page");
	  homePage = homePage.clickToRegisterLink();
	  
	  log.info("Register - Step 02: Enter to Firstname textbox with value is '"+ firstName +"'");
	  registerPage.inputToFirstNameTextbox(firstName);
	  
	  log.info("Register - Step 03: Enter to Lastname textbox with value is '"+ lastName +"'");
	  registerPage.inputToLastNameTextbox(lastName);
	  
	  log.info("Register - Step 04: Enter to Email textbox with value is '"+ emailAddress +"'");
	  registerPage.inputToEmailTextbox(emailAddress);
	  
	  log.info("Register - Step 05: Enter to Password textbox with value is '"+ password +"'");
	  registerPage.inputToPasswordTextbox(password);
	  
	  log.info("Register - Step 06: Enter to Confirm Password textbox with value is '"+ password +"'");
	  registerPage.inputConfirmPasswordTextbox(password);
	  
	  log.info("Register - Step 07: Click to Register button");
	  registerPage.clickRegisterButton();
	  
	  log.info("Register - Step 08: Verify succes massage");
	  Assert.assertEquals(registerPage.getRegisterSuccesMessage(), "Your registration completed.");
  }
 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  private WebDriver driver;
  private String firstName,lastName,emailAddress,password;
  private UserHomePageObject homePage;
  private UserRegisterPageObject registerPage;
 
}
