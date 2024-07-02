package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookAppointmentSteps {
	
	WebDriver driver;
	
	@Given("User navigate to Cura health care application")
	public void userNavigateToCartApplication() {
		driver = new ChromeDriver();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		Options manage = driver.manage();
		manage.timeouts().implicitlyWait(Duration.ofSeconds(3));
		manage.window().maximize();
	}
	
	@Given("User loging to website with {string} and {string}")
	public void userLogingToWebsiteWithAnd(String username, String password) {
	    
		driver.findElement(By.cssSelector("#menu-toggle i")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("txt-username")).sendKeys(username);
		driver.findElement(By.id("txt-password")).sendKeys(password); 
		driver.findElement(By.xpath("//button[text()='Login']")).click();
	    
	}
	@Given("User select facility as {string}")
	public void userSelectFacilityAs(String facility) {
	    
		Select select = new Select(driver.findElement(By.id("combo_facility")));
		select.selectByVisibleText(facility);
	    
	}
	@Given("User select Apply for hospital readmission checkbox")
	public void userSelectApplyForHospitalReadmissionCheckbox() {
	    
		driver.findElement(By.cssSelector("#chk_hospotal_readmission")).click();
	    
	}
	@Given("User select Helth care Program radiobox as Medicaid")
	public void userSelectHelthCareProgramRadioboxAs(){
	    
		driver.findElement(By.xpath("//input[@value='Medicaid']")).click();
	}
	@Given("User select Visit date as {string}")
	public void userSelectVisitDateAs(String date) {
	    
	    driver.findElement(By.cssSelector("#txt_visit_date")).sendKeys(date);
	    System.out.println("date is: " + date);
	}
	@Given("user add comment as {string}")
	public void userAddCommentAs(String comment) {
	    
	    driver.findElement(By.id("txt_comment")).sendKeys(comment);
	}
	@When("user click on Book Appointment button")
	public void userClickOnBookAppointmentButton() {
	    driver.findElement(By.cssSelector("#btn-book-appointment")).click();
	    
	}
	@Then("Appointment should be sucessfull")
	public void appointmentShouldBeSucessfull() {
	    
	    Boolean text =  driver.findElement(By.xpath("//h2[text()='Appointment Confirmation']")).isDisplayed();
	    Assert.assertTrue(text,"Assertion is faile due to text is not mattched: ");
	    driver.quit();
	}
}
