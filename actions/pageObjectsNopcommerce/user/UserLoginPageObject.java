package pageObjectsNopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsNopcommerce.User.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserLoginPageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.USER_LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.USER_LOGIN_BUTTON);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, UserLoginPageUI.USER_EMAIL_ERROR_MESSAGE_TEXTBOX);
		return getElementText(driver, UserLoginPageUI.USER_EMAIL_ERROR_MESSAGE_TEXTBOX);
	}

	public void sendKeyToEmailTextBox(String inputEmail) {
		waitForElementVisible(driver, UserLoginPageUI.USER_EMAIL_TEXTBOX);
		sendkeyToElement(driver,UserLoginPageUI.USER_EMAIL_TEXTBOX, inputEmail);
	}

	public void sendKeyToPasswordTextBox(String inputPassword) {
		waitForElementVisible(driver, UserLoginPageUI.USER_PASSWORD_TEXTBOX);
		sendkeyToElement(driver,UserLoginPageUI.USER_PASSWORD_TEXTBOX, inputPassword);
		
	}

	public String getErrorMessageWrongEmail() {
		waitForElementVisible(driver, UserLoginPageUI.USER_EMAIL_ERROR_MESSAGE_TEXTBOX);
		return getElementText(driver, UserLoginPageUI.USER_EMAIL_ERROR_MESSAGE_TEXTBOX);
	}

	public String getErrorMessageUnregisterEmail() {
		waitForElementVisible(driver, UserLoginPageUI.USER_UNREGISTER_EMAIL_ERROR_MESSAGE_TEXTBOX);
		return getElementText(driver, UserLoginPageUI.USER_UNREGISTER_EMAIL_ERROR_MESSAGE_TEXTBOX);
	}


}
