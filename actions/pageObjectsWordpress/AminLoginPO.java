package pageObjectsWordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Wordpress.Admin.AminLoginPageUIs;

public class AminLoginPO extends BasePage {
	WebDriver driver;
	public AminLoginPO(WebDriver driver) {
		this.driver = driver;
	}
	public void sendkeyToUserNameTextbox(String inputValue) {
		waitForElementVisible(driver, AminLoginPageUIs.USER_NAME_TEXTBOX);
		sendkeyToElement(driver, AminLoginPageUIs.USER_NAME_TEXTBOX, inputValue);
	}
	public void sendkeyToPasswordTextbox(String inputValue) {
		waitForElementVisible(driver, AminLoginPageUIs.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AminLoginPageUIs.PASSWORD_TEXTBOX, inputValue);
	}
	public AdminHomePO clickToLoginButton() {
		waitForElementClickable(driver, AminLoginPageUIs.LOGIN_BUTTON);
		clickToElement(driver, AminLoginPageUIs.LOGIN_BUTTON);
		return  PageGeneratorManager.getAdminHomePO(driver);
	}

}
