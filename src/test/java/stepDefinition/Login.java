package stepDefinition;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.*;

public class Login {
	
	public WebDriver driver;
	
	public LoginPage lp ;
	
	public AdminPage ap ;
	
	public CustomerPage cp ;
	
	private String URL = "https://admin-demo.nopcommerce.com/login";
	
	@Before
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();	
	}
	
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		
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
	
	@When("User clicks on dashboard customer")
	public void user_clicks_on_dashboard_customer() {
		
		cp = new CustomerPage(driver);
		cp.clickOnCutomerMenu();
		
	}
	@When("User clicks on customer subtab")
	public void user_clicks_on_customer_subtab() {
		
		cp = new CustomerPage(driver);
		cp.clickOnCutomerlist();
	}

	@When("User clciks on Add new button")
	public void user_clciks_on_add_new_button() {
	   
		cp.clcikOnAddBtn();
	}

	@When("User Click enters Customer Info {string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}")
	public void user_click_enters_customer_info(String emailid, String password, String fname, String lname, 
			String gender, String dob, String companyname, String texexempt, String newsletter, String custrole, String vendor, String comment) throws Exception {
		cp.enterEmailID(emailid);
		cp.enterPassword(password);
		cp.enterFirstName(fname);
		cp.enterLastName(lname);
		cp.clickOnGender(gender);
		cp.entersDOB(dob);
		cp.enterCompanyName(companyname);
		cp.clickOnIsTaxExempt(texexempt);
		cp.enterNewLetter(newsletter);
		cp.enterCustomerRole(custrole);
		cp.managerOfVendor(vendor);
		cp.clickOnActive();
		cp.enterAdminComment(comment);
			
	}

	@When("User Click on save button")
	public void user_click_on_save_button() {
	  
		cp.clickOnsaveButton();
	}

	@Then("User confirmation message should appear")
	public void user_confirmation_message_should_appear() {
			
		Assert.assertTrue(cp.getSuccessmsg().contains("The new customer has been added successfully."));
	}
	
	//search the customer and deleted
	
	@When("Search with an email")
	public void search_with_an_email() {
	 
	}

	@When("Select and click on edit in search result")
	public void select_and_click_on_edit_in_serach_result() {
	   
		
	}

	@When("Delete the record")
	public void delete_the_record() {
	    
		
	}

	@When("User validate the deleted record")
	public void user_validate_the_deleted_record() {
	   
	}
	
}