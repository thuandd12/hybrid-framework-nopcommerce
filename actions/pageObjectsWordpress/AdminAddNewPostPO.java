package pageObjectsWordpress;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.Wordpress.Admin.AdminAddNewPostPageUIs;

public class AdminAddNewPostPO extends BasePage {
	WebDriver driver;
	public AdminAddNewPostPO(WebDriver driver) {
		this.driver = driver;
	}
	public void sendkeyToAddTitle(String addTitle) {
		waitForElementVisible(driver, AdminAddNewPostPageUIs.ADD_TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminAddNewPostPageUIs.ADD_TITLE_TEXTBOX, addTitle);
	}
	public void sendkeyToBlockEditor(String blockEditor) {
		waitForElementClickable(driver, AdminAddNewPostPageUIs.BLOCK_EDITOR_TEXTBOX);
		clickToElement(driver, AdminAddNewPostPageUIs.BLOCK_EDITOR_TEXTBOX);
		waitForElementVisible(driver, AdminAddNewPostPageUIs.BLOCK_EDITOR_TEXTBOX);
		clearValueInElementByDeleteKey(driver, AdminAddNewPostPageUIs.BLOCK_EDITOR_TEXTBOX);
		sendkeyToElement(driver, AdminAddNewPostPageUIs.BLOCK_EDITOR_TEXTBOX, blockEditor);
	}
	public void clickToPublishButton() {
		waitForElementClickable(driver, AdminAddNewPostPageUIs.PUBLISH_BUTTON);
		clickToElement(driver, AdminAddNewPostPageUIs.PUBLISH_BUTTON);
	}
	public void clickToRePublishButton() {
		waitForElementClickable(driver, AdminAddNewPostPageUIs.REPUBLISH_BUTTON);
		clickToElement(driver, AdminAddNewPostPageUIs.REPUBLISH_BUTTON);
	}
	public boolean isPostPublishedMessageDeplayed(String postPublishedMessage) {
		 waitForAllElementVisible(driver, AdminAddNewPostPageUIs.POST_PUBLISHED_MESSAGE,postPublishedMessage);
		return isElementDisplay(driver,AdminAddNewPostPageUIs.POST_PUBLISHED_MESSAGE,postPublishedMessage);
	}
	public AdminPostsSearchPO openSearchPostPageURL(String searchPostURL) {
		openPageUrl(driver, searchPostURL);
		return PageGeneratorManager.getAdminPostsSearchPO(driver);
	}
	public void sendkeyToEditBodyTextBox(String editBody) {
		waitForElementClickable(driver, AdminAddNewPostPageUIs.BLOCK_EDITOR_TEXTBOX);
		clickToElement(driver, AdminAddNewPostPageUIs.BLOCK_EDITOR_TEXTBOX);
		waitForElementVisible(driver, AdminAddNewPostPageUIs.BLOCK_EDITOR_TEXTBOX);
		//clearValueInElementByDeleteKey(driver, AdminAddNewPostPageUIs.BLOCK_EDITOR_TEXTBOX);
		sendkeyToElement(driver, AdminAddNewPostPageUIs.BLOCK_EDITOR_TEXTBOX,editBody);
	}
	public void clickToUpdateButton() {
		waitForElementClickable(driver, AdminAddNewPostPageUIs.UPDATE_BUTTON);
		clickToElement(driver, AdminAddNewPostPageUIs.UPDATE_BUTTON);
		
	}

	public boolean isUpdatedMessageSuccess() {
		waitForAllElementVisible(driver, AdminAddNewPostPageUIs.POST_PUBLISHED_MESSAGE);
		return isElementDisplay(driver, AdminAddNewPostPageUIs.POST_PUBLISHED_MESSAGE);
	}

}
