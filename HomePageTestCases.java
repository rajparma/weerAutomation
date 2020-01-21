package nl.weeronline.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.proposify.pages.CreateDriver;
import org.proposify.pages.Revamp_Login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import nl.weeronline.pages.HomePage;

public class HomePageTestCases {
	
	HomePage hPage;
	
	
	@BeforeMethod
	@Parameters ("browser")
	public void launchBrowser(String browserName) throws Exception{
		
		if(browserName.equalsIgnoreCase("chrome")){
		 CreateDriver.init_Driver("chrome");
		 hPage =PageFactory.initElements(CreateDriver.driver,HomePage.class );
		 CreateDriver.driver.manage().window().maximize();
		 Thread.sleep(3000);
		 
         CreateDriver.driver.get("https://www.weeronline.nl");
         CreateDriver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(!CreateDriver.driver.getCurrentUrl().equalsIgnoreCase("https://www.weeronline.nl")){
			
			System.out.print("Entered");
		    //CreateDriver.driver.navigate().refresh();
			CreateDriver.driver.get("https://www.weeronline.nl/");
			
		}
		}
		
		 if(browserName.equalsIgnoreCase("safari")){
			
			 CreateDriver.init_Driver("safari");
			 //CreateDriver.driver = new SafariDriver();
			 hPage =PageFactory.initElements(CreateDriver.driver, HomePage.class);
			 CreateDriver.driver.manage().window().maximize();
			 Thread.sleep(3000);
	         CreateDriver.driver.get("https://www.weeronline.nl/");
	         CreateDriver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 		
	 		if(!CreateDriver.driver.getCurrentUrl().equalsIgnoreCase("https://www.weeronline.nl")){
	 			
	 			System.out.print("Entered");
	 		    //CreateDriver.driver.navigate().refresh();
	 			CreateDriver.driver.get("https://www.weeronline.nl/");
	 			
	 		}
		}
		
		
	}
	
	
	/*
	 * Test:
	 * Open https://www.weeronline.nl/
	 *
       Click “Actueel” -> Weerbericht Nederland menu item and open Weerbericht Nederland page
       
       Check URL is “https://www.weeronline.nl/weerbericht-nederland”
	 */
	
	@Test(priority = 0 , enabled =true)
	public void verify_URL_for_Weerbericht_Nederland_Page() throws InterruptedException{
		
		hPage.acceptCookies();
		Thread.sleep(4000);
		//CreateDriver.driver.navigate().refresh();
		//Thread.sleep(3000);
		hPage.go_To_Weerbericht_NederlandPage();
		Thread.sleep(3000);
		System.out.println(CreateDriver.driver.getCurrentUrl());
		assertEquals(CreateDriver.driver.getCurrentUrl(),"https://www.weeronline.nl/weerbericht-nederland" );
		
		
	}
	
	/*Test:
	 * search field
	 * 
     Search by the city name, find the city (for example Rotterdam)
     
     Click by the Rotterdam name in the search result list
     
     Validate that you are redirected to Rotterdam city page
	 * 
	 */
	
	@Test(priority=1, enabled =false)
	public void verify_Searched_City_Page_redirected() throws InterruptedException{
		
		Thread.sleep(3000);
		hPage.search_For_City("Rotterdam");
		System.out.println(CreateDriver.driver.getCurrentUrl());
		assertEquals(CreateDriver.driver.getCurrentUrl(),"https://www.weeronline.nl/Europa/Nederland/Rotterdam/4057931" );
		
		
	}
	
	/*Test:
	 * On the Rotterdam page (or any other city page) there is a button to set this city to be
	 * 
       a “default” city (“Stel in als homepage” button)
       Click set button and then go to main page URL https://www.weeronline.nl/
       Make sure that default city now is the one that you set
	 * 
	 */
	
	@Test(priority=2, enabled =false)
	public void verify_User_Sets_Homepage_City() throws InterruptedException{
		
		Thread.sleep(3000);
		hPage.set_Home_Page_City("Rotterdam");
		//System.out.println(CreateDriver.driver.getCurrentUrl());
		Thread.sleep(4000);
		CreateDriver.driver.navigate().back();
		WebElement homepageCityTitle = CreateDriver.driver.findElement(By.className("wol-pageTitle-module__pageTitle___vX8sV"));
		Thread.sleep(5000);
		assertEquals(homepageCityTitle.getText(),"Rotterdam" );
		
		
	}
	@AfterClass
	public void closingBrowser(){
		CreateDriver.driver.quit();
		CreateDriver.driver = null;
	}

}
