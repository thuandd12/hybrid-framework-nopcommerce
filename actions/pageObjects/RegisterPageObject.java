package pageObjects;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	public String getErrorMessageAtFristNameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.FIRTNAME_ERROR_MESSAGE_TEXTBOX);
		return getElementText(driver,  RegisterPageUI.FIRTNAME_ERROR_MESSAGE_TEXTBOX);
	}
	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE_TEXTBOX);
		return getElementText(driver,  RegisterPageUI.LASTNAME_ERROR_MESSAGE_TEXTBOX);
	}
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE_TEXTBOX);
		return getElementText(driver,  RegisterPageUI.EMAIL_ERROR_MESSAGE_TEXTBOX);
	}
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE_TEXTBOX);
		return getElementText(driver,  RegisterPageUI.PASSWORD_ERROR_MESSAGE_TEXTBOX);
	}
	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE_TEXTBOX);
		return getElementText(driver,  RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE_TEXTBOX);
	}
	
	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
		
	}
	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
		
	}
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
		
	}
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}
	public void inputConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
		
	}
	public String getRegisterSuccesMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}
	public void clickLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
	}
	public String getExistsEmailErrorMessage() {
		waitForElementVisible(driver, RegisterPageUI.EXISTS_EMAIL_ERROR_MESSAGE);
		return getElementText(driver,  RegisterPageUI.EXISTS_EMAIL_ERROR_MESSAGE);
	}

}
