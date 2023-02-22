package pageObjectsWordpress;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.BasePage;
import pageUIs.Wordpress.Admin.AdminPostsSearchPageUIs;

public class AdminPostsSearchPO extends BasePage {
	WebDriver driver;
	public AdminPostsSearchPO(WebDriver driver) {
		this.driver = driver;
	}
	public AdminAddNewPostPO clickToAddnewButton() {
		waitForElementClickable(driver, AdminPostsSearchPageUIs.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostsSearchPageUIs.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminAddNewPostPO(driver);
	}
	public String getsearchPostURL() {
		return getCurrentUrl(driver);
	}
	public String getTitleNameInPostsSearchPage(String addTitle) {
		waitForElementVisible(driver, AdminPostsSearchPageUIs.TITLE_NAME, addTitle);
		return getElementText(driver, AdminPostsSearchPageUIs.TITLE_NAME, addTitle);
	}
	public String getAuthorNameInPostsSearchPage(String addTitle) {
		waitForElementVisible(driver, AdminPostsSearchPageUIs.AUTHOR_NAME, addTitle);
		return getElementText(driver, AdminPostsSearchPageUIs.AUTHOR_NAME, addTitle);
	}
	public void sendkeyToSearchPostTextbox(String addTitle) {
		waitForElementVisible(driver, AdminPostsSearchPageUIs.SEARCH_POST_TEXTBOX);
		sendkeyToElement(driver, AdminPostsSearchPageUIs.SEARCH_POST_TEXTBOX, addTitle);
	}
	public void clickToSearchPostButton() {
		waitForElementClickable(driver, AdminPostsSearchPageUIs.SEARCH_POST_TEXTBOX);
		clickToElement(driver, AdminPostsSearchPageUIs.SEARCH_POST_TEXTBOX);
	}
	public boolean isPushedDateDisplayed(String addTitle, String currentDay) {
		waitForElementVisible(driver, AdminPostsSearchPageUIs.PUBLISHED_DATE, addTitle);
		return getElementText(driver, AdminPostsSearchPageUIs.PUBLISHED_DATE, addTitle).contains(currentDay);
	}
	public AdminAddNewPostPO clickToEditLink(String addTitle) {
		waitForElementClickable(driver, AdminPostsSearchPageUIs.EDIT_LINK,addTitle);
		clickToElement(driver, AdminPostsSearchPageUIs.EDIT_LINK,addTitle);
		return PageGeneratorManager.getAdminAddNewPostPO(driver);
	}
	

}
