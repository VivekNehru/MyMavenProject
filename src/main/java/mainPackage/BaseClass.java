package mainPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;

public class BaseClass {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ExtentReports extent;
	public static Actions action;
	private static String ConfigPath=System.getProperty("user.dir")+"\\src\\main\\resources\\Config.Properties";
	private static String BatchPath=System.getProperty("user.dir")+"\\src\\main\\resources\\BatchSheet.xls";
	private static String DataSheetPath=System.getProperty("user.dir")+"\\src\\main\\resources\\Datasheet.xls";	
	public static Properties Cprop;
	public static JavascriptExecutor js;
	public static Map<String,Map<String,Map<String,String>>> DataMap=new LinkedHashMap<String,Map<String,Map<String,String>>>();
	public static Map<String, Map<String, String>> RowMap;
	public static Map<String,String> ColumnMap;
	public static Map<String,Map<String,String>> BatchMap=new LinkedHashMap<String,Map<String,String>>() ;
	public static FileInputStream fis1;
	public static FileInputStream fis2;
	public static HSSFWorkbook DataSheet;
	public static HSSFWorkbook BatchSheet;
	
	public static void initDriver() {
		System.setProperty("webdriver.chrome.driver","H:\\Java\\chromedriver.exe");	
		driver=new ChromeDriver();
		action=new Actions(driver);
		wait=new WebDriverWait(driver,10);
		driver.manage().window().maximize();
		action=new Actions(driver);
		js=(JavascriptExecutor)driver;
	}
	
	public static void initRemoteDriver() {
		System.setProperty("webdriver.chrome.driver","H:\\Java\\chromedriver.exe");	
		DesiredCapabilities cap= DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		try {
			URL url=new URL("http://192.168.1.5:5555/wd/hub");
			driver=new RemoteWebDriver(url,cap);
			action=new Actions(driver);
			wait=new WebDriverWait(driver,10);
			driver.manage().window().maximize();
			action=new Actions(driver);
			js=(JavascriptExecutor)driver;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initConfig() {
		
		
				try {
					File file1= new File(ConfigPath);
					FileInputStream fis = new FileInputStream(file1);
					Cprop=new Properties();
					Cprop.load(fis);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	
	public static void loadDataSheet() {
		
		
		try {
			fis1 = new FileInputStream(new File(DataSheetPath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			DataSheet = new HSSFWorkbook(fis1);
			int SheetCount=DataSheet.getNumberOfSheets();
			
			
			for(int i=0;i<SheetCount;i++) {
			HSSFSheet sheet1= DataSheet.getSheetAt(i);
			String SheetName=sheet1.getSheetName();
			int RowCount=sheet1.getLastRowNum();
			RowMap=new LinkedHashMap<String,Map<String,String>>();
			
			for(int j=1;j<RowCount+1;j++) {
			HSSFRow row=sheet1.getRow(j);
			String key1= row.getCell(0).getStringCellValue();
			int ColCount=row.getLastCellNum();
			ColumnMap=new LinkedHashMap<String,String>();
			
			for (int k=1;k<ColCount;k++) {
			String key2=sheet1.getRow(0).getCell(k).getStringCellValue();
			String key3=row.getCell(k).getStringCellValue();
			ColumnMap.put(key2, key3);
			}
			
			RowMap.put(key1, ColumnMap);
			
			}
			DataMap.put(SheetName, RowMap);
			
			}
		}
			
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	
	public static void loadBatchSheet() {
		
		try {
			fis2=new FileInputStream(new File(BatchPath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			BatchSheet=new HSSFWorkbook(fis2);
			HSSFSheet sheet2=BatchSheet.getSheetAt(0);
			int RowCount = sheet2.getLastRowNum();
			
			for (int i=1;i<RowCount+1;i++) {
				HSSFRow row=sheet2.getRow(i);
				int ColCount=row.getLastCellNum();
				String key1=row.getCell(0).getStringCellValue();
				Map<String,String> sheetmap=new LinkedHashMap<String,String>();
				
				for (int j=1;j<ColCount;j++) {
					String key2=sheet2.getRow(0).getCell(j).getStringCellValue();
					String key3=row.getCell(j).getStringCellValue();
					sheetmap.put(key2,key3);
					}
				BatchMap.put(key1,sheetmap);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static String GetDatasheetValue(String Sheet,String Row,String Column) {
		Map<String,Map<String,String>> getRowMap=DataMap.get(Sheet);
		Map<String,String> getColumnMap=getRowMap.get(Row);
		String ColumnValue=getColumnMap.get(Column);
		return ColumnValue;
		
	}
	
	public static String GetBatchsheetValue(String Row,String Column) {
		
		Map<String,String> getColumnMap=BatchMap.get(Row);
		String ColumnValue=getColumnMap.get(Column);
		return ColumnValue;
		
	}
}
