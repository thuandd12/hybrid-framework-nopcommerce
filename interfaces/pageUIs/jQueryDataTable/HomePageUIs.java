package pageUIs.jQueryDataTable;

public class HomePageUIs {
	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']//parent::div//following-sibling::input";
	public static final String TOTAL_PAGINATION = "xpath=//li[@class='qgrd-pagination-page']";
	public static final String PAGINATION_PAGE_BY_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[%s]/a";
	public static final String PAGINATION_PAGE_ACTIVED_BY_NUMBER = "xpath=//ul[@class='qgrd-pagination-ul']//li//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr//td[@data-key='country']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr//th[text()='%s']//preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX = "xpath=//tbody//tr[%s]//td[%s]//input";
	public static final String DROPDOWN_BY_NAME = "xpath=//tbody//tr[1]//td[4]//select";
	
	public static final String ACCOUNT_LINK_AT_PAGE_USER = "xpath=//span[text()='Account' and @class='label']";
	public static final String REGISTER_LINK_AT_PAGE_USER = "xpath=//a[@title='Register']";
	public static final String REGISTER_TEXTBOX_AT_PAGE_USER = "xpath=//input[@id='%s']";
	public static final String REGISTER_BUTTON_AT_PAGE_USER = "xpath=//span[text()='Register']";
	public static final String WELLCOME_MESSENGE_AT_PAGE_USER = "xpath=//span[text()='Register']";


}
