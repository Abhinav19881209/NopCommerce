package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.*;

public class Login {
	
	public WebDriver driver;
	
	LoginPage lp ;
	
	AdminPage ap ;
	
	private String URL = "https://admin-demo.nopcommerce.com/login";
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
	 
//		WebDriverManager.chromedriver().setup();
//		
//		driver = new ChromeDriver();
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		lp = new LoginPage(driver);
		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String string) {
	  
		driver.get(URL);
		
		Assert.assertTrue(driver.getTitle().equals("Your store. Login"));
	}

	@When("User enters email {string} and Password {string}")
	public void user_enters_email_and_password(String email, String password) {
	
		lp.enterEmailid(email);
		lp.enterPassword(password);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		
		lp.clickLoginBtn();
//		ap = new AdminPage(driver);
		
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String string) {
		ap = new AdminPage(driver);
		Assert.assertTrue(ap.checkPageTitle().equals(string));
		System.out.println("Admin page title verified");
	}

	@Then("User clicks on logout button")
	public void user_clicks_on_logout_button() {
	  
		ap.clickOnButton();
		
	}

	@Then("Check for error message {string}")
	public void check_for_error_message(String errmsg) {
	    
		Assert.assertTrue(lp.checkErrorMsg().equals(errmsg));
	}

	@Then("Check for welcome message {string}")
	public void check_for_welcome_message(String welmsg) {
		
		Assert.assertTrue(lp.checkWelComeMsg().equals(welmsg));
	}
	
	@Then("User close the browser")
	public void user_close_the_browser() {
	    driver.close();
	    driver.quit();
	}
}