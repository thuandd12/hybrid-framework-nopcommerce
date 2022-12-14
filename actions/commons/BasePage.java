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

import pageObjects.AddressesPageObject;
import pageObjects.CustomerInfoPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RewardPointsPageObject;
import pageUIs.BasePageUI;


public class BasePage {
	protected static BasePage getBasePageObject() {
		return new  BasePage();
	}
	protected void openPageUrl(WebDriver driver,String pageUrl) {
		driver.get(pageUrl);
	}
	protected String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	private By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}
	protected String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	protected String getPageSoureCode(WebDriver driver) {
		return driver.getPageSource();
	}
	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	protected Alert waitAlertPresent(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	protected void acceptAlert(WebDriver driver) {
		waitAlertPresent(driver).accept();
	}
	protected void cancelAlert(WebDriver driver) {
		waitAlertPresent(driver).dismiss();
	}
	protected String getTextAlert(WebDriver driver) {
		return waitAlertPresent(driver).getText();
	}
	protected void sendKeyToAlert(WebDriver driver, String inputValue) {
		waitAlertPresent(driver).sendKeys(inputValue);
	}
	protected void switchToWindowById(WebDriver driver, String parentId) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentId)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}
	protected void switchToWindowByTitle(WebDriver driver, String titleExpected) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if (title.equals(titleExpected)) {
				break;
			}
		}
	}
	protected void closeAllWindowWithoutParentWindow(WebDriver driver, String parentId) {
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
	protected void clickToElement(WebDriver driver,String xpathLocator) {
		getWebElement(driver, xpathLocator).click();
	}
	protected void sendkeyToElement(WebDriver driver,String xpathLocator,String textValue) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}
	protected String getElementText(WebDriver driver,String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}
	protected void selectItemInDefaultDropdown(WebDriver driver,String xpathLocator,String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByVisibleText(textItem);
	}
	protected String getSelectedItemDefaulDropdown(WebDriver driver,String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	protected boolean isDropdownMultible(WebDriver driver,String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}
	protected void sleepInsecond(long timeoutInsecond){
		try {
			Thread.sleep(timeoutInsecond *1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	protected void selectItemInCustomeDropdown(WebDriver driver,String parentXpath,String childXpath,String expectedTextItem) {
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
	protected String getElementAttribute(WebDriver driver,String xpathLocator,String attributeName) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	}
	protected String getElementCssValue(WebDriver driver,String xpathLocator,String propertyName) {
		return getWebElement(driver, xpathLocator).getCssValue(propertyName);
	}
	protected String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	protected int getElementSize(WebDriver driver,String xpathLocator) {
		return getListWebElement(driver, xpathLocator).size();
	}
	protected void checkToDefaultCheckBoxRadio(WebDriver driver,String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (!element.isSelected()) {
			element.click();
		}
	}
	protected void unCheckToDefaultCheckBox(WebDriver driver,String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (element.isSelected()) {
			element.click();
		}
	}
	protected boolean isElementDisplay(WebDriver driver,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}
	protected boolean isElementEnable(WebDriver driver,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}
	protected boolean isElementSelected(WebDriver driver,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}
	protected void switchToFrameIframe(WebDriver driver,String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}
	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	protected void hoverMouseToElement(WebDriver driver,String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	}
	protected Object executeForBrowser(WebDriver driver,String javaScript) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	protected String getInnerText(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}
	protected boolean isExpectedTextInInnerText(WebDriver driver,String textExpected) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	protected void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void highlightElement(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, xpathLocator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInsecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	protected void clickToElementByJS(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
	}

	protected void scrollToElement(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
	}
	protected void removeAttributeInDOM(WebDriver driver,String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, xpathLocator));
	}

	protected String getElementValidationMessage(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
	}

	protected boolean isImageLoaded(WebDriver driver,String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, xpathLocator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	protected void waitForElementVisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	protected void waitForAllElementVisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}
	protected void waitForElementInVisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}
	protected void waitForAllElementInVisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
	}
	protected void waitForElementClickable(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}
	private long longTimeOut = 30;
	public CustomerInfoPageObject openCustomerInfoPage (WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.CUSTOMERINFO_PAGE);
		clickToElement(driver, BasePageUI.CUSTOMERINFO_PAGE);
		return PageGeneratorManager.getCustomerInfoPage(driver);
	}
	public AddressesPageObject openAddressesPage (WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ADDRESSES_PAGE);
		clickToElement(driver, BasePageUI.ADDRESSES_PAGE);
		return PageGeneratorManager.getAddressesPage(driver);
	}
	public RewardPointsPageObject openRewardPointsPage (WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.REWARDPOINTS_PAGE);
		clickToElement(driver, BasePageUI.REWARDPOINTS_PAGE);
		return PageGeneratorManager.getRewardPointsPage(driver);
	}
	
}
