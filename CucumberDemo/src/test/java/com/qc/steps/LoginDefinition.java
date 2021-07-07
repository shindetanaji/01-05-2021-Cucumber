package com.qc.steps;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginDefinition {
	WebDriver driver;

	@Given("^Setup browser and launch login page$")
	public void setup_browser_and_launch_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"D:/QueueCodes/Software/Selenium/chromedriver/chromedriver_v.85.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///D:/QueueCodes/Software/Selenium/Offline%20Website/index.html");
	}

	@Given("^Enter valid username \"([^\"]*)\"$")
	public void enter_valid_username(String uName) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(uName);
	}

	@Given("^Enter valid password \"([^\"]*)\"$")
	public void enter_valid_password(String uPass) throws Throwable {
		driver.findElement(By.id("password")).sendKeys(uPass);
	}

	@When("^Click on signIn button$")
	public void click_on_signIn_button() throws Throwable {
		driver.findElement(By.id("submit")).click();
	}

	@Then("^User should be on dashboard page \"([^\"]*)\"$")
	public void user_should_be_on_dashboard_page(String expTitle)
			throws Throwable {
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
	}

	@Then("^User should be logout and browser should be close$")
	public void user_should_be_logout_and_browser_should_be_close()
			throws Throwable {
		driver.findElement(By.id("hlogout")).click();
		driver.close();
	}

	@Then("^User should be on login page \"([^\"]*)\"$")
	public void user_should_be_on_login_page(String expTitle) throws Throwable {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expTitle);
	}

	@Then("^Validate emailError as \"([^\"]*)\" and passwordError \"([^\"]*)\"$")
	public void validate_emailError_as_and_passwordError(String expEmailError,
			String expPasswordError) throws Throwable {
		WebElement emailError = driver.findElement(By.id("email_error"));
		String actualEmailError = emailError.getText();
		Assert.assertEquals(actualEmailError, expEmailError);

		WebElement passError = driver.findElement(By.id("password_error"));
		String actualPasswordError = passError.getText();
		Assert.assertEquals(actualPasswordError, expPasswordError);
	}

	@Then("^Browser should be close$")
	public void browser_should_be_close() throws Throwable {
		driver.close();
	}

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("config/report.xml"));
	}

}
