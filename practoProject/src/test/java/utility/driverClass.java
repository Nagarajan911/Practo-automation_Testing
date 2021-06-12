package utility;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;


public class driverClass{    //practo

public static WebDriver driver;

public static String exePath;
public static String url;

//public static String url = "https://www.practo.com/";
//public static String url=excelUtils.url;
//public static String url=xmlRead.category6;
public static String browsertype;



public static WebDriver driverInstantiate(String browser ) throws IOException {
	browsertype=browser;
	Properties prop=new Properties();
	FileInputStream ip=new FileInputStream("E:\\Java Workspace\\practoProject\\src\\test\\resources\\config.properties");
     prop.load(ip);
    url= prop.getProperty("url");
   // pageOne=prop.getProperty("pageOne");
	if(browsertype.equalsIgnoreCase("chrome")) {
    
//exePath = "/chromedriver_win32/chromedriver.exe";
//exePath =excelUtils.chrome;
exePath=prop.getProperty("chrome");
System.setProperty("webdriver.chrome.driver", exePath);

driver = new ChromeDriver();    // Creating the Chrome Driver

}

else if(browsertype.equalsIgnoreCase("firefox")) {

//exePath = "/geckodriver-v0.26.0-win64/geckodriver.exe";
//exePath =excelUtils.firefox;
exePath=prop.getProperty("firefox");

System.setProperty("webdriver.gecko.driver",exePath);

driver = new FirefoxDriver();    // Creating the Gecko Driver

}


driver.manage().window().maximize();

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.get(url);

driver.manage().deleteAllCookies();

return driver;

}

public static void driverClose()

{

driver.quit();     // Closing the driver

}

}