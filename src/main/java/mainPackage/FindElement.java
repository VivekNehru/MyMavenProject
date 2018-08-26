package mainPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindElement {
	
	private static WebDriver driver=BaseClass.driver;
	private static WebDriverWait wait=BaseClass.wait;
	private static JavascriptExecutor js= BaseClass.js;
	
	public static WebElement ById(String id) {
		
		WebElement Element=driver.findElement(By.id(id));
		
		for (int i=0;i<3;i++) { 
		js.executeScript("arguments[0].style.border='3px solid black'",Element);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("arguments[0].style.border='3px solid white'",Element);
		
	}
		return Element;
	}
	
	public static WebElement ByXpath(String xpath) {
			
			WebElement Element=driver.findElement(By.xpath(xpath));
			
			for (int i=0;i<3;i++) { 
				js.executeScript("arguments[0].style.border='3px solid black'",Element);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				js.executeScript("arguments[0].style.border='3px solid white'",Element);
				
			}
			return Element;
		}
	

	public static WebElement ByTagName(String name) {
		
		WebElement Element=driver.findElement(By.tagName(name));
		
		for (int i=0;i<3;i++) { 
		js.executeScript("arguments[0].style.border='3px solid black'",Element);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		js.executeScript("arguments[0].style.border='3px solid white'",Element);
		
	}
		return Element;
	}
	
	public static WebElement ByLinkText(String text) {
			
			WebElement Element=driver.findElement(By.linkText(text));
			for (int i=0;i<3;i++) { 
				js.executeScript("arguments[0].style.border='3px solid black'",Element);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				js.executeScript("arguments[0].style.border='3px solid white'",Element);
				
			}
			return Element;
		}
	
	public static WebElement ByPartialLinkText(String text) {
		
		WebElement Element=driver.findElement(By.partialLinkText(text));
		
		for (int i=0;i<3;i++) { 
			js.executeScript("arguments[0].style.border='3px solid black'",Element);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			js.executeScript("arguments[0].style.border='3px solid white'",Element);
			
		}
		return Element;
	}

public static WebElement WaitById(String id) {
		
		WebElement Element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		
		for (int i=0;i<3;i++) { 
			js.executeScript("arguments[0].style.border='3px solid black'",Element);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			js.executeScript("arguments[0].style.border='3px solid white'",Element);
			
		}
		return Element;
	}
	
	public static WebElement WaitByXpath(String xpath) {
			
			WebElement Element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			
			for (int i=0;i<3;i++) { 
				js.executeScript("arguments[0].style.border='3px solid black'",Element);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				js.executeScript("arguments[0].style.border='3px solid white'",Element);
				
			}
			return Element;
		}
}
