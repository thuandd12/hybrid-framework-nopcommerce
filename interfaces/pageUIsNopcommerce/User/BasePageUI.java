package pageUIsNopcommerce.User;

public class BasePageUI {
	public static final String CUSTOMERINFO_PAGE = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static final String ADDRESSES_PAGE = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String REWARDPOINTS_PAGE = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static final String DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static final String ADMIN_LOGOUT_LINK = "xpath=//a[text()='Logout']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL_TEXT = "xpath=//input[@type='radio']//following-sibling::label[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	

}
