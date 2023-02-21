package pageUIs.Wordpress.Admin;

public class AdminAddNewPostPageUIs {
	public static final String BLOCK_EDITOR_TEXTBOX ="xpath=//p[contains(@class,'block-editor')]";
	public static final String ADD_TITLE_TEXTBOX ="xpath=//h1[@aria-label='Add title']";
	public static final String PUBLISH_BUTTON ="xpath=//button[text()='Publish']";
	public static final String REPUBLISH_BUTTON ="xpath=//div[contains(@class,'post-publish-panel__content')]//preceding-sibling::div//button[text()='Publish']";
	public static final String POST_PUBLISHED_MESSAGE ="xpath=//div[@class='components-snackbar__content' and contains(text(),'%s')]";

}
