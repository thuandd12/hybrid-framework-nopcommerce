package wordpress.adim;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObjectsWordpress.AdminAddNewPostPO;
import pageObjectsWordpress.AdminHomePO;
import pageObjectsWordpress.AdminPostsSearchPO;
import pageObjectsWordpress.AminLoginPO;
import pageObjectsWordpress.PageGeneratorManager;
import pageObjectsWordpress.UserHomePO;
import pageObjectsWordpress.UserUncategorizedPO;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
	@Parameters({"browser","urlAdmin","urlUser"})
	@BeforeClass
  public void beforeClass(String browserName, String urlAdmin,String urlUser) {
		log.info("Pre-Condition - Step 01: Navigate to 'Login Page'");
		this.urlAdmin = urlAdmin;
		this.urlUser = urlUser;
		driver = getBrowserDriver(browserName, this.urlAdmin);
		adminLoginPage = PageGeneratorManager.getAminLoginPO(driver);
		
		log.info("Pre-Condition - Step 02: Enter to 'User Name' textbox with value is '" + userName + "' ");
		adminLoginPage.sendkeyToUserNameTextbox(userName);
		
		log.info("Pre-Condition - Step 03: Enter to 'Password' textbox with value is '" + passWord + "' ");
		adminLoginPage.sendkeyToPasswordTextbox(passWord);
		
		log.info("Pre-Condition - Step 04: Click to 'Login' button");
		adminHomePage = adminLoginPage.clickToLoginButton();
		
		log.info("Pre-Condition - Step 05: verify message login successfull");
		verifyEquals(adminHomePage.getMessageLoginSuccessfull(), "Welcome to Starter Templates!");
  }

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_New_Post - Step 01: click to 'Posts' link");
		adminPostsSearch = adminHomePage.clickToPostsLink();
		
		log.info("Create_New_Post - Step 02: click to 'Add New' button");
		searchPostURL = adminPostsSearch.getsearchPostURL();
		adminAddNewPost = adminPostsSearch.clickToAddnewButton();
		
		log.info("Create_New_Post - Step 03: enter to 'Add title' textbox with value is '" + addTitle + "'");
		adminAddNewPost.sendkeyToAddTitle(addTitle);
		
		log.info("Create_New_Post - Step 04: enter to 'Block Editor' textbox with value is '" + blockEditor + "'");
		adminAddNewPost.sendkeyToBlockEditor(blockEditor);
		
		log.info("Create_New_Post - Step 05: click to 'Publish' button");
		adminAddNewPost.clickToPublishButton();
		
		log.info("Create_New_Post - Step 06: click to 'RePublish' button");
		adminAddNewPost.clickToRePublishButton();
		
		log.info("Create_New_Post - Step 07: verify '" + postPublishedMessage + "' message is deplayed");
		verifyTrue(adminAddNewPost.isPostPublishedMessageDeplayed(postPublishedMessage));

	}

	@Test
	public void Post_02_Search_Post_And_View_Post() { 
		log.info("Search_Post_And_View_Post - Step 01: open 'Search Post' page");
		adminPostsSearch = adminAddNewPost.openSearchPostPageURL(searchPostURL);
		
		log.info("Search_Post_And_View_Post - Step 02: verify '" + addTitle + "' in 'Posts Search' page is deplayed");
		verifyEquals(adminPostsSearch.getTitleNameInPostsSearchPage(addTitle), addTitle);
		
		log.info("Search_Post_And_View_Post - Step 03: verify '"+ author +"' in 'Posts Search' page is deplayed");
		verifyEquals(adminPostsSearch.getAuthorNameInPostsSearchPage(addTitle), author);
		
		log.info("Search_Post_And_View_Post - Step 04: verify '"+ currentDay +"' in 'Posts Search' page is deplayed");
		verifyTrue(adminPostsSearch.isPushedDateDisplayed(addTitle, currentDay));
		
		log.info("Search_Post_And_View_Post - Step 05: sendkey to 'Search Post' textbox with value is '"+ addTitle +"'");
		adminPostsSearch.sendkeyToSearchPostTextbox(addTitle);
		
		log.info("Search_Post_And_View_Post - Step 06: click to 'Search Post' button");
		adminPostsSearch.clickToSearchPostButton();
		
		log.info("Search_Post_And_View_Post - Step 07: verify '" + addTitle + "' in 'Posts Search' page is deplayed");
		verifyEquals(adminPostsSearch.getTitleNameInPostsSearchPage(addTitle), addTitle);
		
		log.info("Search_Post_And_View_Post - Step 08: verify '"+ author +"' in 'Posts Search' page is deplayed");
		verifyEquals(adminPostsSearch.getAuthorNameInPostsSearchPage(addTitle), author); 
		
		log.info("Search_Post_And_View_Post - Step 09: open 'User' page");
		userHomePage = adminPostsSearch.openUserPage(driver, this.urlUser);
		
		log.info("Search_Post_And_View_Post - Step 10: verify '" + addTitle + "' in 'User Home' page is deplayed ");
		verifyTrue(userHomePage.isTitleInRecentPostsDisplayed(addTitle)); 
		
		log.info("Search_Post_And_View_Post - Step 11: click to '" + addTitle + "' in 'Recent Posts' ");
		userUncategorizedPage = userHomePage.clickToTitleInRecentPosts(addTitle);
		
		log.info("Search_Post_And_View_Post - Step 12: verify '" + addTitle + "' in 'Uncategorized' page is deplayed ");
		verifyTrue(userUncategorizedPage.isTitleNameDisplayed(addTitle));
		
		log.info("Search_Post_And_View_Post - Step 13: verify '" + author + "' in 'Uncategorized' page is deplayed ");
		verifyTrue(userUncategorizedPage.isAuthorNameDisplayed(addTitle,author));
		
		log.info("Search_Post_And_View_Post - Step 14: verify '" + blockEditor + "' in 'Uncategorized' page is deplayed ");
		verifyTrue(userUncategorizedPage.isBodyNameDisplayed(blockEditor));
		

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
	  private String addTitle = "Selenium" + generateFakeNumber() ;
	  private String blockEditor = "Customer DropDown" + generateFakeNumber();
	  private String postPublishedMessage = "Post published.";
	  private String author = "automation";
	  private AminLoginPO adminLoginPage; 
	  private AdminHomePO adminHomePage; 
	  private String searchPostURL;
	  private AdminPostsSearchPO adminPostsSearch;
	  private AdminAddNewPostPO adminAddNewPost;
	  private String urlAdmin , urlUser;
	  private String currentDay = getCurrentDay();
	  private UserHomePO userHomePage; 
	  private UserUncategorizedPO userUncategorizedPage; 

	}


