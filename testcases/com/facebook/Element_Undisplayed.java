package com.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjectFacebook.LoginPageObject;


public class Element_Undisplayed extends BaseTest {
	@Parameters({"browser","url"})
	@BeforeClass
  public void beforeClass(String browserName, String appUrl) {
	 driver = getBrowserDriver(browserName, appUrl);
	 loginPage = pageObjectFacebook.PageGeneratorManager.getLoginPage(driver);
		
  }
  @Test
  public void Case_01_Element_In_DOM_And_Visible() {
	  loginPage.clickToCreateNewAccountButton();
	  verifyTrue(loginPage.isNumberPhoneOrEmaiTextBoxDisplayed());
	  
  }
  @Test
  public void Case_02_Element_In_DOM_And_Not_Visible() {
	  verifyTrue(loginPage.isReNumberPhoneOrEmaiTextBoxUnDisplayed());
  }
  @Test
  public void Case_03_Element_Not_In_DOM_And_Not_Visible() {
	  loginPage.clickCloseIcon();
	  verifyTrue(loginPage.isFirstNameTextBoxUnDisplayed());
  }
  @AfterClass(alwaysRun = true)
  public void afterClass() {
	  closeBrowserDriver();
  }
  private WebDriver driver;
  private LoginPageObject loginPage;

  
	
}
