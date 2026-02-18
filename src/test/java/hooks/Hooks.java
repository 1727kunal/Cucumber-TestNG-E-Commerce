package hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	private static final Logger logger = LogManager.getLogger(Hooks.class);

	@Before
	public void setUp() {
		logger.info("Broswer launched...");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=common/home");
		DriverManager.setDriver(driver);

	}

	@After
	public void tearDown(Scenario scenario) {
		logger.info("Broswer closed...");
		if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(
                    screenshot,
                    "image/png",
                    "Failure Screenshot"
            );
        }
		
		DriverManager.getDriver().quit();
		DriverManager.unloadDriver();
	}

}
