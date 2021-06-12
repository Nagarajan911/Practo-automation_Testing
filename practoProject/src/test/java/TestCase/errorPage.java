package TestCase;
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
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

//import TestObject.objectOne;
import TestObject.objectThree;
//import TestObject.objectTwo;
import utility.TakeScreenshot;
import utility.driverClass;
import utility.excelUtils;
import utility.extendReportmanager;
import utility.extendReportmanager2;
import utility.extendReportmanager3;
import utility.utility;
import utility.xmlRead;
public class errorPage {
   public	WebDriver driver;
		public String parent;
	public List<WebElement> list1,list2;
	public String xmlArr[]=new String[15];
	public String firstErrorMsg,secondErrorMsg,thirdErrorMsg,fourthErrorMsg,fifthErrorMsg;
	public objectThree three;
	public static ExtentReports report3;
	public static ExtentTest logger3;

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
	report3 =extendReportmanager.getReportInstance();  //Creating a report

	}
	
	@Test(priority=1)
	public void createObject()

	{
		 logger3=report3.createTest("createObject");
		 three=new objectThree(driver);   // Creating an object


	}
	 @Test(priority=2)
	  public void getParentWindow()

	  {  logger3=report3.createTest("getParentWindow");
		 parent=driver.getWindowHandle();               // Getting parent window
		 System.out.println("Parent window "+parent );
			
	   }
	  @Test(priority=3)
	  public void clickOnProviders()

	  {   logger3=report3.createTest("clickOnProviders");
		  new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable( three.clickOnForProviders(driver))); 
		 three.clickOnForProviders(driver).click();  // Clicking on the for providers element
	  	       
	  }
	  @Test(priority=4)
	  public void clickOnCorporate()

	  {  	logger3=report3.createTest("clickOnCorporate");
		    new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(three.clickOnCorporate(driver))); 
		     three.clickOnCorporate(driver).click();  //clicking on the corporate element
	  	       
	  }
	  @Test(priority=5)
	  public void childWindowSwitch()
	  {
		  logger3=report3.createTest("childWindowSwitch");
		  Set<String>allWindows=driver.getWindowHandles();  //Getting all the windows names
		int count=allWindows.size();                         // Getting the count of available windows
		System.out.println("Total windows count "+count);
		
		for(String child:allWindows)
		{
			if(!parent.equalsIgnoreCase(child))        // Comparing child window with the parent window
			{   driver.switchTo().window(child);       // Switching to the child windows
			   
				System.out.println(child);
				
			}
		}
				  
	  }
	  
	  @Test(priority=6)
	  public void firstErrorMessage () throws IOException   // Error msg :Please Enter Name
