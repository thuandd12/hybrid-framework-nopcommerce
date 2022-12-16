package pageObjectsNopcommerce.user;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIsNopcommerce.User.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public UserRegisterPageObject clickRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	public String getErrorMessageAtFristNameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.FIRTNAME_ERROR_MESSAGE_TEXTBOX);
		return getElementText(driver,  UserRegisterPageUI.FIRTNAME_ERROR_MESSAGE_TEXTBOX);
	}
	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_ERROR_MESSAGE_TEXTBOX);
		return getElementText(driver,  UserRegisterPageUI.LASTNAME_ERROR_MESSAGE_TEXTBOX);
	}
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE_TEXTBOX);
		return getElementText(driver,  UserRegisterPageUI.EMAIL_ERROR_MESSAGE_TEXTBOX);
	}
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE_TEXTBOX);
		return getElementText(driver,  UserRegisterPageUI.PASSWORD_ERROR_MESSAGE_TEXTBOX);
	}
	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE_TEXTBOX);
		return getElementText(driver,  UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE_TEXTBOX);
	}
	
	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
		
	}
	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
		
	}
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
		
	}
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}
	public void inputConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
		
	}
	public String getRegisterSuccesMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public String getExistsEmailErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EXISTS_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EXISTS_EMAIL_ERROR_MESSAGE);
	}

}
