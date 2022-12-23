package pageObjectsNopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsNopcommerce.User.BasePageUI;
import pageUIsNopcommerce.User.UserHomePageUI;
import pageUIsNopcommerce.User.UserLoginPageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public UserHomePageObject clickToRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	public UserHomePageObject clickToLoginLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	public boolean isMyAccountLinKDisplay() {
		waitForElementVisible(driver, UserHomePageUI.MYACCOUNT_LINK);
		return isElementDisplay(driver, UserHomePageUI.MYACCOUNT_LINK);
		
	}
	public UserHomePageObject clickMyAccountLink() {
		waitForElementClickable(driver, UserHomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	public UserHomePageObject goToHomePage(WebDriver driver) {
		waitForElementClickable(driver,UserHomePageUI.GOTOHOMEPAGELINK);
		clickToElement(driver,UserHomePageUI.GOTOHOMEPAGELINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	public UserHomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGOUT_LINK);
		clickToElement(driver, UserHomePageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}
	
}
