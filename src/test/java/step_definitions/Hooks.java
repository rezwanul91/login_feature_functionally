package step_definitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends Base{
	@Before
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		options.addArguments("false");
		driver = new ChromeDriver(options); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Implicit wait
		System.out.println("before run");
	}
	
	
	@After
	public void tearDown(Scenario scenario) {
//		try {
//			String screenshotName= scenario.getName().replace("", "");
//			if(scenario.isFailed()) {
//				scenario.log("this is my failure message");
//				TakesScreenshot ts = (TakesScreenshot)driver;
//				byte[]screenshot = ts.getScreenshotAs(OutputType.BYTES);
//				scenario.attach(screenshot, "image/png", screenshotName);
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot)driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "screenshot");
			scenario.log("this is my failed test case screenshot");
			scenario.log("Scenario: " + scenario.getName() );
		}
		driver.quit();
		System.out.println("After run");
	}

	
	
}//class
