package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement myAccBtn;
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement registerBtn;
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement loginLink;

	WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickMyAccountButton() {
		wait.until(ExpectedConditions.visibilityOf(myAccBtn));
		myAccBtn.click();
	}

	public void clickRegisterButton() {
		wait.until(ExpectedConditions.visibilityOf(registerBtn));
		registerBtn.click();
	}

	public void clickLoginLink() {
		wait.until(ExpectedConditions.visibilityOf(loginLink));
		loginLink.click();
	}

	public String getHomePageTitle() {
		wait.until(ExpectedConditions.titleContains("Your Store"));
		return driver.getTitle();
	}
}
