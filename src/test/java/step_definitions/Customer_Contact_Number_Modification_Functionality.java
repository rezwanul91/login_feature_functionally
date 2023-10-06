package step_definitions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Customer_Contact_Number_Modification_Functionality extends Base {
	//ctrl+shift+Format
	@Given("I am in landing page http:\\/\\/it.microtechlimited.com")
	public void i_am_in_landing_page_http_it_microtechlimited_com() {
		navigateURL("http://it.microtechlimited.com");
	}

	@When("I Click on Login menu")
	public void i_click_on_login_menu() {
		click( By.xpath("//a[@href='elogin.php']") );
	}

	@When("Click on Customer Login")
	public void click_on_customer_login() {
		click(By.xpath("//a[@href='clogin.php']") );
	}

	@Then("Enter User Id as david@gmail.com")
	public void enter_user_id_as_david_gmail_com() {
		sendkeys(By.xpath("//input[@name='mailuid']"), "david@gmail.com");
		
	}

	@Then("I Enter Password as {int}")
	public void i_enter_password_as(Integer int1) {
		sendkeys(By.xpath("//input[@name='pwd']"), "1234");
	}

	@Then("I Click on Login Button")
	public void i_click_on_login_button() {
		click( By.name("login-submit")  );
	}

	@Then("Verify that I am in Home Page")
	public void verify_that_i_am_in_home_page() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2)); //Explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[2]")));
		String s = getElementText( By.xpath("//h2[2]") );
	}

	@Then("I Click on Profile Menu")
	public void i_click_on_profile_menu() {
		click( By.linkText("My Profile") );
	}

	@Then("I Click on Update Info")
	public void i_click_on_update_info() {
		click( By.xpath("//button[@name='send']") );
	}

	@Then("I Replace the Contact Number to {int}")
	public void i_replace_the_contact_number_to(Integer int1) {
		clear( By.name("contact"));
		sendkeys( By.name("contact") , "44555");
	}

	@Then("I Click Submit button")
	public void i_click_submit_button() {
		click( By.name("update") );
	}

	@Then("Verify Contact Number is changed to {int}")
	public void verify_contact_number_is_changed_to(Integer int1) {
		String v = driver.findElement( By.name("contact") ).getAttribute("value");
		assertEquals("44555", v);
		System.out.println("test passed");
	}

}
