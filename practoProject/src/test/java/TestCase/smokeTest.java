package TestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.junit.Assert;  
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import TestObject.objectOne;
import TestObject.objectThree;
import TestObject.objectTwo;
import utility.driverClass;
import utility.excelUtils;

import utility.extendReportmanager2;
import utility.xmlRead;

public class smokeTest {
	public WebDriver driver;
	public String arr[]=new String[15];
	public String xmlArr[]=new String[15];
	public List<WebElement> list1,list2;
	
	public objectOne one;
	public objectTwo two;
	public objectThree three;
	public String parent;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static String url,pageOne,pageTwo,pageThree,pageFour ;
	
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
	report =extendReportmanager2.getReportInstance();  //Creating a report

	}
	
	
	
	@Test(priority=1)
	public void createObject()

	{
		logger =report.createTest("createObject");
		one=new objectOne(driver);                   //Creating an object for objectOne Class
		two=new objectTwo(driver); 
		three=new objectThree(driver);
	}

	@Test(priority=2)
	public void createProperties() throws IOException

	{
		Properties pro=new Properties();
		FileInputStream inp=new FileInputStream("F:\\JAVA\\eclipse\\practoProject\\src\\test\\resources\\config.properties");
	     pro.load(inp);
	     url=pro.getProperty("url");                // Home page URL
	     pageOne=pro.getProperty("pageOne");        // Home Page
	     pageTwo=pro.getProperty("pageTwo");        // HospitalName Page
	     pageThree=pro.getProperty("pageThree");    // Diagnostics Page
	     pageFour=pro.getProperty("pageFour");      // Corporate Wellness Page
	}
	@Test(priority=3)
	public void checkPageOne()

	{
		logger =report.createTest("checkPageOne");
		String actual=driver.getTitle();
		//String expected="Practo | Book Doctor Appointments Online, Order Medicine, Diagnostic Tests, Consult";
		String expected=pageOne;
		System.out.println("expected One "+expected);
		System.out.println("actual One "+actual);
		Assert.assertEquals(expected,actual);
		 
	}

@Test(priority=4)
public void clickOnLocation() throws InterruptedException

 {  logger =report.createTest("clickOnLocation");
	one.clickOnLocations(driver).clear();                 // clicking on the location text box
	Thread.sleep(2000);
	one.clickOnLocations(driver).sendKeys(excelUtils.category1);  // Sending location to the textbox from the excel sheet
	Thread.sleep(2000);
	
}
@Test(priority=5)
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
 
  @Test(priority=6)
  public void clickOnHospitalTextBox() throws InterruptedException

  {   logger =report.createTest("clickOnHospitalTextBox");
	  //Thread.sleep(2000);
	  one.clickOnHosTextBox(driver).sendKeys(excelUtils.category2);  // Sending input to the category textbox to search for the hospitals
	  Thread.sleep(2000);
  	       
  }
  
  @Test(priority=7)
  public void selectHospital() throws InterruptedException

  {   logger =report.createTest("selectHospital");
	  new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(one.clickOnHospital(driver))); 
      one.clickOnHospital(driver).click();      // selecting the hospitals from the dropdown list
	 // Thread.sleep(2000);
  	       
  }
  @Test(priority=8)
	public void checkPageTwo()

	{
		logger =report.createTest("checkPageTwo");
		String actual=driver.getTitle();  // Hospital Name Page
		String expected=pageTwo;  
		System.out.println("expected Two "+expected);
		System.out.println("actual Two "+actual);
		Assert.assertEquals(expected,actual);
		 
	}
  @Test(priority=9)
  public void clickOnDiagnostics() throws InterruptedException

  {  logger=report.createTest("clickOnDiagnostics");
	 new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(two.clickOnDiagnostics(driver))); 
	 two.clickOnDiagnostics(driver).click();  // Clicking on the diagnostics element
	 Thread.sleep(3000);
	
  }
  @Test(priority=10)
 	public void checkPageThree()

 	{
 		logger =report.createTest("checkPageThree");
 		String actual=driver.getTitle();  // Hospital Name Page
 		String expected=pageThree;  
 		System.out.println("expected Three "+expected);
 		System.out.println("actual Three "+actual);
 		Assert.assertEquals(expected,actual);
 		 
 	}
  @Test(priority=11)
  public void gotoHomePage() throws InterruptedException

   {  logger =report.createTest("gotoHomePage");
  	 
  	   driver.navigate().to(url); 
   }
  @Test(priority=12)
  public void getParentWindow()

  {  logger=report.createTest("getParentWindow");
	 parent=driver.getWindowHandle();               // Getting parent window
	 System.out.println("Parent window "+parent );
		
   }
  @Test(priority=13)
  public void clickOnProviders()

  {   logger=report.createTest("clickOnProviders");
	  new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable( three.clickOnForProviders(driver))); 
	 three.clickOnForProviders(driver).click();  // Clicking on the for providers element
  	       
  }
  @Test(priority=14)
  public void clickOnCorporate()

  {  	logger=report.createTest("clickOnCorporate");
	    new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(three.clickOnCorporate(driver))); 
	     three.clickOnCorporate(driver).click();  //clicking on the corporate element
  	       
  }
  @Test(priority=15)
  public void childWindowSwitch()
  {
	  logger=report.createTest("childWindowSwitch");
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
  @Test(priority=16)
	public void checkPageFour()

	{
		logger =report.createTest("checkPageFour");
		String actual=driver.getTitle(); 
		String expected=pageFour;  
		System.out.println("expected Four "+expected);
		System.out.println("actual Four "+actual);
		Assert.assertEquals(expected,actual);
		 
	}
  	
      @AfterClass
      public void driverexit() 
	  {
		 
      logger =report.createTest("driverexit");
	  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	  driver.quit();     // closing the driver
	  report.flush();    // creating the report
	  }	
	  
	 

}
