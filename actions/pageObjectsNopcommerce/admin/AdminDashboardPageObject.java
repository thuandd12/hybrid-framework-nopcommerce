package pageObjectsNopcommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjectsNopcommerce.user.PageGeneratorManager;
import pageUIsNopcommerce.Admin.AdminDashboardPageUI;
import pageUIsNopcommerce.Admin.AdminLoginPageUI;

public class AdminDashboardPageObject extends BasePage {
	private WebDriver driver;
	public AdminDashboardPageObject (WebDriver driver) {
		this.driver = driver;
	}
	public boolean dashboardTextIsDeplay(WebDriver driver) {
		waitForAllElementVisible(driver, AdminDashboardPageUI.DASHBOARD_TEXT);
		return isElementDisplay(driver, AdminDashboardPageUI.DASHBOARD_TEXT);
	}
	
}
