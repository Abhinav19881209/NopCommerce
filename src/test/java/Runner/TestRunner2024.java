package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "D:\\Selenium project\\Selenium_Tutorial_2023\\Selenium_Practice_2024\\Feature\\Customer.feature",
		glue ={"stepDefinition"},
		dryRun = false,
		plugin = { "pretty", "html:target/NopCommerce/Customerfeature.html" }
		)



public class TestRunner2024 {

}
