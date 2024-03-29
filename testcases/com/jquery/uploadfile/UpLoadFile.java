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
	String [] fileNames = {"oto1File","oto2File","oto3File"};
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
		verifyTrue(homePage.isFileNameLoaded(oto1File));
		homePage.clickToStartButton();
		verifyTrue(homePage.isFileNameLoadedSuccessByLink(oto1File));
		verifyTrue(homePage.isFileNameLoadedSuccessByImg(oto1File));
		
		homePage.upLoadMultibleFile(driver, oto2File);
		verifyTrue(homePage.isFileNameLoaded(oto2File));
		homePage.clickToStartButton();
		verifyTrue(homePage.isFileNameLoadedSuccessByLink(oto2File));
		verifyTrue(homePage.isFileNameLoadedSuccessByImg(oto2File));
		
		homePage.upLoadMultibleFile(driver, oto3File);
		verifyTrue(homePage.isFileNameLoaded(oto3File));
		homePage.clickToStartButton();
		verifyTrue(homePage.isFileNameLoadedSuccessByLink(oto3File));
		verifyTrue(homePage.isFileNameLoadedSuccessByImg(oto3File));
		
	}
	@Test
	public void UpLoad_02_Muntiple_File_Per_Time() {
		homePage.refreshCurrentPage(driver);

		homePage.upLoadMultibleFile(driver, oto1File,oto2File,oto3File);
		
		verifyTrue(homePage.isFileNameLoaded(oto1File));
		verifyTrue(homePage.isFileNameLoaded(oto2File));
		verifyTrue(homePage.isFileNameLoaded(oto3File));
		
		homePage.clickToStartButton();
		
		verifyTrue(homePage.isFileNameLoadedSuccessByLink(oto1File));
		verifyTrue(homePage.isFileNameLoadedSuccessByLink(oto2File));
		verifyTrue(homePage.isFileNameLoadedSuccessByLink(oto3File));
		
		verifyTrue(homePage.isFileNameLoadedSuccessByImg(oto1File));
		verifyTrue(homePage.isFileNameLoadedSuccessByImg(oto2File));
		verifyTrue(homePage.isFileNameLoadedSuccessByImg(oto3File));
		
	}
	@AfterClass
	public void afterClass() {
		 driver.quit();
	}
	private WebDriver driver;
	private HomePageObject homePage;

}
