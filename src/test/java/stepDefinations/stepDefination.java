package stepDefinations;


import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.base;

public class stepDefination extends base{

	@Given("^Initialize browser$")
	public void initialize_browser() throws IOException {
		 driver=iniilizeDriver();
		 driver.manage().window().maximize();
	}

	@Given("^User navigate to \"([^\"]*)\" site$")
	public void user_navigate_to_site(String arg1) throws IOException {
		driver.get(arg1); 
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and Logs In$")
	public void user_enters_and_and_Logs_In(String arg1, String arg2) throws IOException {
		driver.findElement(By.id("txtUsername")).sendKeys(arg1);
	    driver.findElement(By.id("txtPassword")).sendKeys(arg2);
	}

	@Then("^User successfully logged into OrangeHRM application$")
	public void user_successfully_logged_into_OrangeHRM_application() throws IOException {
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		//Assert.assertFalse(driver.findElement(By.xpath(" //input[@id='MP_link']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(" //input[@id='MP_link']")).isDisplayed());	
		}

	@Given("^User navigate to PMI Tab$")
	public void user_navigate_to_PMI_Tab() throws IOException {
		driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
	}

	@Given("^User click on Add Employee in PMI Tab$")
	public void user_click_on_Add_Employee_in_PMI_Tab() throws IOException {
		driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
	}

	@Given("^User Enter all details for adding new Employee$")
	public void user_Enter_all_details_for_adding_new_Employee() throws IOException {
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Steve");
		driver.findElement(By.xpath("//input[@id='middleName']")).sendKeys("J.");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Willson");
		driver.findElement(By.xpath("//input[@id='employeeId']")).clear();
		driver.findElement(By.xpath("//input[@id='employeeId']")).sendKeys("OHRM001");
		WebElement uploadElement = driver.findElement(By.id("photofile"));
		uploadElement.sendKeys("C:\\img.jpg");
		
		
		driver.findElement(By.xpath("//input[@id='chkLogin']")).click();
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("SteveOHRM001");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Steve07111989");
		driver.findElement(By.xpath("//input[@id='re_password']")).sendKeys("Steve07111989");
		
		Select status = new Select(driver.findElement(By.xpath("//select[@id='status']")));
		status.selectByValue("Enabled");
		 
	}

	@When("^User Click on save button to add new Employee$")
	public void user_Click_on_save_button_to_add_new_Employee() throws IOException {
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
	}

	@Then("^New Employee has been addess successfully$")
	public void new_Employee_has_been_addess_successfully() throws IOException {
	    
		Assert.assertTrue(driver.findElement(By.xpath("//img[@id='empPic']")).isDisplayed());
		//Assert.assertFalse(driver.findElement(By.xpath("//img[@id='empPic']")).isDisplayed());
		driver.quit();
	}


}
