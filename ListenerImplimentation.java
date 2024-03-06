package Vtiger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Commonutil.JavaUtil;

public class ListenerImplimentation implements ITestListener{
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"Testscript excution is started",true);
		test = report.createTest(methodName);
		test.log(Status.PASS,"Testscript excution is started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"Testscript excution is Passed",true);
		test.log(Status.PASS,"Testscript excution is Passed");
		//test.log(Status.PASS, null);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String massage = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"Testscript excution is failed"+massage,true);
		test.log(Status.PASS,"Testscript excution is failed");


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"Testscript excution is Skipped",true);
		test.log(Status.PASS,"Testscript excution is Skipped");


	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//String methodName = result.getMethod().getMethodName();

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//String methodName = result.getMethod().getMethodName();

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//Reporter.log("Testscript excution is started",true);
		
		//use ExtentSparkReporter class just to configure extend report
		
		JavaUtil  jutil = new JavaUtil();
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extendreport/report"+jutil.getRandomNumber()+".html");
		reporter.config().setDocumentTitle("vtigercrm");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Mumbai");
		
		//use ExtentReports to generate extentReport
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS","Window 11");
		report.setSystemInfo("Browser","Chrome");
		report.setSystemInfo("chromeversion","122");
		report.setSystemInfo("Author","Mumbai");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//Reporter.log("Testscript excution is finished",true);
		
		report.flush();

	}

}







