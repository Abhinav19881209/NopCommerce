package MyHooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	
	WebDriver driver;
	
//	@Before
//	public void setUp() {
//		
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(option);
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	}
//	
//	@After
//	public void tearDown() {
//		driver.close();
//		driver.quit();	
//	}
	
	
}
