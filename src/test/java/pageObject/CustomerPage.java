package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practice.Utilities;

public class CustomerPage {

	WebDriver driver;

	public CustomerPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	Utilities util = new Utilities(driver);

	@FindBy(xpath="//a[@href='/Admin/Customer/Create']")
	private WebElement Addbutton;

	@FindBy(xpath="//button[@name='save']")
	private WebElement savebtn;

	@FindBy(xpath="//input[@id='Email']")
	private WebElement emailadd;

	@FindBy(xpath="//input[@id='Password']")
	private WebElement password;

	@FindBy(xpath="//input[@id='FirstName']")
	private WebElement firstName;

	@FindBy(xpath="//input[@id='LastName']")
	private WebElement lastName;

	@FindBy(xpath="//input[@id='Gender_Male']")
	private WebElement male;

	@FindBy(xpath="//input[@id='Gender_Female']")
	private WebElement female;

	@FindBy(xpath="//input[@id='DateOfBirth']")
	private WebElement dob;

	@FindBy(xpath="//input[@id='Company']")
	private WebElement company;

	@FindBy(xpath="//input[@id='IsTaxExempt']")
	private WebElement istaxexempt;

	@FindBy(xpath="//select[@id='VendorId']")
	private WebElement vendorid;

	@FindBy(xpath="//input[@id='Active']")
	private WebElement active;

	@FindBy(xpath="//*[@id='AdminComment']")
	private WebElement admincomment;

	@FindBy(xpath="//ul[@id = 'SelectedNewsletterSubscriptionStoreIds_taglist']")
	private WebElement newletter;	 		

	@FindBy(xpath="//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div/input")
	private WebElement customerrole;	

	@FindBy(xpath="//*[@class='alert alert-success alert-dismissable']")
	private WebElement successmsg;

	//	@FindBy(xpath = "//*[@class= 'nav-item has-treeview'][3]")
	//	private WebElement custmenu;

	@FindBy(xpath = "//*[@class= 'nav-item has-treeview'][3]")
	private WebElement custmenu;

	@FindBy(xpath = "//a[@href='/Admin/Customer/List']")
	private WebElement custlist;
	
	@FindBy(xpath = "//input[@id = 'SearchEmail']")
	private WebElement serachemail;
	
	@FindBy(xpath = "//input[@id = 'SearchFirstName']")
	private WebElement searchfname;
	
	@FindBy(xpath = "//button[@id = 'search-customers']")
	private WebElement searchbtn;
	

	public void clickOnCutomerMenu() {

		custmenu.click();
	}

	public void clickOnCutomerlist() {

		custlist.click();
	}

	public void clcikOnAddBtn() {

		Addbutton.click();
	}

	public void enterPassword(String pwd) {

		password.clear();
		password.sendKeys(pwd);

	}

	public void enterEmailID(String email) {

		emailadd.clear();
		emailadd.sendKeys(email);

	}

	public void enterFirstName(String firstname) {

		firstName.clear();
		firstName.sendKeys(firstname);

	}

	public void enterLastName(String lastname) {

		lastName.clear();
		lastName.sendKeys(lastname);

	}

	public void clickOnGender(String gender) {

		if (gender.equalsIgnoreCase("male")) {

			male.click();

		}else if(gender.equalsIgnoreCase("female")) {

			female.click();
		}

	}

	public void entersDOB(String dobirth) {

		dob.sendKeys(dobirth);
	}

	public void enterCompanyName(String companyname) {

		company.sendKeys(companyname);
	}

	public void clickOnIsTaxExempt(String yesorno) {

		if (yesorno.equalsIgnoreCase("yes")) {

			istaxexempt.click();	
		}
		else {

		}
	}

	public void clickOnActive() {

		if(active.isSelected()) {
			System.out.println("checkbox is selected");
		}
		else {
			active.click();
		}
	}

	public void enterAdminComment(String comment) {

		admincomment.sendKeys(comment);
	}

	public void enterNewLetter(String newlettertext) throws Exception {

		//	newletter.click();
		util = new Utilities(driver);
		util.actionMethodToEnterText(newletter,newlettertext);

	//	newletter.sendKeys(Keys.ENTER);

	}

	public void enterCustomerRole(String role) throws Exception {

		util.actionMethodToEnterText(customerrole, role);

//		customerrole.sendKeys(Keys.ENTER);

		System.out.println("user press enter key");

	}

	public void managerOfVendor(String vendorname) {

		util.selectfromDropdown(vendorid, vendorname);
	}

	public void clickOnAddButton() {

		Addbutton.click();
	}

	public void clickOnsaveButton() {

		savebtn.click();
	}

	public String getSuccessmsg() {

		String succsmsg =  successmsg.getText();
		
		System.out.println(succsmsg);
		
		 return succsmsg;
	}
//	
//	@FindBy(xpath = "//input[@id = 'SearchEmail']")
//	private WebElement serachemail;
//	
//	@FindBy(xpath = "//input[@id = 'SearchFirstName']")
//	private WebElement searchfname;
//	
//	@FindBy(xpath = "//button[@id = 'search-customers']")
//	private WebElement searchbtn;
	
	@FindBy(xpath = "//table[@id='customers-grid']/tbody/tr")
	private WebElement rowsinCustgrid;
	
	//table[@id='customers-grid']/tbody/tr
	
	public void searchTheCutomer(String custEmail) {
		
		serachemail.sendKeys(custEmail);
		searchbtn.click();
	}
	
	public void selectTheCustInSerachResult(String custEmail) {
		
		List<WebElement> element = driver.findElements(By.xpath("//table[@id='customers-grid']/tbody/tr"));
		
		List<String> emaillist = new ArrayList<String>();
		
		for(int i = 1;i<=element.size();i++) {
			
			String email = driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			emaillist.add(email);	
		}
		
		

	}

}










