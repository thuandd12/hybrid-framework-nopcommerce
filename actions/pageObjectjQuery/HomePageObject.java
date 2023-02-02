package pageObjectjQuery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUIs;

public class HomePageObject extends BasePage {
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUIs.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUIs.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	
	}
	public void enterToHeaderTextboxByLabel(String valueLabel,String valueInput) {
		waitForElementVisible(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABEL, valueLabel);
		sendkeyToElement(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABEL, valueInput, valueLabel);
		pressKeyToElement(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, valueLabel);
	}
	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUIs.TOTAL_PAGINATION);
		List<String> allRowValueAllPage = new ArrayList<String>();
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUIs.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));
			sleepInsecond(1);
			List<WebElement> allRowEachPage = getListWebElement(driver,HomePageUIs.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		for (String value : allRowValueAllPage) {
			System.out.println(value);
			
		}
		return allRowValueAllPage;
		
	}
	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUIs.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplay(driver, HomePageUIs.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}
	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowIndex, String value) {
		int columnIndex = getElementSize(driver, HomePageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, HomePageUIs.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowIndex,String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUIs.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowIndex,String.valueOf(columnIndex));
	}
	public void selectDropdownByColumnAtRowNumber(String columnName, String rowIndex, String value) {
		int columnIndex = getElementSize(driver, HomePageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUIs.DROPDOWN_BY_NAME, rowIndex,String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUIs.DROPDOWN_BY_NAME, value, rowIndex,String.valueOf(columnIndex));
	}

}
