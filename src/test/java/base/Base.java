package base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Base {
	
	public static WebDriver driver; //default
	
	public static void navigateURL(String url) {
		driver.get(url);
	}
	
	public static void click(By locator) {
		driver.findElement( locator ).click();
	}
	
	public static void clear(By locator) {
		driver.findElement( locator ).clear();
	}
	
	
	public static void sendkeys(By locator, String value) {
		driver.findElement( locator ).sendKeys( value  );
	}
	
	public static String getElementText(By locator) {
		//Get the Text of that Element (H3) Online Access
		WebElement element =  driver.findElement( locator );
		//get the text of that element
		String s = element.getText();	
		return s;
	}
}