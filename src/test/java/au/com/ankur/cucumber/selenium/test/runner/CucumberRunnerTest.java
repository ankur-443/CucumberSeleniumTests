package au.com.ankur.cucumber.selenium.test.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * 
 * @author Ankur
 * Cucumber Runner class.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/cucumber-report/", "json:target/cucumber.json"},
glue = {"au.com.ankur.cucumber.selenium.test.definitions"},
features = ".//src//test//resources//features",
tags="@Google-3,@Google-4")

public class CucumberRunnerTest {

	@BeforeClass
	public static void beforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./lib/driver/chromedriver-2.24-mac");
		System.setProperty("webdriver.ie.driver", "./lib/driver/IEDriverServer.exe");
		//System.setProperty("webdriver.safari.driver","C:/safaridriver.exe");
		System.setProperty("webdriver.gecko.driver","./lib/driver/geckodriver-9-0");
		System.setProperty("webdriver.safari.noinstall", "true");
		// Clean up screenshot directory before test
		//Utils.cleanScreenshotsDir();
	}
	
	@AfterClass
	public static void afterClass() throws Exception {
		//BrowserContext.getBrowserDriverInstance().close();
	}
	
}
