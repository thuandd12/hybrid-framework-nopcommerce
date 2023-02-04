package com.jquery.uploadfile;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectJqueryUploadFile.HomePageObject;


public class UpLoadFile extends BaseTest{
	String oto1File = "oto1.jpg";
	String oto2File = "oto2.jpg";
	String oto3File = "oto3.jpg";
	String [] fileName = {"oto1File","oto2File","oto3File"};
	@Parameters({"browser","url"})
	@BeforeClass
  public void beforeClass(String browserName, String appUrl) {
		//https://blueimp.github.io/jQuery-File-Upload/
	 driver = getBrowserDriver(browserName, appUrl);
	 homePage = pageObjectJqueryUploadFile.PageGeneratorManager.getHomePage(driver);
  }
	@Test
	public void Upload_01_One_File_Per_Time() {
	
		homePage.upLoadMultibleFile(driver, oto1File);
		Assert.assertTrue(homePage.areFileNameLoaded(fileName));
		homePage.upLoadMultibleFile(driver, oto2File);
		Assert.assertTrue(homePage.areFileNameLoaded(fileName));
		homePage.upLoadMultibleFile(driver, oto3File);
		Assert.assertTrue(homePage.areFileNameLoaded(fileName));
	}
	@Test
	public void UpLoad_02_Muntiple_File_Per_Time() {
		
	}
	@AfterClass
	public void afterClass() {
		 driver.quit();
	}
	private WebDriver driver;
	private HomePageObject homePage;

}
