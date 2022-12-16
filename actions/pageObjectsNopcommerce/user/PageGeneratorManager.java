package pageObjectsNopcommerce.user;

import org.openqa.selenium.WebDriver;

import pageObjectsNopcommerce.admin.AdminDashboardPageObject;
import pageObjectsNopcommerce.admin.AdminLoginPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	public static UserLoginPageObject getLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	public static UserRegisterPageObject getRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	public static UserCustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}
	public static UserAddressesPageObject getAddressesPage(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}
	public static UserRewardPointsPageObject getRewardPointsPage(WebDriver driver) {
		return new UserRewardPointsPageObject(driver);
	}
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

}
