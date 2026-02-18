package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import base.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterPage;
import pages.SuccessPage;
import utilities.FakeDataGenerator;

public class RegisterSteps {
	
	private static final Logger logger = LogManager.getLogger(RegisterSteps.class);
	
	HomePage homePageObj;
	RegisterPage registerPageObj;
	SuccessPage successPageObj;
	
	String password;
	
	public RegisterSteps() {
		homePageObj = new HomePage(DriverManager.getDriver());
		registerPageObj = new RegisterPage(DriverManager.getDriver());
		successPageObj = new SuccessPage(DriverManager.getDriver());
	}
	
	@When("User clicks on Register button")
	public void user_clicks_on_register_button() {
		logger.info("Clicked register link...");
		homePageObj.clickRegisterButton();
	}

	@Then("User should land on the registration page")
	public void user_should_land_on_the_registration_page() {
		logger.info("On registration form...");
		Assert.assertEquals(registerPageObj.getRegisterPageTitle(), "Register Account");
	}

	@When("User enters first name")
	public void user_enters_first_name() {
		logger.info("Entered first name...");
		registerPageObj.enterFirstName(FakeDataGenerator.generateFirstName());
	}

	@And("User enters last name")
	public void user_enters_last_name() {
		logger.info("Entered last name...");
		registerPageObj.enterLastName(FakeDataGenerator.generateLastName());
	}

	@And("User enters email")
	public void user_enters_email() {
		logger.info("Entered email...");
		registerPageObj.enterEmail(FakeDataGenerator.generateEmail());
	}

	@And("User enters telephone")
	public void user_enters_telephone() {
		logger.info("Entered telephone...");
		registerPageObj.enterTelephoneNumber(FakeDataGenerator.generateTelephone());
	}

	@And("User enters password")
	public void user_enters_password() {
		logger.info("Entered password...");
		password = FakeDataGenerator.generatePassword();
		registerPageObj.enterPassword(password);
	}

	@And("User enters confirm password")
	public void user_enters_confirm_password() {
		logger.info("Password confirmed...");
		registerPageObj.enterConfirmPassword(password);
	}

	@And("User checks the privacy policy checkbox")
	public void user_checks_the_privacy_policy_checkbox() {
		logger.info("Checked the checkbox...");
		registerPageObj.clickPrivacyCheckbox();
	}

	@And("User clicks on the continue button")
	public void user_clicks_on_the_continue_button() {
		logger.info("Clicked continue button...");
		registerPageObj.clickContinueButton();
	}

	@Then("User should be registered successfully")
	public void user_should_be_registered_successfully() {
		logger.info("Registration success...");
		Assert.assertEquals(successPageObj.isSuccessTextMessageDisplayed(), true);
	}

	@And("User should land on success page")
	public void user_should_land_on_success_page() {
		logger.info("On success page...");
		Assert.assertEquals(successPageObj.getSuccessPageTitle(), "Your Account Has Been Created!");
	}

	@When("User clicks continue button on the success page")
	public void user_clicks_continue_button_on_the_success_page() {
		logger.info("Continue button on success page clicked...");
		successPageObj.clickContinueButton();
	}

}
