package step_definitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends Base{
	@Before
	public void setup() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		
	
		driver = new RemoteWebDriver(new URL("http://3.145.197.131:4444"),options);
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
