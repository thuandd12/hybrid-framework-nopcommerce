package commons;

import java.io.File;

public class GlobleConstaints {
	public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFile" + File.separator;
	public static final String DOWNLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "downloadFile";
	public static final String BROWNSER_LOG_FOLDER = PROJECT_PATH + File.separator + "brownserLog";
	public static final String DRAG_DROP_HTML5_FOLDER = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGImage" + File.separator;
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RYTRY_TIMEOUT = 3;
	public static final String TECHPANDA_USER_PAGE_URL = "http://live.techpanda.org/index.php/";
	public static final String TECHPANDA_ADMIN_PAGE_URL = "http://live.techpanda.org/index.php/backendlogin/customer/";
}
