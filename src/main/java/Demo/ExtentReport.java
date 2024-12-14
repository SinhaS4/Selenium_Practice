package Demo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class ExtentReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("unused")
		ExtentHtmlReporter htlmReporter=new ExtentHtmlReporter("Report.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htlmReporter);
		
		ExtentTest Test1=extent.createTest("AmzonPageTesting");
	}

}
