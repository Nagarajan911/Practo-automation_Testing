package TestCase;
//import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
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
//import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.Status;

import TestObject.objectOne;
//import TestObject.objectTwo;
import utility.utility;
import utility.xmlRead;
//import utility.xmlRead;
import utility.extendReportmanager;
import utility.extendReportmanager2;
import utility.TakeScreenshot;
//import TestObject.objectThree;

import utility.driverClass;
import utility.excelUtils;

public class hospitalName{
	public WebDriver driver;
	public String arr[]=new String[15];
	public String xmlArr[]=new String[15];
	public List<WebElement> list1,list2;
	
	public objectOne one;
	public static ExtentReports report;
	public static ExtentTest logger;
	
	
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
	report =extendReportmanager.getReportInstance();  //Creating a report

	}
	
	
	
	@Test(groups= {"sanity"},priority=1)
	public void createObject()

	{
		logger =report.createTest("createObject");
		one=new objectOne(driver);                   //Creating an object for objectOne Class
		


	}
	@Test(priority=2)
	public void clickOnLocation() throws InterruptedException

     {  logger =report.createTest("clickOnLocation");
		one.clickOnLocations(driver).clear();                 // clicking on the location text box
		Thread.sleep(2000);
		one.clickOnLocations(driver).sendKeys(excelUtils.category1);  // Sending location to the textbox from the excel sheet
		Thread.sleep(2000);
		
	}
	@Test(priority=3)
	public void selectLocation() throws InterruptedException

     {     logger =report.createTest("selectLocation");
		 for(int i=0;i<one.clickOnPlaceList(driver).size();i++)
		    {  logger.log(Status.INFO,one.clickOnPlaceList(driver).get(i).getText()); //Getting the list of suggested cities from the website
		   	   System.out.println(one.clickOnPlaceList(driver).get(i).getText());
		      if(one.clickOnPlaceList(driver).get(i).getText().contains(excelUtils.category1)) // Comparing the list of cities with the input from the excel sheet
		   	   {  
		   	
		   	   new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(one.clickOnPlaceList(driver).get(i)));   		
		       one.clickOnPlaceList(driver).get(i).click();        //selecting the required city from the list
		   	   break;
		   	   }
		      
		    } 


	}
	 
	  @Test(priority=4)
	  public void clickOnHospitalTextBox() throws InterruptedException

	  {   logger =report.createTest("clickOnHospitalTextBox");
		  //Thread.sleep(2000);
		  one.clickOnHosTextBox(driver).sendKeys(excelUtils.category2);  // Sending input to the category textbox to search for the hospitals
		  Thread.sleep(2000);
	  	       
	  }
	  
	  @Test(priority=5)
	  public void selectHospital() throws InterruptedException

	  {   logger =report.createTest("selectHospital");
		  new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(one.clickOnHospital(driver))); 
	      one.clickOnHospital(driver).click();      // selecting the hospitals from the dropdown list
		 // Thread.sleep(2000);
	  	       
	  }
	  @Test(priority=6)
	  public void clickOnOpen() throws InterruptedException

	  {  
		 
		  logger =report.createTest("clickOnOpen");
		  new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(one.clickOnOpen(driver))); 
	       one.clickOnOpen(driver).click();     // Clicking on the open 24X7 checkbox
	      Thread.sleep(2000);
	  }
	  @Test(priority=7)
	  public void clickOnArrow1() throws InterruptedException

	  {    logger =report.createTest("clickOnArrow1");
		  new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(one.clickOnArrow1(driver))); 
	    one.clickOnArrow1(driver).click();    // clicking on the All filters downhead arrow 
	 // Thread.sleep(2000);
	  	       
	  }
	  
	  @Test(priority=8)
	  public void clickOnHasParking() throws InterruptedException

	  { logger =report.createTest("clickOnHasParking");
		  new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable( one.clickOnParking(driver))); 
	     one.clickOnParking(driver).click();      // clicking on the Has parking checkbox
		 Thread.sleep(2000); 
	  	       
	  }
	  @Test(priority=9)

	  public void screenshot()throws IOException

	  {
	  	logger =report.createTest("screenshot");	
	  TakeScreenshot.screenShotTC(driver);     //taking screenshot of the results page of Hospitals

	  }
	  @Test(priority=10)
	  public void getOutput() throws InterruptedException

	  {  
		  logger =report.createTest("getOutput");
		for(int i=2;i<=11;i++)
		{                                                                                                  
		arr[i]=driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div/div[2]/div[1]/div/div[3]/div["+ i+"] /div/div[1]/div[1]/div/div[2]/div/a/h2")).getText();
		System.out.println(arr[i]);        // Getting the list of hospitals for the given input
		logger.log(Status.INFO,arr[i]);    //Writing the output hospital list to the report
		
		}
      }
	  
	  @Test(priority=11)
	  public void testcaseWrite() throws InterruptedException

	  {  logger =report.createTest("testcaseWrite");
		  excelUtils.writeexcel(arr);                // Writing the output in the excel sheet
			
		  
	   }
	  @AfterMethod
	  public void tearDown(ITestResult result) throws IOException{
	  	if(result.getStatus()==ITestResult.FAILURE) {
	  		String temp=utility.getScreenshot(driver);      
	  		logger.pass(result.getThrowable().getMessage(),       
	  				MediaEntityBuilder.createScreenCaptureFromPath(temp).build());  // Taking the screenshot for the failure testcases
	  		
	  	}
	  }

	 @AfterClass

	  public void driverexit() 
	  {
		 logger =report.createTest("driverexit");
	  	
	  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	  driver.quit();     // closing the driver
	  report.flush();   // creating the report
	       

	  }	
	  


}
