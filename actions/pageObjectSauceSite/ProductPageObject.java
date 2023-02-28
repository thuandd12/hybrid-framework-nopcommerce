package pageObjectSauceSite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.SauceSite.ProductPageUIs;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectWithText(String valueText) {
		selectItemInDefaultDropdown(driver, ProductPageUIs.DROPDOWN_NAME, valueText);
	}

	public boolean isProducNameSortByAscending() {
		ArrayList<String> productName = new ArrayList<String>();
		List<WebElement> productNameList = getListWebElement(driver, ProductPageUIs.NAME_PRODUCT);
		for (WebElement product : productNameList) {
			productName.add(product.getText());
		}
		ArrayList<String> nameProductsNew = new ArrayList<String>();
		for (String product : productName) {
			nameProductsNew.add(product);
		}
		Collections.sort(nameProductsNew);
		return nameProductsNew.equals(productName);
	}

	public boolean isProducNameSortByDscending() {
		ArrayList<String> productName = new ArrayList<String>();
		List<WebElement> productNameList = getListWebElement(driver, ProductPageUIs.NAME_PRODUCT);
		for (WebElement product : productNameList) {
			productName.add(product.getText());
		}
		ArrayList<String> productNameNew = new ArrayList<String>();
		for (String product : productName) {
			productNameNew.add(product);
		}
		Collections.sort(productNameNew);
		Collections.reverse(productNameNew);
		return productNameNew.equals(productName);
	}

	public boolean isProducPriceSortByAscending() {
		ArrayList<Float> productPrice = new ArrayList<Float>();
		List<WebElement> productPriceList = getListWebElement(driver, ProductPageUIs.PRICE_PRODUCT);
		for (WebElement product : productPriceList) {
			productPrice.add(Float.parseFloat(product.getText().replace("$", "")));
		}
		ArrayList<Float> nameProductsNew = new ArrayList<Float>();
		for (Float product : productPrice) {
			nameProductsNew.add(product);
		}

		Collections.sort(nameProductsNew);

		return nameProductsNew.equals(productPrice);
	}

	public boolean isProducPriceSortByDscending() {
		ArrayList<Float> productPrice = new ArrayList<Float>();
		List<WebElement> productPriceList = getListWebElement(driver, ProductPageUIs.PRICE_PRODUCT);
		for (WebElement product : productPriceList) {
			productPrice.add(Float.parseFloat(product.getText().replace("$", "")));
		}
		ArrayList<Float> nameProductsNew = new ArrayList<Float>();
		for (Float product : productPrice) {
			nameProductsNew.add(product);
		}

		Collections.sort(nameProductsNew);
		Collections.reverse(nameProductsNew);

		return nameProductsNew.equals(productPrice);
	}
}
