package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.MyAccountPage;

import org.testng.Assert;

import base.DriverManager;

public class CommonSteps {
	HomePage homePageObj;
	MyAccountPage myAccountPageObj;
	
	public CommonSteps() {
		homePageObj = new HomePage(DriverManager.getDriver());
		myAccountPageObj = new MyAccountPage(DriverManager.getDriver());
	}
	
	@Given("User should land on the homepage")
	public void user_should_land_on_the_homepage() {
	    Assert.assertEquals(homePageObj.getHomePageTitle(), "Your Store");
	}

	@When("User clicks on MyAccount button")
	public void user_clicks_on_my_account_button() {
		homePageObj.clickMyAccountButton();
	}

	@Then("User should land on the my account page")
	public void user_should_land_on_the_my_account_page() {
	    Assert.assertEquals(myAccountPageObj.getMyAccountPageTitle(), "My Account");
	}
}
