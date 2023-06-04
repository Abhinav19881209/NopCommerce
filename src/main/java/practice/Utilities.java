package practice;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Utilities {
	
	public WebDriver driver;
	
	public static final int EXPLICIT_TIME_OUT = 30;
	
	public Utilities(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
//	WebElement ele = null;
	
	Actions action;
	
	Select select;
		
	public void actionMethodToEnterText(WebElement element,String text) throws Exception {
		
		Actions action = new Actions(driver);
		action.moveToElement(element)
		.click()
		.sendKeys(text)
		.perform();
		pressEnterkey();
		System.out.println("action method successful");
	}
	
	public void actionMethodToClick(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element)
		.click()
		.perform();
		System.out.println("action method successful");
	}
	
	public void pressEnterkey() throws AWTException {
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void selectfromDropdown(WebElement element,String visibleText) {
		
		select = new Select(element);
		
		List <WebElement> option = select.getOptions();
		
		for(WebElement ele :option) {
			
			if(visibleText.equalsIgnoreCase(ele.getText())) {
				
				select.selectByVisibleText(visibleText);
			}
			else {
				System.out.println("Dropdown option is not available");
			}
		}
			
	}
		
	
	
	
}
