package TestCase;

import java.io.FileNotFoundException;
//import java.io.File;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import TestObject.objectTwo;
import utility.TakeScreenshot;
import utility.driverClass;
import utility.excelUtils;
import utility.extendReportmanager;
import utility.extendReportmanager2;
import utility.utility;
import utility.xmlRead;
import utility.xmlWrite;

public class diagnostics {
	public WebDriver driver;
	public static List<WebElement> list1;
	public List<WebElement> list2;
	public String xmlArr[]=new String[15];
	public objectTwo two;
	public static ExtentReports report2;
	public static ExtentTest logger2;
	public static String fileName="citiesOutput";
	
	@BeforeTest
	public void testcaseRexl() throws IOException, FileNotFoundException

	{
    xmlRead.readxml(xmlArr);   
	excelUtils.readexcel();     // Reading input values from Excel sheet
    }
	
	
	
	@Parameters("browser")
	@BeforeClass
	public void driverconfig(String browser) throws IOException

	{

	driver=driverClass.driverInstantiate(browser);    //Creating a driver   
	report2 =extendReportmanager.getReportInstance();  //Creating a report

	}

	 @Test(priority=1)
	  public void craeteObject() throws InterruptedException

	  {  
		 logger2=report2.createTest("createObject");
	     two=new objectTwo(driver);                   // Creating an object for objectTwo class
	  	       
	  }
	 @Test(priority=2)
	  public void clickOnDiagnostics() throws InterruptedException

	  {  logger2=report2.createTest("clickOnDiagnostics");
		 new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(two.clickOnDiagnostics(driver))); 
		 two.clickOnDiagnostics(driver).click();  // Clicking on the diagnostics element
		// Thread.sleep(5000);
		
      }
	 @Test(priority=3)

	  public void screenshot()throws IOException

	  {
		 logger2=report2.createTest("screenshot");	
	     TakeScreenshot.screenShotTC(driver);     //taking screenshot of the results page of the top cities
         
	  }

	  @Test(priority=4)
	  public void testcaseWrite() throws InterruptedException

	  {     logger2=report2.createTest("testcaseWrite");
		    list1=two.clickOnCities(driver);     // Getting the list of top cities
		   excelUtils.writeexcels(list1);        //Writing output cities to the excel sheet
		    xmlWrite.CreateAXmlFile(fileName);   // Writing output cities to the xml sheet
		    for(WebElement a:list1)
		    {
		    logger2.log(Status.INFO,a.getText());
		    System.out.println(a.getText());       // printing the list of top cities
		    }
		    
		 
			
	   }
	  @AfterMethod
	  public void tearDown(ITestResult result) throws IOException{
	  	if(result.getStatus()==ITestResult.FAILURE) {
	  		String temp=utility.getScreenshot(driver);      
	  		logger2.pass(result.getThrowable().getMessage(),       
	  				MediaEntityBuilder.createScreenCaptureFromPath(temp).build());  // Taking the screenshot for the failure testcases
	  		
	  	}
	  }
	 @AfterClass

	  public void driverexit() 
	  {

		 logger2=report2.createTest("driverexit");
	     driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	     driver.quit();    // Closing the driver
	     report2.flush();  // creating the report        
	       

	  }	
	
}