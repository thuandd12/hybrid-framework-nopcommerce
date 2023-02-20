package pageObjectsWordpressAmin;

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
		waitForElementVisible(driver, AdminAddNewPostPageUIs.BLOCK_EDITOR_TEXTBOX);
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

}
