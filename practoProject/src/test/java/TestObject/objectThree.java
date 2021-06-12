package TestObject;
//import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class objectThree {
	WebDriver driver;
	// Creating the Xpath of the WebElements
	@FindBy(xpath="//div[@class='providers-marketing nav-items nav-items--additional-link hover-dark u-d-trigger dropdown-toggle']//span[@class='downarrow icon-ic_down_cheveron']")
	WebElement forProviders;
	
	@FindBy(xpath="//div[@class='nav-right text-right']//div[4]//a[1]")
	WebElement  corporate;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement name ; 
	
	@FindBy(xpath="//input[@id='organization_name']")
	WebElement organization ; 
	
	@FindBy(xpath="//input[@id='official_email_id']")
	WebElement mail ; 
	
	@FindBy(xpath="//input[@id='official_phone_no']")
	WebElement contactNo ; 
	
	@FindBy(xpath="//button[@id='button-style']")
	WebElement submit ; 
	
	// Returning the xpath of the WebElements
	public WebElement clickOnForProviders(WebDriver driver)
	{
		return forProviders;
	}
	public WebElement clickOnCorporate(WebDriver driver)
	{
		return corporate;
	}
	public WebElement clickOnName(WebDriver driver)
	{
		return name;
	}
	public WebElement clickOnOrganization(WebDriver driver)
	{
		return organization;
	}
	public WebElement clickOnMail(WebDriver driver)
	{
		return mail;
	}
	public WebElement clickOnContactNo(WebDriver driver)
	{
		return contactNo;
	}
	public WebElement clickOnSubmit(WebDriver driver)
	{
		return submit;
	}
	public objectThree(WebDriver driver){
	       this.driver=driver;

	       //Initialise Elements
	       PageFactory.initElements(driver, this);
	   }
}
