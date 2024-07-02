package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver;

	
	 @Given("User navigate to Cura health care homepage") 
	 public void userNavigateToCuraHealthCareHomepage() {
		 driver = new ChromeDriver();
		 driver.get("https://katalon-demo-cura.herokuapp.com/"); Options manage =
		 driver.manage(); manage.timeouts().implicitlyWait(Duration.ofSeconds(3));
		 manage.window().maximize();
	 }
	 

	@Given("User clicks on login pages button")
	public void userClicksOnLoginPagesButton() {
		driver.findElement(By.cssSelector("#menu-toggle i")).click();
		driver.findElement(By.linkText("Login")).click();

	}

	/*
	 * @Given("User enter the user name as John Doe") public void
	 * userEnterTheUserNameAsJohnDoe() {
	 * 
	 * driver.findElement(By.id("txt-username")).sendKeys("John Doe"); }
	 * 
	 * @Given("User enter the password as ThisIsNotAPassword") public void
	 * userEnterThePasswordAsThisIsNotAPassword() {
	 * 
	 * driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword"); }
	 */

	@When("User click on login button")
	public void userClickOnLoginButton() {

		driver.findElement(By.xpath("//button[text()='Login']")).click();

	}

	@Then("Login should be successfull")
	public void loginShouldBeSuccessfull() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Boolean appoinmentText = driver.findElement(By.xpath("//h2[text()='Make Appointment']")).isDisplayed();

		Assert.assertTrue(appoinmentText, "Login not successfull!");

		driver.quit();
	}

	@Given("User enter the user name as {string}")
	public void userEnterTheUserNameAs(String username) {

		driver.findElement(By.id("txt-username")).sendKeys(username);

	}

	@Given("User enter the password as {string}")
	public void userEnterThePasswordAs(String password) {

		driver.findElement(By.id("txt-password")).sendKeys(password);
	}

	@When("Login should be failed!")
	public void loginShouldBeFailed() {

		String faildTestText = driver.findElement(By.xpath("//p[contains(text(),'Login failed!')]")).getText();
		Assert.assertEquals(faildTestText.trim(), "Login failed! Please ensure the username and password are valid.");
		driver.quit();
	}

}
