package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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
import pageObjectsNopcommerce.user.UserLoginPageObject;
import pageObjectsNopcommerce.user.UserRegisterPageObject;
import pageObjectsNopcommerce.admin.AdminLoginPageObject;
import pageObjectsNopcommerce.user.PageGeneratorManager;
import pageObjectsNopcommerce.user.UserRewardPointsPageObject;
import pageObjectsWordpress.AdminHomePO;
import pageObjectsWordpress.UserHomePO;
import pageUIs.jQueryUpLoadFile.HomePageUIs;
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
	private By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by=By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("Class=") || locatorType.startsWith("CLASS=")){
			by=By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("Name=") || locatorType.startsWith("NAME=")) {
			by=By.name(locatorType.substring(5));
		}else if (locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS=")) {
			by=By.cssSelector(locatorType.substring(4));
		}else if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("XPath=") || locatorType.startsWith("XpatH=")) {
			by=By.xpath(locatorType.substring(6));
		}else  {
			throw new RuntimeException("Locator type is not supported");
		}
		return by;
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
	public WebElement getWebElement(WebDriver driver,String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}
	private String getDynamicXpath(String locatorType, String... dynamicValues ) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("XPath=") || locatorType.startsWith("XpatH=")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValues);
		}
		return locatorType;
	}
	public List<WebElement> getListWebElement(WebDriver driver,String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}
	public void clickToElement(WebDriver driver,String locatorType) {
		getWebElement(driver, locatorType).click();
	}
	public void clickToElement(WebDriver driver,String locatorType, String... dynamicValues ) {
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
	}
	public void sendkeyToElement(WebDriver driver,String locatorType,String textValue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textValue);
	}
	public void clearValueInElementByDeleteKey(WebDriver driver,String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}
	
	
	public void sendkeyToElement(WebDriver driver,String locatorType,String textValue,String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textValue);
	}
	public String getElementText(WebDriver driver,String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}
	public String getElementText(WebDriver driver,String locatorType,String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
	}
	public void selectItemInDefaultDropdown(WebDriver driver,String locatorType,String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(textItem);
	}
	public void selectItemInDefaultDropdown(WebDriver driver,String locatorType,String textItem,String... dynamicValues) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		select.selectByVisibleText(textItem);
	}
	public String getSelectedItemDefaulDropdown(WebDriver driver,String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}
	public boolean isDropdownMultible(WebDriver driver,String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
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
		List <WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
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
	public String getElementAttribute(WebDriver driver,String locatorType,String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}
	public String getElementCssValue(WebDriver driver,String locatorType,String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}
	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	public int getElementSize(WebDriver driver,String locatorType) {
		return getListWebElement(driver, locatorType).size();
	}
	public int getElementSize(WebDriver driver,String locatorType,String... dynamicValues) {
		return getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).size();
	}
	public void checkToDefaultCheckBoxRadio(WebDriver driver,String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}
	public void checkToDefaultCheckBoxRadio(WebDriver driver,String locatorType,String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}
	public void unCheckToDefaultCheckBox(WebDriver driver,String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}
	public void unCheckToDefaultCheckBox(WebDriver driver,String locatorType,String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		if (element.isSelected()) {
			element.click();
		}
	}
	public void overrideGlobalTimeout(WebDriver driver,long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public boolean isElementDisplay(WebDriver driver,String locatorType) {
		try {
			return getWebElement(driver, locatorType).isDisplayed();
			
		} catch (NoSuchElementException e) {
			return false;
		} 
	}
	public boolean isElementUndisplayed(WebDriver driver,String locatorType) {
		overrideGlobalTimeout(driver, shortTimeOut);
		List<WebElement> elements = getListWebElement(driver, locatorType);
		overrideGlobalTimeout(driver, longTimeOut);
		if (elements.size()==0) {
			System.out.println("Element not in DOM");
			return true;
		} else if (elements.size()>0 && !elements.get(0).isDisplayed()){
			System.out.println("Element in DOM but not visible/displayed");
			return true;
		}else {
			System.out.println("Element in DOM and visible");
		return false;
		}
	}
	
	public boolean isElementDisplay(WebDriver driver,String locatorType,String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
	}
	public boolean isElementEnable(WebDriver driver,String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}
	public boolean isElementSelected(WebDriver driver,String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}
	public void switchToFrameIframe(WebDriver driver,String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public void hoverMouseToElement(WebDriver driver,String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}
	public void pressKeyToElement(WebDriver driver,String locatorType,Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType), key).perform();
	}
	public void pressKeyToElement(WebDriver driver,String locatorType,Keys key,String... dynamicValues ) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)), key).perform();
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

	public void highlightElement(WebDriver driver,String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInsecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver,String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void scrollToElement(WebDriver driver,String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver,String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}


	public String getElementValidationMessage(WebDriver driver,String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver,String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
		return status;
	}
	public boolean isImageLoaded(WebDriver driver,String locatorType,String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));
		return status;
	}
	public void waitForElementVisible(WebDriver driver,String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}
	public void waitForElementVisible(WebDriver driver,String locatorType,String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	/*
	 *wait for element undisplayed in DOM or not in DOM and override implicit timeout
	 */
	public void waitForElementUndisplayed(WebDriver driver,String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeOut);
		overrideGlobalTimeout(driver, shortTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrideGlobalTimeout(driver, longTimeOut);
		
	}
	public void waitForAllElementVisible(WebDriver driver,String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}
	public void waitForAllElementVisible(WebDriver driver,String locatorType,String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	public void waitForElementInVisible(WebDriver driver,String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}
	public void waitForElementInVisible(WebDriver driver,String locatorType,String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	public void waitForAllElementInVisible(WebDriver driver,String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));
	}
	public void waitForAllElementInVisible(WebDriver driver,String locatorType,String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues))));
	}
	public void waitForElementClickable(WebDriver driver,String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}
	public void waitForElementClickable(WebDriver driver,String locatorType,String... dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
	private long longTimeOut = GlobleConstaints.LONG_TIMEOUT;
	private long shortTimeOut = GlobleConstaints.SHORT_TIMEOUT;
	
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
	public BasePage openPagesAtMyAccountByName (WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
		switch (pageName) {
		case "Customer info": 
			return PageGeneratorManager.getCustomerInfoPage(driver);
		case "Addresses": 	
			return PageGeneratorManager.getAddressesPage(driver);
		case "Reward points":
			return PageGeneratorManager.getRewardPointsPage(driver);
		default:
			throw new RuntimeException("Invalid page name at My Account area.");
		}
		
	}
	public void openPagesAtMyAccountByPageName (WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
	}
	public AdminLoginPageObject clickToLogoutAtAdminPage (WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ADMIN_LOGOUT_LINK);
		clickToElement(driver, BasePageUI.ADMIN_LOGOUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
	public void upLoadMultibleFile(WebDriver diver,String...filenames) {
		String filePath = GlobleConstaints.UPLOAD_FILE_FOLDER;
		String fullFileName = "";
		for (String file : filenames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(diver, HomePageUIs.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
	}
	public Set<Cookie> getAllCookies(WebDriver driver ) {
		return driver.manage().getCookies();
	}
	public void  setCookies(WebDriver driver , Set<Cookie> cookies ) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInsecond(2);
	}
	/** Sendkey To Textbox By ID
	 * @param driver
	 * @param idName
	 * @param valueInput
	 */
	public void sendkeyToTextboxByID(WebDriver driver,String idName,String valueInput) {
		waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, idName);
		sendkeyToElement(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, valueInput, idName);
	}
	/** Click To Button By Text
	 * @param driver
	 * @param buttonName
	 */
	public void clickToButtonByText(WebDriver driver, String buttonName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonName);
		clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonName);
	}
	/** Click To Radio Button By Label With Text
	 * @param driver
	 * @param labelText
	 */
	public void clickToRadioButtonByLabel(WebDriver driver,String labelText) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_TEXT, labelText);
		checkToDefaultCheckBoxRadio(driver, BasePageUI.DYNAMIC_RADIO_BUTTON_BY_LABEL_TEXT, labelText);
	}
	public void clickToDropdownByName(WebDriver driver, String dropdownName, String value) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownName);
		selectItemInDefaultDropdown(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, value, dropdownName);
	}
	public UserHomePO openUserPage(WebDriver driver,String UserURL) {
		openPageUrl(driver, UserURL);
		return pageObjectsWordpress.PageGeneratorManager.getUserHomePO(driver);
	}
	public AdminHomePO openAdminPage(WebDriver driver,String UserURL) {
		openPageUrl(driver, UserURL);
		return pageObjectsWordpress.PageGeneratorManager.getAdminHomePO(driver);
	}
}
