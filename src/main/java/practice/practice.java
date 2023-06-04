package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		
		driver.get("https://admin-demo.nopcommerce.com/login");
		
		driver.findElement(By.xpath("//button[@class= 'button-1 login-button']")).click();
		
		driver.findElement(By.xpath("//*[@class='nav-item has-treeview'][3]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[text()=' Customers']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href = '/Admin/Customer/Create']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Email")).sendKeys("test2.test@Test.com");
		
		WebElement ele = driver.findElement(By.xpath("//*[@id='customer-info']/div[2]/div[9]/div[2]/div/div[1]/div/div/input"));
		WebElement ele2 = driver.findElement(By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div/input"));
		WebElement ele3 = driver.findElement(By.xpath("//*[@id=\"VendorId\"]"));
		
		
		Actions action = new Actions(driver);
		action.moveToElement(ele).click().sendKeys("Your store name").sendKeys(Keys.ENTER).build().perform();
//		ele.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		action.moveToElement(ele2).click().sendKeys("Guests").sendKeys(Keys.ENTER).build().perform();
//		ele2.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		action.moveToElement(ele3).click().sendKeys("Vendor 2").build().perform();
		ele3.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id("AdminComment")).sendKeys("Comments");
		
		Thread.sleep(10000);
		
		driver.quit();

	}



}
