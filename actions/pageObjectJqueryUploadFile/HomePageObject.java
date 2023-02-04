package pageObjectJqueryUploadFile;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import pageUIs.jQueryUpLoadFile.HomePageUIs;

public class HomePageObject extends BasePage {
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean areFileNameLoaded(String[] fileName) {
		
		return false;
	}

}
