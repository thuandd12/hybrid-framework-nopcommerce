package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import exception.BrownserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driverBaseTest;
	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driverBaseTest = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();;
			driverBaseTest = new FirefoxDriver();
		}else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();
		}else if (browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driverBaseTest = new OperaDriver();
		}else if (browserName.equals("h_firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();	
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new FirefoxDriver(options);
		}else if (browserName.equals("h_chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();	
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new ChromeDriver(options);
	    }else {
			throw new BrownserNotSupport(browserName);
		}
		driverBaseTest.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driverBaseTest.get(GlobleConstaints.PORTAL_PAGE_URL);
		return driverBaseTest;
	}
	protected int generateFakeNumber() {
		  Random rand = new Random();
		  return rand.nextInt(9999);
	  }

}
