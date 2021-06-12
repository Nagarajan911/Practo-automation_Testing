package TestObject;
import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class objectOne {
	WebDriver driver;

	       // Creating the Xpath of the WebElements
	@FindBy(xpath="//div[@class='c-omni__wrapper u-clearfix c-omni__wrapper--locality']//input[@class='c-omni-searchbox c-omni-searchbox--small']")
	WebElement location;
	
	@FindBy(xpath="//div[@class='c-omni-suggestion-list']//div//div//descendant::span[@class='c-omni-suggestion-item__content']")
    List<WebElement> placeList;
	
	@FindBy(xpath="//div[@class='c-omni__wrapper u-clearfix c-omni__wrapper--keyword']//input[@class='c-omni-searchbox c-omni-searchbox--small']")
	WebElement hosTextBox;
	
	@FindBy(xpath="//body/div[@id='root']/div/div/div[@class='content']/div[@class='c-omni-wrapper u-d__inline-block']/div[@id='c-omni-container']/div[@class='c-omni u-clearfix']/div[@class='c-omni__wrapper u-clearfix c-omni__wrapper--keyword']/div[@class='c-omni-suggestion-list']/div[1]/div[1]")
	WebElement hospital;
	
	@FindBy(xpath="//body//div[@id='container']//div//div[3]//label[1]//div[1]")
	WebElement open;
	
	@FindBy(xpath="//i[@class='u-transition--transform u-d-inlineblock icon-ic_dropdown']")
	WebElement arrow1;
	
	@FindBy(xpath="//div[@class='c-filter__bottom expanded']//label[1]//div[1]")
	WebElement parking;
	
	// Returning the xpath of the WebElements
	public  WebElement clickOnLocations(WebDriver driver)   
	{
		return location;                
	}
	
	public  List<WebElement> clickOnPlaceList(WebDriver driver)
	{
		return placeList;
	}
	
	public  WebElement clickOnHosTextBox(WebDriver driver)
	{
		return hosTextBox;
	}
	
	public WebElement clickOnHospital(WebDriver driver)
	{
		return hospital;
	}
	
	public  WebElement clickOnOpen(WebDriver driver)
	{
		return open;
	}
	
	public  WebElement clickOnArrow1(WebDriver driver)
	{
		return arrow1;
	}
	
	public WebElement clickOnParking(WebDriver driver)
	{
		return parking;
	}
	public objectOne(WebDriver driver){
	       this.driver=driver;

	       //Initialise Elements
	       PageFactory.initElements(driver, this);  
	   }

}
