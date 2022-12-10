package com.nopcommerce.user;

import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_02_LogIn {
	
 
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", projectPath + "\\brownserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		
		firstName = "duc";
		lastName = "thuan";
		registeredEmail = "dthuan" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		unRegisterEmail = "dinh" + generateFakeNumber() + "@gmail.com";
		wrongEmail = "123123";
		wrongPassword = "123321";
		
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
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
	  registerPage.clickLogoutLink();
	  homePage = new HomePageObject(driver);
	  homePage.clickToLoginLink();
	  loginPage = new LoginPageObject(driver);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	  
  }
  @Test
  public void Login_02_Wrong_Email() {
	  homePage.clickToLoginLink();
	  loginPage.sendKeyToEmailTextBox(wrongEmail);
	  loginPage.sendKeyToPasswordTextBox(password);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
  }
  @Test
  public void Login_03_Valid_Unregister_Email() {
	  homePage.clickToLoginLink();
	  loginPage.sendKeyToEmailTextBox(unRegisterEmail);
	  loginPage.sendKeyToPasswordTextBox(password);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageUnregisterEmail(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
  }
  @Test
  public void Login_04_Registered_Email_Do_Not_Enter_Password() {
	  homePage.clickToLoginLink();
	  loginPage.sendKeyToEmailTextBox(registeredEmail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageUnregisterEmail(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	  
  }
  @Test
  public void Login_05_Registered_Email_Wrong_Password() {
	  homePage.clickToLoginLink();
	  loginPage.sendKeyToEmailTextBox(registeredEmail);
	  loginPage.sendKeyToPasswordTextBox(wrongPassword);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageUnregisterEmail(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
  }
  @Test
  public void Login_06_Registered_Email_Enter_The_Correct_Password() {
	  homePage.clickToLoginLink();
	  loginPage.sendKeyToEmailTextBox(registeredEmail);
	  loginPage.sendKeyToPasswordTextBox(password);
	  loginPage.clickToLoginButton();
	  loginPage.isMyAccountLinKDisplay();
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
  private String projectPath = System.getProperty("user.dir");
  public int generateFakeNumber() {
	  Random rand = new Random();
	  return rand.nextInt(9999);
  }

}
