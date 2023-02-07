package pageObjectFacebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}
	public boolean isNumberPhoneOrEmaiTextBoxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.NUMBER_PHONE_OR_EMAIL_TEXT_BOX);
		return isElementDisplay(driver, LoginPageUI.NUMBER_PHONE_OR_EMAIL_TEXT_BOX);
	}
	public boolean isReNumberPhoneOrEmaiTextBoxUnDisplayed() {
		waitForElementUndisplayed(driver, LoginPageUI.RE_NUMBER_PHONE_OR_EMAIL_TEXT_BOX);
		return isElementUndisplayed(driver, LoginPageUI.RE_NUMBER_PHONE_OR_EMAIL_TEXT_BOX);
	}
	public void clickCloseIcon() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_ICON);
	}
	public boolean isFirstNameTextBoxUnDisplayed() {
		waitForElementUndisplayed(driver, LoginPageUI.FIRST_NAME_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUI.FIRST_NAME_TEXTBOX);
	}

}
