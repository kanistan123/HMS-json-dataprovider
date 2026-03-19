package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Report implements ITestListener{
	
	
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	public void onStart(ITestContext context){
		sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/testreport/myreport.html");
		sparkreporter.config().setDocumentTitle("Automation_HMS_Report");
		sparkreporter.config().setReportName("Automation_Test_Report");
		sparkreporter.config().setTheme(Theme.STANDARD);
		
		extent =new ExtentReports();
		extent.attachReporter(sparkreporter);
		
		extent.setSystemInfo("computer name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester name", "Kanistan");
		extent.setSystemInfo("OS", "windows11");
		extent.setSystemInfo("Browser name", "chrome");
				
	}
	
	
	public void onTestSuccess(ITestResult result) {
		extent.createTest(result.getName());
		test.log(Status.PASS, "testcase passed is:"+result.getName());
	}
	
	
	public void onTestFailure(ITestResult result) {
		extent.createTest(result.getName());
		test.log(Status.FAIL, "testcase failed is:"+ result.getName());
	}
	
	public void onTestSkipped(ITestResult result) {
		extent.createTest(result.getName());
		test.log(Status.SKIP, "testcase skipped is:"+result.getName());
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	

}
