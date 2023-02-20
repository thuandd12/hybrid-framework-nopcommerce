package pageObjectsWordpressAmin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Wordpress.Admin.AdminPostsSearchPageUIs;

public class AdminPostsSearchPO extends BasePage {
	WebDriver driver;
	public AdminPostsSearchPO(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToAddnewButton() {
		waitForElementClickable(driver, AdminPostsSearchPageUIs.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostsSearchPageUIs.ADD_NEW_BUTTON);
	}

}
