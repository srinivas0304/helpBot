package extentReport;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentUtility 
{
	public static void extentUtility()
	{
		ExtentReports extent=new ExtentReports();
		File path=new File("Ebay1.html");
		ExtentSparkReporter sparkReport=new ExtentSparkReporter("./SparkReports/Ebay.html");
		extent.attachReporter(sparkReport);
		ExtentTest test=extent.createTest("Test1");
		test.info("This is info message");
		extent.flush();
	}
}
