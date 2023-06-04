package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
 	private WebElement emailadd;
	
	@FindBy(xpath="//input[@id='Password']")
 	private WebElement password;
	
	@FindBy(xpath = "//button[@class= 'button-1 login-button']")
	private WebElement loginbtn;
	
	@FindBy(xpath = "//strong[text()= 'Welcome, please sign in!']")
	private WebElement welcometext;
	
	@FindBy(xpath = "//li[text()='The credentials provided are incorrect']")
	private WebElement crederrormsg;
	
	
	public void enterEmailid(String emailid) {
		
		emailadd.clear();
		emailadd.sendKeys(emailid);
	}
	
	public void enterPassword(String pwd) {
		
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		
		loginbtn.click();
		
	}
	
	public String checkErrorMsg() {
		
		return crederrormsg.getText();
	}
	
	
	public String checkWelComeMsg() {
		
		return welcometext.getText();
	}
	
	
	
	
}
