package Runner;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "D:\\Selenium project\\Selenium_Tutorial_2023\\Selenium_Practice_2024\\Feature",
		glue ={"stepDefinition"},
		dryRun = false,
		plugin = { "pretty", "html:target/NopCommerce/Customerfeature.html" }
	//	tags = "@Search"
		)


public class TestRunner2024 extends AbstractTestNGCucumberTests{

}
