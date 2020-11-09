package happyFox_PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteStatus {	
	
	
    WebDriver ldriver;
	
    //constructor 
	public DeleteStatus(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);		
		
	}
	
	// web elements for deleting the status scenario
	
	// web element for Clicking the delete option in status 	
	@FindBy(xpath="//a[@data-test-id='status-delete-trigger']")
	@CacheLookup
	WebElement clickdelete;
	
	// web element for clicking alternate default drop down
	@FindBy(xpath="//span[@class='ember-power-select-placeholder' and contains(text(),'Choose Status')]")
	@CacheLookup
	WebElement clickdropdown;	
	
	// web element for selecting  alternate default from  drop down
	@FindBy(xpath="//li[@data-option-index='0']")
	@CacheLookup
	WebElement selectdroptext;
	
	// web element for clicking the delete button 
	@FindBy(xpath="//button[@data-test-id='delete-dependants-primary-action']")
	@CacheLookup
	WebElement pressdelete ;
	
	// web element  to get all the available status
	String hoverstatus = "//td[@class='lt-cell align-left ember-view']";
	
	
	//method to select the status 
	public void selectstatus()
	{    
		  Actions action = new Actions(ldriver);
		  List<WebElement> a=ldriver.findElements(By.xpath(hoverstatus)) ; 	     
		  int xpathCount = a.size();
		  action.moveToElement(a.get(xpathCount-1)).click().perform();
		  
	}
	//method to get delete options
	public void clickdelete()
	{
		clickdelete.click();
		
	}
	//method to click the alternate default drop down
	public void clickdropdown()
	{
		clickdropdown.click();
		
	}
	//method to select  alternate default from  drop down
	public void selectdroptext()
	{
		selectdroptext.click();
		
	}
	//method to clicking the delete button 
	public void pressdelete()
	{
		pressdelete.click();
		
	}


}
