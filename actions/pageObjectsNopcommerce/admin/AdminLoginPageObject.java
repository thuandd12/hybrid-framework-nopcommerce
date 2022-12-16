package pageObjectsNopcommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjectsNopcommerce.user.PageGeneratorManager;
import pageUIsNopcommerce.Admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;
	public AdminLoginPageObject (WebDriver driver) {
		this.driver = driver;
	}
	public void sendkeyToAdminEmailTextbox (WebDriver driver, String inputEmail) {
		waitForAllElementVisible(driver, AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX);
		sendkeyToElement(driver,AdminLoginPageUI.ADMIN_EMAIL_TEXTBOX, inputEmail);
	}
	public void sendkeyToAdminPasswordTextbox (WebDriver driver, String inputPassword) {
		waitForAllElementVisible(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX);
		sendkeyToElement(driver,AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX, inputPassword);
	}
	public AdminLoginPageObject clickToLoginButton (WebDriver driver) {
		waitForElementClickable(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	
	public AdminLoginPageObject loginAdminPage(WebDriver driver,String valueEmail,String valuePassword) {
		sendkeyToAdminEmailTextbox(driver, valueEmail);
		sendkeyToAdminPasswordTextbox(driver, valuePassword);
		clickToLoginButton(driver);
		return PageGeneratorManager.getAdminLoginPage(driver);
		
	}

}
