package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObject.AdminPage;
import pageObject.CustomerPage;

public class Customer {
	
	public WebDriver driver;
	AdminPage ap  ;
	CustomerPage cp;
	
	@When("User clicks on dashboard customer")
	public void user_clicks_on_dashboard_customer() throws Exception {
		
//		ap = new AdminPage(driver);
		cp = new CustomerPage(driver);
		
//		Thread.sleep(5000);
		cp.clickOnCutomer();
		
	}

	@When("User clicks on customer subtab")
	public void user_clicks_on_customer_subtab() {
		ap.clickOnCutomerList();

	}

	@When("User clciks on Add new button")
	public void user_clciks_on_add_new_button() {
//		cp = new CustomerPage(driver);
		cp.clickOnAddButton();
		
	}

	@When("User Click enters Customer Info")
	public void user_click_enters_customer_info(String email,String pwd,String fname,String lname,
			String gender,String dob,String Companyname,String taxexempt,
			String newsletter,String custrole,String venornme,String Commnent) {
		
		cp.enterEmailID(email);
		cp.enterPassword(pwd);
		cp.enterFirstName(fname);
		cp.enterLastName(lname);
		cp.clickOnGender(gender);
		cp.entersDOB(dob);
		cp.enterCompanyName(Companyname);
		cp.clickOnIsTaxExempt(taxexempt);
		cp.enterNewLetter(newsletter);
		cp.enterCustomerRole(custrole);
		cp.managerOfVendor(venornme);
		cp.clickOnActive();
		cp.enterAdminComment(Commnent);
		
	}

	@When("User Click on save button")
	public void user_click_on_save_button() {
		cp.clickOnsaveButton();
		
	}

	@Then("User confirmation message should appear")
	public void user_confirmation_message_should_appear() {

		Assert.assertTrue(cp.getSuccessmsg().equalsIgnoreCase("The new customer has been added successfully."));
	}
}
