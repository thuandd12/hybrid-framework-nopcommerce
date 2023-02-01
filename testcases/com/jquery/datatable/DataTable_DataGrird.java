package com.jquery.datatable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjectjQuery.HomePageObject;
import pageObjectjQuery.PageGeneratorManager;

public class DataTable_DataGrird extends BaseTest {
	@Parameters({"browser","url"})
	@BeforeClass
  public void beforeClass(String browserName, String appUrl) {
	 driver = getBrowserDriver(browserName, appUrl);
	 homePage = PageGeneratorManager.getHomePage(driver);
		
  }
  @Test
  public void Table_01_Paging() {
	  homePage.openPagingByPageNumber("3");
	  Assert.assertTrue(homePage.isPageNumberActived("3"));
	  homePage.openPagingByPageNumber("10");
	  Assert.assertTrue(homePage.isPageNumberActived("10"));
	  homePage.openPagingByPageNumber("24");
	  Assert.assertTrue(homePage.isPageNumberActived("24"));
	  homePage.openPagingByPageNumber("16");
	  Assert.assertTrue(homePage.isPageNumberActived("16"));
	  homePage.openPagingByPageNumber("9");
	  Assert.assertTrue(homePage.isPageNumberActived("9"));
	 
	  
  }
  @Test
  public void Table_02_Enter_To_Header() {
	  homePage.refreshCurrentPage(driver);
	  homePage.enterToHeaderTextboxByLabel("Females","12253515");
	  homePage.enterToHeaderTextboxByLabel("Country","AFRICA");
	  homePage.enterToHeaderTextboxByLabel("Males","12599691");
	  homePage.enterToHeaderTextboxByLabel("Total","24853148");
	
	  
  }
  @Test
  public void Table_03_Get_Value_Row() {
	  homePage.refreshCurrentPage(driver);
	  allContryValues = homePage.getValueEachRowAtAllPage();
  }
  @Test
  public void Register_04_Email_Already_Exists() {
  }
  @AfterClass
  public void afterClass() {
		driver.quit();
  }
  private WebDriver driver;
  private HomePageObject homePage;
  private List<String> allContryValues;

  
	
}
