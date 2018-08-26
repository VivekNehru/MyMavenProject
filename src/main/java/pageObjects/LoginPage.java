package pageObjects;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mainPackage.BaseClass;
import mainPackage.FindElement;
import mainPackage.TestExecute;


public class LoginPage {
	private WebDriver driver;
	private Properties Cprop;
	private Actions action;
	private ExtentTest logger=TestExecute.logger;
	
	 public LoginPage () {
		 
		 this.driver=BaseClass.driver;
		 this.Cprop=BaseClass.Cprop;
		 this.action=BaseClass.action;
	 }
	 
	public void Login(String uname,String pwd) {
		driver.navigate().to(Cprop.getProperty("url"));
		WebElement Uname=FindElement.ById("LoginEMail");
		WebElement pswd=FindElement.ById("LoginPwd");
		WebElement login= FindElement.ByXpath("//input[@type='submit' and @tabindex='405']");
		Uname.sendKeys(Cprop.getProperty(uname));
		pswd.sendKeys(Cprop.getProperty(pwd));
		login.click();
				
		/*WebElement member=driver.findElement(By.xpath("//a[@class='inactive' and text()='Member #1335551']"));*/
		WebElement member=FindElement.WaitByXpath("//a[@class='inactive' and text()='Member #1335551']");
		if (member.getText().equals("Member #1335551")) {
			logger.log(LogStatus.PASS, "Logged in Successfully");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		else {
			logger.log(LogStatus.FAIL, "Login Failed");
		}
	}
	
	public void logout() {
		WebElement member=FindElement.ByXpath("//a[@class='inactive' and text()='Member #1335551']");
		action.moveToElement(member);
		WebElement logout=FindElement.ByXpath("//td[contains(text(),'Member') and @pref='/logout']");
		action.moveToElement(member).moveToElement(logout).click().build().perform();
		
		
		WebElement login=FindElement.WaitByXpath("//a[@class='inactive' and contains(text(),'Login')]");
		
		if (login.getText().equals("Login")) {
			logger.log(LogStatus.PASS, "Logout Successfull");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			logger.log(LogStatus.FAIL, "Logout Failed");
		}
	}
}
