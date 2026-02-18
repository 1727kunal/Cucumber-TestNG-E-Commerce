package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import base.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class LoginSteps {
	
	private static final Logger logger = LogManager.getLogger(LoginSteps.class);
	
	HomePage homePageObj;
	LoginPage loginPageObj;
	MyAccountPage myAccountPageObj;
	
	public LoginSteps() {
		homePageObj = new HomePage(DriverManager.getDriver());
		loginPageObj = new LoginPage(DriverManager.getDriver());
		myAccountPageObj = new MyAccountPage(DriverManager.getDriver());
	}
	
	@When("User clicks on Login link")
	public void user_clicks_on_login_link() {
		logger.info("Clicked on login link...");
		homePageObj.clickLoginLink();
	}

	@Then("User should land on the login page")
	public void user_should_land_on_the_login_page() {
		logger.info("On login page...");
		Assert.assertEquals(loginPageObj.getLoginPageTitle(), "Account Login");
	}

	@When("User enters the email as {string}")
	public void user_enters_the_email_as(String emailAddress) {
		logger.info("Entered email...");
		loginPageObj.enterEmail(emailAddress);
	}

	@And("password as {string}")
	public void password_as(String password) {
		logger.info("Entered password...");
		loginPageObj.enterPassword(password);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		logger.info("Clicked login button...");
		loginPageObj.clickLoginButton();
	}

	@Then("User should see the {string}")
	public void userShouldSeeThe(String expectedLoginStatus) {
		if (expectedLoginStatus.equalsIgnoreCase("my account page")) {
			logger.info("Login success...");
			Assert.assertEquals(myAccountPageObj.getMyAccountPageTitle(), "My Account");
		}
			
		else if (expectedLoginStatus.equalsIgnoreCase("error message")) {
			logger.error("Login failed...");
			Assert.assertEquals(loginPageObj.getLoginPageTitle(), "Account Login");
		}	
	}
}
