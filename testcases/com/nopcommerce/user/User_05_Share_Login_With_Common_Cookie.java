package com.nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_02_Register_And_Cookies;

import commons.BaseTest;
import pageObjectsNopcommerce.user.UserHomePageObject;
import pageObjectsNopcommerce.user.UserLoginPageObject;
import pageObjectsNopcommerce.user.PageGeneratorManager;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import org.openqa.selenium.WebDriver;

public class User_05_Share_Login_With_Common_Cookie extends BaseTest {
	@Parameters("browser")
	@BeforeClass
  public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		
  }
  @Test
  public void Login_01_Empty_Data() {
	  homePage = homePage.goToHomePage(driver);
	  homePage = homePage.clickToLoginLink();
	  loginPage = PageGeneratorManager.getLoginPage(driver);
	  loginPage.setCookies(driver, Common_02_Register_And_Cookies.LoggedCookies);
	  loginPage.refreshCurrentPage(driver);
	  
	  
  }
  @AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
  
  private WebDriver driver;
  private UserHomePageObject homePage;
  private UserLoginPageObject loginPage ;

}
