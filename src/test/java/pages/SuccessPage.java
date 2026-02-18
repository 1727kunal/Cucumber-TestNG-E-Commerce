package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessPage {
	@FindBy(linkText = "Continue")
	WebElement continueBtn;
	@FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
	WebElement successTxt;

	WebDriver driver;
	WebDriverWait wait;

	public SuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickContinueButton() {
		wait.until(ExpectedConditions.visibilityOf(continueBtn));
		continueBtn.click();
	}

	public boolean isSuccessTextMessageDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(successTxt));
		return successTxt.isDisplayed();
	}

	public String getSuccessPageTitle() {
		wait.until(ExpectedConditions.titleContains("Your Account Has Been Created!"));
		return driver.getTitle();
	}
}
