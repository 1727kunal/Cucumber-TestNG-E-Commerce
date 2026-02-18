package runner;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/Features"},
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests{
	
	 static {
		 	/*This code is used to set the name with current date and time 
		 	 * for the extent report HTML and PDF*/
	        String timestamp = new SimpleDateFormat("ddMMMyyyy_hhmmss")
	                .format(new Date());

	        System.setProperty("extent.reporter.spark.out",
	                "test-output/SparkReport/Spark_" + timestamp + ".html");

	        System.setProperty("extent.reporter.pdf.out",
	                "test-output/PdfReport/ExtentPdf_" + timestamp + ".pdf");
	        
	        /*This code is used to set the name with current date and time 
			  * for the log file*/
	        System.setProperty("logFileName",
	                "framework_" +
	                new SimpleDateFormat("ddMMMyyyy_hhmmss")
	                        .format(new Date()) + ".log");
	    }

	@Override
	@DataProvider(parallel = false) //Change this to parallel=true to run scenarios in parallel 
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
