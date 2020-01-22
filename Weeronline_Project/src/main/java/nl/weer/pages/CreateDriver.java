package nl.weer.pages;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class CreateDriver {

	public static WebDriver driver;
	static Set<Cookie> Cookies; 
	
	
	public static void init_Driver(String browserName){
		
		if(driver == null) {
		
		if(browserName.equalsIgnoreCase("chrome")){
			
			//creating driver object for Chrome WebDriver
			System.setProperty("webdriver.chrome.driver", "//Users//rajnishparmar//Drivers//Chrome//chromedriver");
			 driver = new ChromeDriver();
			 
			 
			 
			 
		}
		
	 if (browserName.equalsIgnoreCase("safari")){
		
		 
		   
		   //creating driver object for Safari WebDriver
		    driver = new SafariDriver();
		   }

	 
	 if(browserName.equalsIgnoreCase("Firefox")){
		 
		 System.setProperty("webdriver.gecko.driver", "//Users//rajnishparmar//Drivers//Firefox//geckodriver");
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--start-fullscreen");
			driver = new FirefoxDriver(options);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }
		}
	}
	
}
