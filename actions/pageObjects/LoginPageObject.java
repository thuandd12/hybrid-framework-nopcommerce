package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE_TEXTBOX);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE_TEXTBOX);
	}

	public void sendKeyToEmailTextBox(String inputEmail) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver,LoginPageUI.EMAIL_TEXTBOX, inputEmail);
	}

	public void sendKeyToPasswordTextBox(String inputPassword) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX, inputPassword);
		
	}

	public String getErrorMessageWrongEmail() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE_TEXTBOX);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE_TEXTBOX);
	}

	public String getErrorMessageUnregisterEmail() {
		waitForElementVisible(driver, LoginPageUI.UNREGISTER_EMAIL_ERROR_MESSAGE_TEXTBOX);
		return getElementText(driver, LoginPageUI.UNREGISTER_EMAIL_ERROR_MESSAGE_TEXTBOX);
	}

}
