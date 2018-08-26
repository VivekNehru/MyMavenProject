package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mainPackage.BaseClass;
import mainPackage.FindElement;
import mainPackage.TestExecute;

public class ForumPage {

	private Actions action;
	private ExtentTest logger=TestExecute.logger;
	
	 public ForumPage () {
		 this.action=BaseClass.action;
	 }
	 
	 public void GetReservationDate() {
		 try {
			 
		 WebElement Forum=FindElement.ByLinkText("Forum");
		 action.moveToElement(Forum);
		 WebElement MainForum=FindElement.ByXpath("//td[contains(text(),'Main') and @pref='/blog']");
		 action.moveToElement(Forum).moveToElement(MainForum).click().build().perform();
		 WebElement DateString=FindElement.WaitByXpath("//div[@class='mytickerouter']/child::br[4]/following::text()");
		 WebElement Date=FindElement.ByXpath("//div[@class='mytickerouter']//child::b[4]");
		 System.out.println("DateString:"+DateString.getText()+" Date:"+Date.getText());
		 logger.log(LogStatus.PASS, "The ARP Dates are "+Date.getText());
	 }
		 catch(Exception e) {
			 logger.log(LogStatus.FAIL, "Not able to get dates");
		 }
	 
	 }
	
}
