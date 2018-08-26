package mainPackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import genericTestCases.LoginTests;
public class TestExecute {
	
	public static ExtentReports report;
	public static ExtentTest logger;
	@BeforeSuite
	public void newTest() {
		
		BaseClass.initDriver();
		BaseClass.initConfig();
		BaseClass.loadDataSheet();
		BaseClass.loadBatchSheet();
	}
	
	@Test
	public void TestExecution() {
		report=new ExtentReports(System.getProperty("user.dir")+"//TestCase1.html",true);
		logger=report.startTest("TestCase 1");
		LoginTests test=new LoginTests();
		
//		Set<String> functions= new TreeSet<String>();
//		functions=BaseClass.BatchMap.keySet();
//		//test.TestCase2();
//		for(String function:functions) {
//			System.out.println(function);
//			try {
//				Method m=LoginTests.class.getMethod(function);
//				m.invoke(test);
//			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}		
//		}
		
		test.TestCase1();
		report.endTest(logger);
	}
	
	@Test
	public void TestExecution1() {
		report=new ExtentReports(System.getProperty("user.dir")+"//TestCase2.html",true);
		logger=report.startTest("TestCase 2");
		LoginTests test=new LoginTests();
		test.TestCase2();
		report.endTest(logger);
	}
	
	@AfterTest
	public void ReportGeneration() {
		report.flush();
		report.close();
	}
	
	@AfterSuite
	public void closemethod() {
		BaseClass.driver.quit();	
	}
	
	
	
	
}
