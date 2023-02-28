package com.saucesite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectSauceSite.LoginPageObject;
import pageObjectSauceSite.PageGeneratorManager;
import pageObjectSauceSite.ProductPageObject;

public class Sort_Ascending_And_Descending extends BaseTest {
	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	public void beforeClass(String browserName, String urlAdmin) {
		log.info("Pre-ceding - Step 01 : open Login page");
		driver = getBrowserDriver(browserName, urlAdmin);
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		
		log.info("Pre-ceding - Step 01 : enter to 'Username' textbox with value is '" + username + "' ");
		loginPage.enterToUsernameTextbox(username);
		
		log.info("Pre-ceding - Step 02 : enter to 'Password' textbox with value is '" + password + "' ");
		loginPage.enterPasswordTextbox(password);
		
		log.info("Pre-ceding - Step 03 : click to 'Login' button");
		productPage = loginPage.clickToLoginButton();

	}

	@Test
	public void Sort_01_By_Name () {
		log.info("Sort_01_By_Name - Step 01 : verify product name from A to Z");
		productPage.selectWithText("Name (A to Z)");
		verifyTrue(productPage.isProducNameSortByAscending());
		
		log.info("Sort_01_By_Name - Step 02 : verify product name from Z to A");
		productPage.selectWithText("Name (Z to A)");
		verifyTrue(productPage.isProducNameSortByDscending());
	}
	@Test
	public void Sort_02_Price () {
		log.info("Sort_02_Price - Step 01 : verify product price from low to high");
		productPage.selectWithText("Price (low to high)");
		verifyTrue(productPage.isProducPriceSortByAscending());
		
		log.info("Sort_02_Price - Step 02 : verify product price from high to low");
		productPage.selectWithText("Price (high to low)");
		verifyTrue(productPage.isProducPriceSortByDscending());
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	ProductPageObject productPage;
	LoginPageObject loginPage;
	String username = "standard_user";
	String password = "secret_sauce";

}
