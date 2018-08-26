package genericTestCases;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mainPackage.TestExecute;
import pageObjects.ForumPage;
import pageObjects.LoginPage;

public class LoginTests {

	LoginPage login=new LoginPage();
	ForumPage forum= new ForumPage();
	private ExtentTest logger=TestExecute.logger;
	
	public void TestCase1() {
		logger.log(LogStatus.INFO, "Testcase 1 Started");
		login.Login("uid", "pwd");
		login.logout();
		logger.log(LogStatus.INFO, "Testcase 1 completed");
	}
	
	public void TestCase2() {
		logger.log(LogStatus.INFO, "Testcase 2 Started");
		login.Login("uid", "pwd");
		forum.GetReservationDate();
		login.logout();
		logger.log(LogStatus.INFO, "Testcase 2 Completed");
		
	}
}
