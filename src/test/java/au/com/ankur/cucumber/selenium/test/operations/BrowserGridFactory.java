package au.com.ankur.cucumber.selenium.test.operations;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import au.com.ankur.cucumber.selenium.test.util.TestConstants;


public class BrowserGridFactory {
	
	public static RemoteWebDriver getDriver(String browser) throws MalformedURLException {
		return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getBrowserCapabilities(browser));
	}
	
	private static DesiredCapabilities getBrowserCapabilities(String browserType) {
		DesiredCapabilities capabilities = null;
		switch (browserType) {
		case "firefox":
			System.out.println("Opening firefox driver...");
			capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			capabilities.setBrowserName(TestConstants.FIREFOX);
			capabilities.setCapability("platform", Platform.MAC);
			capabilities.setCapability("version", "ANY");
			return capabilities;
		case "chrome":
			System.out.println("Opening chrome driver...");
			capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("platform", Platform.MAC);
			capabilities.setCapability("browser", "chrome");
			capabilities.setCapability("browserVersion", "53.0");
			capabilities.setCapability("version", "ANY");
			return capabilities;
		case "IE":
			System.out.println("Opening IE driver...");
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability("platform", Platform.WINDOWS);
			//capabilities.setCapability("browser", "IE");
			//capabilities.setCapability("browserVersion", "53.0");
			capabilities.setCapability("version", "ANY");
			return capabilities;
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			return DesiredCapabilities.firefox();
		}
	}

}
