package rough;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Rough_Codes {

	public static void main(String[] args) {
	
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		
	WebDriverManager.chromedriver().setup();
	WebDriver browser;
	browser = new ChromeDriver(options);
	browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	browser.get("https://bestbuy.com");
	
	WebElement searchBox;
	searchBox = browser.findElement(By.xpath("//input[@id='gh-search-input']"));
	searchBox.sendKeys("camera" + Keys.ENTER);
	
	
	browser.findElement(By.className("header-search-button")).click();
	
	//browser.findElement(By.xpath("//input[@name='q']")).sendKeys("camera" + Keys.ENTER);
	
//	List<WebElement> cameras = new ArrayList<WebElement>();
//	cameras = browser.findElements( By.xpath("//ol[@class='sku-item-list']/li") );
//		System.out.println(cameras.size());
//		
//	for (WebElement camera : cameras ) {
//		String name = camera.findElement(By.xpath(".//h4[@class=\"sku-title\"]/a") ).getText();
//		System.out.println( name );
//	}
	
	ArrayList<WebElement> finalLinks =  new ArrayList<WebElement>();
	WebElement myDiv = browser.findElement(By.id("main-results"));
	List<WebElement> cameras = myDiv.findElements( By.xpath("//ol[@class='sku-item-list']/li") );;
	System.out.println(cameras.size());
	
	for(WebElement camera:cameras){
	  try{
	      String containingtable = camera.findElement(By.xpath(".//h4[@class='sku-title']/a")).getText();
	      System.out.println(containingtable);
	  	}
	  catch(Exception e){
	      finalLinks.add(camera);
	  	}
	  }
	
	
	

	}//main

}//class
