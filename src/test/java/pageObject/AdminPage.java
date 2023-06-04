package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import practice.Utilities;


public class AdminPage{

	WebDriver driver;

	public AdminPage(WebDriver driver) {
		System.out.println("Admin page constructor called ");
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		System.out.println("Admin page constructor end ");
	}
	
	//Utilities util = new Utilities(driver);
	String Pagetitle = "Dashboard / nopCommerce administration";
	
	@FindBy(xpath = "//a[@href='/logout']")
	private WebElement logoutbtn;
	
	@FindBy(xpath = "//li[@class='nav-item has-treeview'][3]")
	private WebElement customers;
	
	@FindBy(xpath = "//p[text()=' Customers']")
	private WebElement customerlist;
	
	public void clickOnButton() {
		
		logoutbtn.click();
	}
	
	public String checkPageTitle() {
		
		return driver.getTitle();
		
	}
	
//	public void clickOnCutomer() throws Exception {
//		System.out.println("Click on Customer");
//
//		customers.click();
//	//	Thread.sleep(5000);
//		
//	}
	
	public void clickOnCutomerList() {
		
		customerlist.click();
	}
	
}
