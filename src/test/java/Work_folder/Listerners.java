package Work_folder;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;

public class Listerners extends Base implements ITestListener {
	ExtentTest test;
	ThreadLocal<ExtentTest> extendTest = new ThreadLocal(); // For paralle Execution it will create Thread pool to avoid Ovrriding 
	ExtentReports extent=ExtentReporterNG.getReportObject();
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//sreenshot
		extendTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testcaseName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}  catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			extendTest.get().addScreenCaptureFromPath(takeScreenshot(testcaseName,driver), result.getMethod().getMethodName());// This Method will take SS and Attach SS into Extend Report
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test= extent.createTest(result.getMethod().getMethodName());
		extendTest.set(test);
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		extendTest.get().log(Status.PASS, "Test Passed");
	}
	
	
	

}
