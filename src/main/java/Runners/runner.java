package Runners;

import java.time.Duration;

import org.testng.annotations.*;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src\\main\\resources\\feature_file\\" }, // Path to feature files
		glue = { "stepdefination" }, // Package for step definitions
		plugin = { "pretty", // For console output
				"html:target/cucumber-reports/Cucumber.html", // HTML report
				"json:target/cucumber-reports/Cucumber.json", // JSON report
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, monochrome = true // To make console output more
)

public class runner extends base {

	@BeforeSuite
	@Parameters({ "browser", "env", "Url_QA", "Url_Dev", "Url_Prod", "features", "tags", "condition" })
	public void env_setup(String browser, String env, String Url_QA, String Url_Dev, String Url_Prod, String features,
			String tags, String condition) {

		Browser = browser;
		Environment(env, Url_QA, Url_Dev, Url_Prod);

		if (!(features.isEmpty())) {
			System.setProperty("cucumber.filter.tags", condition);
			System.out.println(System.getProperty("cucumber.filter.tags"));
		} else if (!(tags.isEmpty())) {
			System.setProperty("cucumber.filter.tags", tags);
			System.out.println(System.getProperty("cucumber.filter.tags"));
		} else {
			System.setProperty("cucumber.filter.tags", "@all");
			System.out.println(System.getProperty("cucumber.filter.tags"));
		}

		System.out.println(Browser);
		driver = launchbrowser(Browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get(url);
	}

	@AfterSuite
	public void browserQuitconfiguration() {
		driver.quit();
	}
}
