package pageObjectJqueryUploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQueryUpLoadFile.HomePageUIs;

public class HomePageObject extends BasePage {
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean areFileNameLoaded(String[] fileNames) {
		boolean status = false;
		for (String fileName : fileNames) {
			if (isElementDisplay(driver, HomePageUIs.LOADED_FILE_NAME, fileName)) {
				return true;
			} else {
				return status;
			}
		}
		return status;
	}
	public boolean isFileNameLoaded(String fileName) {
		waitForElementVisible(driver, HomePageUIs.LOADED_FILE_NAME, fileName);
		return isElementDisplay(driver, HomePageUIs.LOADED_FILE_NAME, fileName);
	}
	public void clickToStartButton() {
	List<WebElement> starButtons = getListWebElement(driver, HomePageUIs.START_BUTTON);
	for (WebElement starButton : starButtons) {
		starButton.click();
		sleepInsecond(2);
	}
	}
	public boolean isFileNameLoadedSuccessByLink(String fileName) {
		waitForElementVisible(driver, HomePageUIs.UPLOADED_FILE_NAME_BY_LINK, fileName);
		return isElementDisplay(driver, HomePageUIs.UPLOADED_FILE_NAME_BY_LINK, fileName);
	}
	public boolean isFileNameLoadedSuccessByImg(String fileName) {
		waitForElementVisible(driver, HomePageUIs.UPLOADED_FILE_NAME_BY_IMG, fileName);
		return isImageLoaded(driver, HomePageUIs.UPLOADED_FILE_NAME_BY_IMG, fileName);
	}

}
