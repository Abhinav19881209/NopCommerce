package delete;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practice.Utilities;

public class CustomerPage {
	
	WebDriver driver;
	
	public CustomerPage (WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	Utilities util ;//= new Utilities(driver);
//	WebDriverwait wait = new WebDriverwait(driver);
	
	@FindBy(xpath="//a[@href='/Admin/Customer/Create']")
 	private WebElement Addbutton;
	
	@FindBy(xpath="//a[@name='save']")
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
	
	@FindBy(xpath="//input[@id='VendorId']")
 	private WebElement vendorid;
	

	@FindBy(xpath="//input[@id='Active']")
 	private WebElement active;
	
	@FindBy(xpath="//input[@id='AdminComment']")
 	private WebElement admincomment;
	
	@FindBy(xpath="//ul[@id = 'SelectedNewsletterSubscriptionStoreIds_taglist']")
 	private WebElement newletter;	 		
	
	@FindBy(xpath="//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div/input")
 	private WebElement customerrole;	
	
	@FindBy(xpath="//*[@class='alert alert-success alert-dismissable']")
	private WebElement successmsg;
	
	@FindBy(xpath = "//a[@href='#']//following::p[text()=' Customers']")
	private WebElement customers;
	
	////methods
	
	public void clickOnCutomer() {
		System.out.println("Click on Sales");
		driver.findElement(By.xpath("//*[@class='nav-item has-treeview'][3]")).click();
		
		System.out.println("Click on Customer");
		
		driver.findElement(By.xpath("//*[@class='nav-item has-treeview'][3]")).click();
		driver.findElement(By.xpath("//p[text()=' Customers']")).click();
		

	//	customers.click();;
	//	Thread.sleep(5000);
		
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
		
		newletter.sendKeys(Keys.ENTER);
		
	}
	
	public void enterCustomerRole(String role) throws Exception{
		
		util.actionMethodToEnterText(customerrole, role);
		
		customerrole.sendKeys(Keys.ENTER);
		
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
		
		return successmsg.getText();
	}
}
