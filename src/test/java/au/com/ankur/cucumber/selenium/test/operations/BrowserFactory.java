package au.com.ankur.cucumber.selenium.test.operations;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import au.com.ankur.cucumber.selenium.test.util.TestProfiles;

/**
 * Browser Factory class will return the instance of the WebDriver based on the browserName. 
 *
 */
public class BrowserFactory {

	private static WebDriver driver = null;

	public static WebDriver getWebDriverInstance(String launchBrowser) throws Exception {
		if (launchBrowser == null || launchBrowser.length() == 0) {
			throw new Exception("Please provide the launch browser name...");
		}
		if (launchBrowser.equalsIgnoreCase("chrome")) {
			if (TestProfiles.getInstance().getEnableDeviceTesting()) {
				Map<String, String> mobileEmulation = new HashMap<String, String>();
				// Available devices.
				//  deviceName = "Google Nexus 5/7/10", "Samsung Galaxy S4", "Samsung Galaxy Note 3", "Samsung Galaxy Note II";
				//  deviceName = "Apple iPhone 4/5/6";
				mobileEmulation.put("deviceName", TestProfiles.getInstance().getDeviceName());
				Map<String, Object> chromeOptions = new HashMap<String, Object>();
				chromeOptions.put("mobileEmulation", mobileEmulation);
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				driver = new ChromeDriver(capabilities);
			}else{
				driver = new ChromeDriver();
			}
		}else if (launchBrowser.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}else if (launchBrowser.equalsIgnoreCase("firefox")) {
			// Geko Driver will be required for Firefox to work
			// Also Firefox has launched the new driver to support the latest selenium 
			// https://developer.mozilla.org/en-US/docs/Mozilla/QA/Marionette/WebDriver
			// https://github.com/mozilla/geckodriver/releases
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			capabilities.setBrowserName("firefox");
			driver = new MarionetteDriver(capabilities);
		}else if (launchBrowser.equalsIgnoreCase("safari")) {
			// Currently selenium implementation for safari does not support timeouts 
			// https://automatictester.co.uk/2014/03/16/selenium-features-not-implemented-in-safaridriver/
			// https://github.com/seleniumhq/selenium-google-code-issue-archive/issues/6015
			driver = new SafariDriver();
		}
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
