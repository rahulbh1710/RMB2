package com.vtiger.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.common.Xls_Reader;
import com.vtiger.pages.AccountPage;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static LoginPage lp;
	public static HomePage hp ;
	public static AccountPage ac;
	public static Properties prop;
	public  static LeadPage ldp;
	public static Map<String ,Map<String, String>> data;
	public static ExtentHtmlReporter  htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest Logger;
	
	
	
	
	

	
	
	@AfterMethod()
	public void flushreport()
	{
		extent.flush();
	}
	
	@BeforeSuite()
	
	public void init()
	{
		
		
		
		prop = readProperties(System.getProperty("user.dir")+  "/src/test/resources/config/setting.properties");
		createReport() ;
		startDriver();
		data= ReadExcelData(System.getProperty("user.dir")+"/src/test/resources/Data/Data1.xlsx", "Sheet1");
			
	}
	
	@AfterSuite
	public void teardown()
	{
		
		driver.quit();
	}
	
	public void startDriver()
	{
		if (prop.getProperty("browsername").equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(prop.getProperty("browsername").equals("edge"))
		{
		WebDriverManager.edgedriver().setup();;
		driver = new EdgeDriver();
		}
		else if(prop.getProperty("browsername").equals("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();;
		driver = new FirefoxDriver();
		}
		else 
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		driver.get("http://localhost:100");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	
	public Properties readProperties(String file)
	{
		
		FileInputStream fis =null;
		Properties prop = new Properties();
	try {
		 fis = new FileInputStream(file);
	
		prop.load(fis);
	} catch (IOException e) 
	{
    e.printStackTrace();
	}
	return prop;
	}
	
	public 	Map<String ,Map<String, String>>  ReadExcelData(String file,String Sheet)
	{
		Xls_Reader xr = new Xls_Reader(file);
		int rowcount = xr.getRowCount(Sheet);
		int columncount = xr.getColumnCount(Sheet);
		Map<String ,Map<String, String>> AllData = new HashMap<String, Map<String, String>>();
		for(int i=2;i<=rowcount;i++)
		{
			Map<String, String> map = new HashMap<String, String>();
			for (int j=1;j<=columncount;j++)
			{
				String data = xr.getCellData(Sheet, j, i).trim();
				map.put(xr.getCellData(Sheet, j, 1).trim(), data);
			} 
			AllData.put(xr.getCellData(Sheet, 0, i).trim(), map);
		}
		return AllData; 
	}
	public void createReport() 
	{
		DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
		Date d = new Date();
		String str = f.format(d);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+str+".html");
    	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		    	extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Rajesh U");
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
		            // Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here "); 
		            // Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD); 
	}
}
