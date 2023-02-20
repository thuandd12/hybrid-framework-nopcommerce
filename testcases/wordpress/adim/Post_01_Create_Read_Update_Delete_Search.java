package wordpress.adim;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjectsWordpressAmin.AdminAddNewPostPO;
import pageObjectsWordpressAmin.AdminHomePO;
import pageObjectsWordpressAmin.AdminPostsSearchPO;
import pageObjectsWordpressAmin.AminLoginPO;
import pageObjectsWordpressAmin.PageGeneratorManager;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	@Parameters({"browser","appUrl"})
	@BeforeClass
  public void beforeClass(String browserName,String appUrl) {
		log.info("Pre-Condition - Step 01: Navigate to 'Login Page'");
		driver = getBrowserDriver(browserName,appUrl);
		adminLoginPage = PageGeneratorManager.getAminLoginPO(driver);
		
		log.info("Pre-Condition - Step 02: Enter to 'User Name' textbox with value is '" + userName + "' ");
		adminLoginPage.sendkeyToUserNameTextbox(userName);
		
		log.info("Pre-Condition - Step 03: Enter to 'Password' textbox with value is '" + passWord + "' ");
		adminLoginPage.sendkeyToPasswordTextbox(passWord);
		
		log.info("Pre-Condition - Step 04: Click to 'Login' button");
		adminLoginPage.clickToLoginButton();
		adminHomePage=PageGeneratorManager.getAdminHomePO(driver);
		
		log.info("Pre-Condition - Step 05: verify message login successfull");
		verifyEquals(adminHomePage.getMessageLoginSuccessfull(), "Welcome to Starter Templates!");
  }

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_New_Post - Step 01: click to 'Posts' link");
		adminHomePage.clickToPostsLink();
		searchPostURL = adminHomePage.getsearchPostURL();
		
		log.info("Create_New_Post - Step 02: click to 'Add New' button");
		adminPostsSearch = PageGeneratorManager.getAdminPostsSearchPO(driver);
		adminPostsSearch.clickToAddnewButton();
		
		log.info("Create_New_Post - Step 03: enter to 'Add title' textbox with value is '" + addTitle + "'");
		adminAddNewPost = PageGeneratorManager.getAdminAddNewPostPO(driver);
		adminAddNewPost.sendkeyToAddTitle(addTitle);
		
		log.info("Create_New_Post - Step 04: enter to 'Block Editor' textbox with value is '" + blockEditor + "'");
		adminAddNewPost.sendkeyToBlockEditor(blockEditor);
		
		log.info("Create_New_Post - Step 05: click to 'Publish' button");
		adminAddNewPost.clickToPublishButton();
		
		log.info("Create_New_Post - Step 06: click to 'RePublish' button");
		adminAddNewPost.clickToRePublishButton();
		

	}

	@Test
	public void Post_02_() { 

	}
	@Test
	public void Post_03_() { 

	}
	@Test
	public void Post_04_() { 

	}
	@Test
	public void Post_05_() { 

	}
	@AfterClass(alwaysRun = true)
	  public void afterClass() {
			closeBrowserDriver();
	  }
	  private WebDriver driver;
	  private String userName = "automation";
	  private String passWord = "automation";
	  private String addTitle = "Selenium";
	  private String blockEditor = "Customer DropDown";
	  private AminLoginPO adminLoginPage; 
	  private AdminHomePO adminHomePage; 
	  private String searchPostURL;
	  private AdminPostsSearchPO adminPostsSearch;
	  private AdminAddNewPostPO adminAddNewPost;

	}


