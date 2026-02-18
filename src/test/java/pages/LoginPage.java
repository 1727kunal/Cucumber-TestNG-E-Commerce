package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	@FindBy(id = "input-email")
	WebElement emailTxt;
	@FindBy(id = "input-password")
	WebElement passwordTxt;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	WebDriver driver;
	WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public String getLoginPageTitle() {
		wait.until(ExpectedConditions.titleContains("Account Login"));
		return driver.getTitle();
	}

	public void enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(emailTxt));
		emailTxt.sendKeys(email);
	}

	public void enterPassword(String pass) {
		wait.until(ExpectedConditions.visibilityOf(passwordTxt));
		passwordTxt.sendKeys(pass);
	}

	public void clickLoginButton() {
		wait.until(ExpectedConditions.visibilityOf(loginBtn));
		loginBtn.click();
	}
}
