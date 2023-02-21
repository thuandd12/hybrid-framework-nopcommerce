package pageObjectsWordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Wordpress.Admin.AdminHomePageUIs;

public class AdminHomePO extends BasePage {
	WebDriver driver;
	public AdminHomePO(WebDriver driver) {
		this.driver = driver;
	}
	public Object getMessageLoginSuccessfull() {
		waitForElementVisible(driver, AdminHomePageUIs.MESSAGE_LOGIN_SUCCESSFULL);
		return getElementText(driver, AdminHomePageUIs.MESSAGE_LOGIN_SUCCESSFULL);
	}
	public AdminPostsSearchPO clickToPostsLink() {
		waitForElementClickable(driver, AdminHomePageUIs.POSTS_LINK);
		clickToElement(driver, AdminHomePageUIs.POSTS_LINK);
		return PageGeneratorManager.getAdminPostsSearchPO(driver);
	}
	
}
