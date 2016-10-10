package au.com.ankur.cucumber.selenium.test.operations;

import org.openqa.selenium.WebDriver;

/**
 * Browser Context class is to hold the instance of browser driver. 
 *
 */
public class BrowserContext {

	private static WebDriver driver = null;
	
	private BrowserContext(){}
	
	public static void initialize(String launchBrowser) throws Exception {
		if (driver == null) {
			driver = BrowserFactory.getWebDriverInstance(launchBrowser);
		}
	}
	
	public static WebDriver getBrowserDriverInstance() throws Exception {
		if (driver == null) {
			throw new Exception("Call initialize meathod to initialize the instance first...");
		}
		return driver;
	}
	
	public static void setBrowserDriverInstance(WebDriver d){
		driver = d;
	}
}
