package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import base.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginDataTableSteps {
	
	private static final Logger logger = LogManager.getLogger(LoginDataTableSteps.class);
	
	LoginPage loginPageObj;
	
	public LoginDataTableSteps() {
		loginPageObj = new LoginPage(DriverManager.getDriver());
	}
	
	@When("User enter the below credentials and clicks the login button then login process should be complete")
	public void user_enter_the_below_credentials_and_clicks_the_login_button_then_login_process_should_be_complete(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		String expectedResult = "";

		for (Map<String, String> actualData : data) {
			loginPageObj.enterEmail(actualData.get("email"));
			logger.info("Email entered...");
			loginPageObj.enterPassword(actualData.get("password"));
			logger.info("Password entered...");
			expectedResult = actualData.get("expected");
			loginPageObj.clickLoginButton();
			logger.info("Clicked login button...");
			boolean status = false;
			if (expectedResult.equalsIgnoreCase("valid")) {
				logger.info("Login success...");
				status = true;
				Assert.assertTrue(status);
			}

			else if (expectedResult.equalsIgnoreCase("invalid")) {
				logger.error("Login failed...");
				status = false;
				Assert.assertFalse(status);
			}
			DriverManager.getDriver().navigate().refresh();
		} 
	}

}
