package TestObject;

import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class objectTwo {
	WebDriver driver;
	  // Creating the Xpath of the WebElements
	@FindBy(xpath="//div[4]//a[1]//div[1]")
	WebElement diagnostics;
	
	@FindBy(xpath="//div[@class='u-margint--standard o-f-color--primary']")
	List<WebElement> Cities;
	 
	// Returning the xpath of the WebElements
	public WebElement clickOnDiagnostics(WebDriver driver)
	{
		return diagnostics;
	}
	
	public List<WebElement> clickOnCities(WebDriver driver)
	{
		return Cities;
	}
	public objectTwo(WebDriver driver){
	       this.driver=driver;

	       //Initialise Elements
	       PageFactory.initElements(driver, this);
	   }

}
