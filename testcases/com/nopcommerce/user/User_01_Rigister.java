package com.nopcommerce.user;

import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Rigister {
	
 
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", projectPath + "\\brownserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
		
		firstName = "duc";
		lastName = "thuan";
		emailAddress = "thuan" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		
  }
  @Test
  public void TC_01_Register_With_Empty_Data() {
	  homePage.clickToRegisterLink();
	  registerPage.clickRegisterButton();
	  Assert.assertEquals(registerPage.getErrorMessageAtFristNameTextbox(), "First name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
	  Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	  
  }
  @Test
  public void TC_02_Register_With_Invalid_Email() {
	  homePage.clickToRegisterLink();
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox("1233");
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputConfirmPasswordTextbox(password);
	  registerPage.clickRegisterButton();
	  Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
  }
  @Test
  public void TC_03_Register_With_Valid_Information() {
	  homePage.clickToRegisterLink();
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputConfirmPasswordTextbox(password);
	  registerPage.clickRegisterButton();
	  Assert.assertEquals(registerPage.getRegisterSuccesMessage(), "Your registration completed");
	  
  }
  @Test
  public void TC_04_Register_With_Email_Already_Exists() {
	  registerPage.clickLogoutLink();
	  homePage.clickToRegisterLink();
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputConfirmPasswordTextbox("31244113");
	  registerPage.clickRegisterButton();
	 
  }
  @Test
  public void TC_05_Register_With_Password_Less_Than_6_Characters() {
	  homePage.clickToRegisterLink();
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox("1234");
	  registerPage.inputConfirmPasswordTextbox("1234");
	  registerPage.clickRegisterButton();
	  Assert.assertEquals(registerPage.getMissingCharactersPasswordErrorMessage(), "must have at least 6 characters");
  }
  @Test
  public void TC_06_Register_With_Password_Other_Confirm_Password() {
	  homePage.clickToRegisterLink();
	  registerPage.inputToFirstNameTextbox(firstName);
	  registerPage.inputToLastNameTextbox(lastName);
	  registerPage.inputToEmailTextbox(emailAddress);
	  registerPage.inputToPasswordTextbox("1234");
	  registerPage.inputConfirmPasswordTextbox("1234");
	  registerPage.clickRegisterButton();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  private WebDriver driver;
  private String firstName,lastName,emailAddress,password;
  private HomePageObject homePage;
  private RegisterPageObject registerPage;
  private String projectPath = System.getProperty("user.dir");
  public int generateFakeNumber() {
	  Random rand = new Random();
	  return rand.nextInt(9999);
  }

}
