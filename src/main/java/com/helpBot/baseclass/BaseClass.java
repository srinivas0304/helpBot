package com.helpBot.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import extentReport.ExtentUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentUtility ut;
	
	@BeforeTest
	public void loadConfig() throws Exception
	{
		try
		{
			prop=new Properties();
			FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
			prop.load(fs);
		}
		catch(FileNotFoundException a)
		{
			a.printStackTrace();
		}
		catch(IOException b)
		{
			b.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void load()
	{
		launchBrowser();
	}
	
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.quit();
//	}
	
//	@Parameters("browser")
	public void launchBrowser()
	{
		String browserName=prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(browserName.contains("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().deleteAllCookies();
		}
		else if(browserName.contains("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
