package pageObjectsWordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Wordpress.User.UserHomePageUIs;

public class UserHomePO extends BasePage {
	WebDriver driver;
	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isTitleInRecentPostsDisplayed(String addTitle) {
		waitForAllElementVisible(driver, UserHomePageUIs.TITLE_IN_RECENT_POSTS, addTitle);
		return isElementDisplay(driver, UserHomePageUIs.TITLE_IN_RECENT_POSTS, addTitle);
	}
	public UserUncategorizedPO clickToTitleInRecentPosts(String addTitle) {
		waitForElementClickable(driver, UserHomePageUIs.TITLE_IN_RECENT_POSTS, addTitle);
		clickToElement(driver, UserHomePageUIs.TITLE_IN_RECENT_POSTS, addTitle);
		return PageGeneratorManager.getUserUncategorizedPO(driver);
	}
	
}
