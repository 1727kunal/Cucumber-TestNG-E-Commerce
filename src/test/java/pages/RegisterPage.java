package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	@FindBy(id = "input-firstname")
	WebElement firstNameTxt;
	@FindBy(id = "input-lastname")
	WebElement lastNameTxt;
	@FindBy(id = "input-email")
	WebElement emailTxt;
	@FindBy(id = "input-telephone")
	WebElement telephoneTxt;
	@FindBy(id = "input-password")
	WebElement passwordTxt;
	@FindBy(id = "input-confirm")
	WebElement confirmPasswordTxt;
	@FindBy(name = "agree")
	WebElement privacyCheckbox;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement continueBtn;

	WebDriver driver;
	WebDriverWait wait;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void enterFirstName(String fnm) {
		wait.until(ExpectedConditions.visibilityOf(firstNameTxt));
		firstNameTxt.sendKeys(fnm);
	}

	public void enterLastName(String lnm) {
		wait.until(ExpectedConditions.visibilityOf(lastNameTxt));
		lastNameTxt.sendKeys(lnm);
	}

	public void enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOf(emailTxt));
		emailTxt.sendKeys(email);
	}

	public void enterTelephoneNumber(String teleNum) {
		wait.until(ExpectedConditions.visibilityOf(telephoneTxt));
		telephoneTxt.sendKeys(teleNum);
	}

	public void enterPassword(String pass) {
		wait.until(ExpectedConditions.visibilityOf(passwordTxt));
		passwordTxt.sendKeys(pass);
	}

	public void enterConfirmPassword(String conPass) {
		wait.until(ExpectedConditions.visibilityOf(confirmPasswordTxt));
		confirmPasswordTxt.sendKeys(conPass);
	}

	public void clickPrivacyCheckbox() {
		wait.until(ExpectedConditions.visibilityOf(privacyCheckbox));
		privacyCheckbox.click();
	}

	public void clickContinueButton() {
		wait.until(ExpectedConditions.visibilityOf(continueBtn));
		continueBtn.click();
	}

	public String getRegisterPageTitle() {
		wait.until(ExpectedConditions.titleContains("Register Account"));
		return driver.getTitle();
	}
}
