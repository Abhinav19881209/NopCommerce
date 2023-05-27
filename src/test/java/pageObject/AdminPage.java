package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

	
	WebDriver driver;
	
	public AdminPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	String Pagetitle = "Dashboard / nopCommerce administration";
	
	@FindBy(xpath = "//a[@href='/logout']")
	private WebElement logoutbtn;
	
	public void clickOnButton() {
		
		logoutbtn.click();
	}
	
	public String checkPageTitle() {
		
		return driver.getTitle();
		
	}
	
	
	
}
