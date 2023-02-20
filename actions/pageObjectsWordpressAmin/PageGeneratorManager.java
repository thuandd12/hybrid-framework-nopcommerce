package pageObjectsWordpressAmin;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static AminLoginPO getAminLoginPO(WebDriver driver) {
		return new AminLoginPO(driver);
	}
	public static AdminHomePO getAdminHomePO(WebDriver driver) {
		return new AdminHomePO(driver);
	}
	public static AdminPostsSearchPO getAdminPostsSearchPO(WebDriver driver) {
		return new AdminPostsSearchPO(driver);
	}
	public static AdminAddNewPostPO getAdminAddNewPostPO(WebDriver driver) {
		return new AdminAddNewPostPO(driver);
	}

}
