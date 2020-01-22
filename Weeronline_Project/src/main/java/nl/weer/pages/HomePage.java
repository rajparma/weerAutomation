package nl.weer.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import nl.weer.pages.CreateDriver;

public class HomePage {

	Actions builder;
	 
	 
	 public HomePage()
		{
			
			builder = new Actions(CreateDriver.driver);
		   
		}
	 
	 @FindBy(how=How.CLASS_NAME, using="wol-acceptButton-module__button___eJm9c")
	 public WebElement acceeptCookieButton;
	 
	 @FindBy(how=How.XPATH, using=".//div[@class='wol-header-module__lgContainer___3qgem']//ul[@class='wol-headerMenu-module__submenu___EUgMb']")
	  public  WebElement actueelOptions ;
	 
	
	 @FindBy(how=How.CSS, using="input[type='text']")
	 public  WebElement citySearchTypebox;
	
	 
	 @FindBy(how=How.XPATH, using=".//ul[@class='wol-suggestion-module__results___2Ltmh']")
	 public WebElement suggestionResult;
	 
	 @FindBy(how=How.XPATH, using=".//div[@class='wol-pageTitle-module__pageTitle___vX8sV']//div[@class='wol-button-module__link___3ej19 wol-DefaultLocationButton-module__btn___dJtnN']")
	 public WebElement setHomePageButton; 
	 
	
	
//Services
	 
	 
	 public void acceptCookies()
	 {
		 acceeptCookieButton.click();
		
	 }
	
	public void go_To_Weerbericht_NederlandPage( ) throws InterruptedException
	{
		WebElement mainMenuUl = CreateDriver.driver.findElement(By.xpath(".//div[@class='wol-header-module__lgContainer___3qgem']//ul[@class='wol-headerMenu-module__menu___1ed6a']"));
	    Thread.sleep(4000);
		List<WebElement>mainMenuOptions = mainMenuUl.findElements(By.xpath(".//li[1]"));
		
		for(WebElement el : mainMenuOptions){
			builder.clickAndHold(el).build().perform();
			System.out.println("text "+el.getText());
			System.out.println("Actueel found");
			Thread.sleep(3000);
			
		    break;
			
		}
		
		List<WebElement> t2 = actueelOptions.findElements(By.xpath(".//li//a"));
		Thread.sleep(3000);
		int cnt=0;
		System.out.println("size "+t2.size());
		for(WebElement el : t2){
			cnt++;
			if(cnt==1){
				
				String url = el.getAttribute("href");
			System.out.println("text "+el.getText() + " " + url);
			//el.click();
			CreateDriver.driver.get(url);
		}
		}
		
	}
        
		
		public void search_For_City(String CityName) throws InterruptedException{
		//CreateDriver.driver.findElement(By.className("wol-acceptButton-module__button___eJm9c")).click();
		Thread.sleep(4000);
		citySearchTypebox.click();
		Thread.sleep(2000);
		citySearchTypebox.sendKeys(CityName);
		Thread.sleep(4000);
		List<WebElement>searchResultDiv = suggestionResult.findElements(By.tagName("div"));
	
     for(WebElement el : searchResultDiv){
       	 System.out.println("found" + searchResultDiv.size() );
			 el.click();
       	 //builder.moveToElement(citySearchTypebox).click(citySearchTypebox).build().perform();
			Thread.sleep(3000);
			
			break;
		
		}
		
		
		
		
	}
		
		
	public void set_Home_Page_City(String CityName) throws InterruptedException{
		search_For_City(CityName);
		setHomePageButton.click();
		
	}


}
