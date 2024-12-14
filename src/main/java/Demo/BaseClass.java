package Demo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public static WebDriver driver;
	
	@SuppressWarnings("unused")
	protected ExtentHtmlReporter htlmReporter=new ExtentHtmlReporter("AmazonReport.html");
	protected ExtentReports extent = new ExtentReports();
	
	
	@BeforeClass
	public  void Setup() throws InterruptedException, IOException {
//    	ChromeOptions options = new ChromeOptions();
//    	options.addArguments("--remote-debugging-port=9222");
//    	System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
//		//WebDriver driver = new ChromeDriver();
    	//ChromeDriver driver = new ChromeDriver(options);
		//WebDriver driver=new ChromeDriver(options);
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	   driver.get("https://amazon.in");
	   driver.manage().timeouts().implicitlyWait(500,TimeUnit.SECONDS);
	   String Actual=driver.getTitle();
	   String Expected="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	   Assert.assertEquals(Actual,Expected);
	   File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   FileUtils.copyFile(file, new File(".//screenshot/amazon.png"));
	   
   }
	
//	public static void ExtentReport()
//	{
//		@SuppressWarnings("unused")
//		ExtentHtmlReporter htlmReporter=new ExtentHtmlReporter("Report.html");
//		ExtentReports extent = new ExtentReports();
//		extent.attachReporter(htlmReporter);
//		
//		ExtentTest Test1=extent.createTest("AmzonPageTesting");
//	}
	 @AfterClass
		public void closeBrowser()
		{
			driver.quit();	
		}
}