, InterruptedException

	  {  logger3=report3.createTest("firstErrorMessage");
		  new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(three.clickOnSubmit(driver))); 
	     three.clickOnSubmit(driver).click();
		 
		 Alert name=driver.switchTo().alert(); // Switching the windowHandle to the alert popup
		 firstErrorMsg=name.getText();        //Getting the first Error message
		 System.out.println(firstErrorMsg);   // Writing alert message to the console
		 logger3.log(Status.INFO,firstErrorMsg);  //Writing the alert message to the report
		 name.accept();                         // Accepting the alert popup
	  	       
	  }
	  @Test(priority=7)

	  public void screenshot()throws IOException

	  {
	  	
		  logger3=report3.createTest("screenshot");
		  TakeScreenshot.screenShotTC(driver);   // Taking a screenshot of corporate wellness page
	  
	                                         

	  }
	  
	  @Test(priority=8)
	  public void secondErrorMessage ()   // Error msg :Please Enter Organization name

	  {   logger3=report3.createTest("secondErrorMessage");
		  three.clickOnName(driver).sendKeys(excelUtils.name);
		 
	  new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(three.clickOnSubmit(driver))); 
	  three.clickOnSubmit(driver).click();
		 
		 Alert org=driver.switchTo().alert();      // Switching the windowHandle to the alert popup
		 secondErrorMsg=org.getText();              //Getting the second Error message
		 System.out.println(secondErrorMsg);        // Writing the error message to the console
		 logger3.log(Status.INFO,secondErrorMsg);    // Writing  the error message to the report
		 org.accept();                               // Accepting the alert popup
		 
	  	       
	  }
	  @Test(priority=9)
	  public void thirdErrorMessage ()   // Error msg :Please Enter Official email id

	  {   logger3=report3.createTest("thirdErrorMessage");
		  three.clickOnOrganization(driver).sendKeys(xmlRead.category2);
		 
	  new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(three.clickOnSubmit(driver))); 
	  three.clickOnSubmit(driver).click();
		 
		 Alert EnterMail=driver.switchTo().alert();   // Switching the windowHandle to the alert popup
		 thirdErrorMsg=EnterMail.getText();            //Getting the third Error message
		 System.out.println(thirdErrorMsg);            // Writing the error message to the console
		 logger3.log(Status.INFO,thirdErrorMsg);       // Writing  the error message to the report
		 EnterMail.accept();                           // Accepting the alert popup
		 
	  	       
	  }
	  @Test(priority=10)
	  public void fourthErrorMessage ()   // Error msg :Please enter valid email address

	  {   logger3=report3.createTest("fourthErrorMessage");
		  three.clickOnMail(driver).sendKeys(xmlRead.category3);
		 
	  new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(three.clickOnSubmit(driver))); 
	  three.clickOnSubmit(driver).click();
		 
		 Alert EnterValidMail=driver.switchTo().alert();     // Switching the windowHandle to the alert popup
		 fourthErrorMsg=EnterValidMail.getText();            //Getting the fourth Error message
		 System.out.println(fourthErrorMsg);                // Writing the error message to the console
		 logger3.log(Status.INFO,fourthErrorMsg);           // Writing  the error message to the report
		EnterValidMail.accept();                            // Accepting the alert popup
		
		three.clickOnMail(driver).clear();
	  	       
	  } 
	  @Test(priority=11)
	  public void fifthErrorMessage () throws InterruptedException   // Error msg :Please Enter Official phone no

	  {   logger3=report3.createTest("fifthErrorMessage");
		  three.clickOnMail(driver).sendKeys(xmlRead.category4);
		 
	  new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(three.clickOnSubmit(driver))); 
	  three.clickOnSubmit(driver).click();
		 
		 Alert EnterContactNo=driver.switchTo().alert();     // Switching the windowHandle to the alert popup
		 fifthErrorMsg=EnterContactNo.getText();              //Getting the fifth Error message
		 System.out.println(fifthErrorMsg);                   // Writing the error message to the console
		 logger3.log(Status.INFO,fifthErrorMsg);              // Writing  the error message to the report
		 EnterContactNo.accept();  	                          // Accepting the alert popup
		 //Thread.sleep(4000);
	  }
	  @Test(priority=12)
	  public void testcaseWriteError() throws InterruptedException 

	  {

		  
		  logger3=report3.createTest("testcaseWriteError");
		  excelUtils.writeexcelDemo(firstErrorMsg,secondErrorMsg,thirdErrorMsg,fourthErrorMsg,fifthErrorMsg);
		                             // Writing the error messages to the excel sheet
	  }
	  @SuppressWarnings("unchecked")
	@Test(priority=13)
	  public void testcaseWriteJson() throws InterruptedException 

	  {

		  
		  logger3=report3.createTest("testcaseWriteJson");
		  JSONObject obj=new JSONObject();                   // Creating the JSON Object
		   obj.put("First Error Message",firstErrorMsg);      // fetching first error message to the JSON Object
		   obj.put("Second Error Message",secondErrorMsg);    // fetching second error message to the JSON Object
		   obj.put("Third Error Message",thirdErrorMsg);      // fetching third error message to the JSON Object
		   obj.put("Fourth Error Message",fourthErrorMsg);    // fetching fourth error message to the JSON Object
		   obj.put("Fifth Error Message",fifthErrorMsg);      // fetching fifth error message to the JSON Object
		   try(FileWriter file=new FileWriter("myJSON.json"))// Creating a JSON file using FileWriter
		   {	   
			   file.write(obj.toString());                     // Writing error Messages into the JSON file
			   file.flush();                                   // Creating a JSON file
		   }
		   catch(IOException e) {
			   e.printStackTrace();
		   }
		  
	  }
	  @AfterMethod
	  public void tearDown(ITestResult result) throws IOException{
	  	if(result.getStatus()==ITestResult.FAILURE) {
	  		String temp=utility.getScreenshot(driver);      
	  		logger3.pass(result.getThrowable().getMessage(),       
	  		MediaEntityBuilder.createScreenCaptureFromPath(temp).build());  // Taking the screenshot for the failure testcases
	  		
	  	}
	  }
	  @AfterClass

	  public void driverexit() 
	  {

      logger3=report3.createTest("driverexit");
	  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	  driver.quit();      // Closing the driver
	  report3.flush();   // Creating the report

	  }	
}

	 
	
	
	

