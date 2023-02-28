package pageObjectSauceSite;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.SauceSite.LoginPageUIs;

public class LoginPageObject extends BasePage {
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void enterToUsernameTextbox(String username) {
		waitForElementVisible(driver, LoginPageUIs.USERNAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUIs.USERNAME_TEXTBOX, username);
	}
	public ProductPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUIs.LOGIN_BUTTON);
		 clickToElement(driver, LoginPageUIs.LOGIN_BUTTON);;
		 return PageGeneratorManager.getProductPageObject(driver);
	}
	public void enterPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUIs.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUIs.PASSWORD_TEXTBOX, password);
	}

}
