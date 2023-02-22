package pageUIs.Wordpress.Admin;

public class AdminPostsSearchPageUIs {
	public static final String ADD_NEW_BUTTON= "xpath=//a[@class='page-title-action']";
	public static final String TITLE_NAME= "xpath=//a[contains(@aria-label,'%s') and @class='row-title']";
	public static final String AUTHOR_NAME= "xpath=//a[contains(@aria-label,'%s') and @class='row-title']//parent::strong//parent::td//following-sibling::td[@class='author column-author']//a";
	public static final String SEARCH_POST_TEXTBOX= "xpath=//input[@id='post-search-input']";
	public static final String SEARCH_POST_BUTTON= "xpath=//input[@id='search-submit']";
	public static final String PUBLISHED_DATE= "xpath=//a[text()='%s']//parent::strong//parent::td//following-sibling::td[@class='date column-date']";
	public static final String EDIT_LINK= "xpath=//a[text()='%s']";
	
	
}
