package pageObjectsWordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Wordpress.User.UserUncategorizedPageUIs;

public class UserUncategorizedPO extends BasePage{
	WebDriver driver;
	public UserUncategorizedPO(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isTitleNameDisplayed(String addTitle) {
		waitForElementVisible(driver, UserUncategorizedPageUIs.TITLE_NAME, addTitle);
		return isElementDisplay(driver, UserUncategorizedPageUIs.TITLE_NAME, addTitle);
	}
	public boolean isAuthorNameDisplayed(String addTitle, String author) {
		waitForElementVisible(driver, UserUncategorizedPageUIs.AUTHOR_NAME,addTitle,author);
		return isElementDisplay(driver,UserUncategorizedPageUIs.AUTHOR_NAME,addTitle,author);
	}
	public boolean isBodyNameDisplayed(String blockEditor) {
		waitForElementVisible(driver, UserUncategorizedPageUIs.BODY_NAME, blockEditor);
		return isElementDisplay(driver, UserUncategorizedPageUIs.BODY_NAME, blockEditor);
	}

}
