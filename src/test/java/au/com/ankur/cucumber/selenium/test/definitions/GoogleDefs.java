package au.com.ankur.cucumber.selenium.test.definitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

import au.com.ankur.cucumber.selenium.test.operations.BrowserGridFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleDefs {

	public static RemoteWebDriver driver;
	public static String appURL = "http://www.google.com";

	@Given("^I am on google home page using \"(.*?)\"$")
	public void i_am_on_google_home_page(String browser) throws Throwable {
		System.out.println("******************* Starting *******************");
		driver = BrowserGridFactory.getDriver(browser);
		driver.manage().window().maximize();
	}

	@When("^I sarch for \"(.*?)\"$")
	public void i_sarch_for(String arg1) throws Throwable {
		driver.navigate().to(appURL);
		driver.findElement(By.name("q")).sendKeys("Selenium Easy Grid Tutorials");
		driver.findElement(By.name("btnG")).click();
	}

	@Then("^Verify the results list comes up$")
	public void verify_the_results_list_comes_up() throws Throwable {
		Assert.assertTrue("Page title doesn't match", driver.getTitle().equalsIgnoreCase("Google"));
	}

	@After
	public static void After(Scenario scenario) throws WebDriverException, Exception{
		System.out.println("Class After--------" + driver);
		if(driver!=null) {
			System.out.println("Closing browser");
			driver.quit();
		}
	}
}
