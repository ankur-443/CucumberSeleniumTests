package au.com.ankur.cucumber.selenium.test.definitions;

import org.openqa.selenium.WebDriverException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * System Hooks class
 *
 */
public class SystemOperations {
	
	@Before
	public static void Before(Scenario scenario){
		System.out.println("**** Starting scenario - " + scenario.getName() + " ****");
	}

	@After
	public static void After(Scenario scenario) throws WebDriverException, Exception{
		String s = String.format("**** Test Status for %s -- %s", scenario.getName(), scenario.getStatus() + " ****");
		System.out.println(s);
		if (scenario.getStatus().equalsIgnoreCase("failed")) {
			
		}
	}
}
