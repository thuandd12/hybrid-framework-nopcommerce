package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjectsNopcommerce.user.UserAddressesPageObject;
import pageObjectsNopcommerce.user.UserCustomerInfoPageObject;
import pageObjectsNopcommerce.user.UserHomePageObject;
import pageObjectsNopcommerce.user.UserRegisterPageObject;
import pageObjectsNopcommerce.admin.AdminLoginPageObject;
import pageObjectsNopcommerce.user.PageGeneratorManager;
import pageObjectsNopcommerce.user.UserRewardPointsPageObject;
import pageUIsNopcommerce.Admin.AdminDashboardPageUI;
import pageUIsNopcommerce.User.BasePageUI;
import pageUIsNopcommerce.User.UserHomePageUI;
import pageUIsNopcommerce.User.UserRegisterPageUI;


public class BasePage {
	public static BasePage getBasePageObject() {
		return new  BasePage();
	}
	public void openPageUrl(WebDriver driver,String pageUrl) {
		driver.get(pageUrl);
	}
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	private By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	public String getPageSoureCode(WebDriver driver) {
		return driver.getPageSource();
	}
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	public Alert waitAlertPresent(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	public void acceptAlert(WebDriver driver) {
		waitAlertPresent(driver).accept();
	}
	public void cancelAlert(WebDriver driver) {
		waitAlertPresent(driver).dismiss();
	}
	public String getTextAlert(WebDriver driver) {
		return waitAlertPresent(driver).getText();
	}
	public void sendKeyToAlert(WebDriver driver, String inputValue) {
		waitAlertPresent(driver).sendKeys(inputValue);
	}
	public void switchToWindowById(WebDriver driver, String parentId) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentId)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}
	public void switchToWindowByTitle(WebDriver driver, String titleExpected) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if (title.equals(titleExpected)) {
				break;
			}
		}
	}
	public void closeAllWindowWithoutParentWindow(WebDriver driver, String parentId) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentId)) {
				driver.switchTo().window(window);
				driver.close();
			}
			driver.switchTo().window(parentId);
		}
	}
	private WebElement getWebElement(WebDriver driver,String xpathLocator) {
		return driver.findElement(getByXpath(xpathLocator));
	}
	private List<WebElement> getListWebElement(WebDriver driver,String xpathLocator) {
		return driver.findElements(getByXpath(xpathLocator));
	}
	public void clickToElement(WebDriver driver,String xpathLocator) {
		getWebElement(driver, xpathLocator).click();
	}
	public void sendkeyToElement(WebDriver driver,String xpathLocator,String textValue) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}
	public String getElementText(WebDriver driver,String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}
	public void selectItemInDefaultDropdown(WebDriver driver,String xpathLocator,String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByVisibleText(textItem);
	}
	public String getSelectedItemDefaulDropdown(WebDriver driver,String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	public boolean isDropdownMultible(WebDriver driver,String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}
	public void sleepInsecond(long timeoutInsecond){
		try {
			Thread.sleep(timeoutInsecond *1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void selectItemInCustomeDropdown(WebDriver driver,String parentXpath,String childXpath,String expectedTextItem) {
		getWebElement(driver, parentXpath).click();
		sleepInsecond(1);
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		List <WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInsecond(1);
				item.click();
				break;
			}
		}		
	}
	public String getElementAttribute(WebDriver driver,String xpathLocator,String attributeName) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	}
	public String getElementCssValue(WebDriver driver,String xpathLocator,String propertyName) {
		return getWebElement(driver, xpathLocator).getCssValue(propertyName);
	}
	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	public int getElementSize(WebDriver driver,String xpathLocator) {
		return getListWebElement(driver, xpathLocator).size();
	}
	public void checkToDefaultCheckBoxRadio(WebDriver driver,String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (!element.isSelected()) {
			element.click();
		}
	}
	public void unCheckToDefaultCheckBox(WebDriver driver,String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (element.isSelected()) {
			element.click();
		}
	}
	public boolean isElementDisplay(WebDriver driver,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}
	public boolean isElementEnable(WebDriver driver,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}
	public boolean isElementSelected(WebDriver driver,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}
	public void switchToFrameIframe(WebDriver driver,String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public void hoverMouseToElement(WebDriver driver,String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	}
	public Object executeForBrowser(WebDriver driver,String javaScript) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}
	public boolean isExpectedTextInInnerText(WebDriver driver,String textExpected) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, xpathLocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInsecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
	}

	public void scrollToElement(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
	}
	public void removeAttributeInDOM(WebDriver driver,String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
	}

	public String getElementValidationMessage(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
	}

	public boolean isImageLoaded(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, xpathLocator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	public void waitForElementVisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	public void waitForAllElementVisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}
	public void waitForElementInVisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	public void waitForAllElementInVisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
	}
	public void waitForElementClickable(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}
	private long longTimeOut = 30;
	public UserCustomerInfoPageObject openCustomerInfoPage (WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.CUSTOMERINFO_PAGE);
		clickToElement(driver, BasePageUI.CUSTOMERINFO_PAGE);
		return PageGeneratorManager.getCustomerInfoPage(driver);
	}
	public UserAddressesPageObject openAddressesPage (WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ADDRESSES_PAGE);
		clickToElement(driver, BasePageUI.ADDRESSES_PAGE);
		return PageGeneratorManager.getAddressesPage(driver);
	}
	public UserRewardPointsPageObject openRewardPointsPage (WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.REWARDPOINTS_PAGE);
		clickToElement(driver, BasePageUI.REWARDPOINTS_PAGE);
		return PageGeneratorManager.getRewardPointsPage(driver);
	}
	public AdminLoginPageObject clickToLogoutAtAdminPage (WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ADMIN_LOGOUT_LINK);
		clickToElement(driver, BasePageUI.ADMIN_LOGOUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

	
}
