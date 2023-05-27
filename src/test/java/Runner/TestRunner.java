package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "D:\\Selenium project\\Selenium_Tutorial_2023\\Selenium_Practice_2024\\Feature",
		glue ={"stepDefinition"},
		plugin = { "pretty", "html:target/NopCommerce/loginfeature.html" }
		)



public class TestRunner {

}
