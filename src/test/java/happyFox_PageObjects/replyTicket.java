package happyFox_PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class replyTicket {
	
WebDriver ldriver;
	
	//constructor 
	public replyTicket(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);		
		
	}
	
	// web elements for reply ticket scenario 
	
	// web element for hovering to the ticket 
	String hoverNewticket = "//article[@data-test-id='ticket-box']";
	
	//web element for identifying all tickets 
	String chooseticket ="//span[@data-test-id='check-box']" ;
	
	//web element for clicking reply option on top of the screen
	@FindBy(xpath="//div[@data-test-id='bulk-actions_more-options_mass-reply']")
	@CacheLookup
	WebElement clickreply ;
	
	//web element for clicking the canned action option
	@FindBy(xpath="//span[@data-test-id='canned-action-trigger']")
	@CacheLookup
	WebElement clickcannedAction ;
	
	//web element for getting available canned reply options
	@FindBy(xpath="//li[@class='ember-power-select-option' and @data-option-index='0']")
	@CacheLookup
	WebElement choosecannedRreply ;
	
	//web element for clicking the apply option 
	@FindBy(xpath="//button[@data-test-id='hf-add-canned-action']")
	@CacheLookup
	WebElement apply ;
	
	//web element for clicking the reply option after choosing canned reply message
	@FindBy(xpath="//button[@data-test-id='mass-reply-button']")
	@CacheLookup
	WebElement sendreply ;
	
	//web element for  clicking the sort ticket option 
	@FindBy(xpath="//div[@data-test-id='sort-options_trigger']")
	@CacheLookup
	WebElement sortticket ;
	
	//web element for sorting the ticket
	@FindBy(xpath="//div[@class='hf-mini-pop-over_item hf-u-vertically-centered-container hf-is-current']")
	@CacheLookup
	WebElement selectsort ;
	

	//method to sort the ticket , helps to identify latest ticket 
	public void Sorttickets()
	{
		sortticket.click();
		ldriver.switchTo().activeElement();
		ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		selectsort.click();
	}
	
	//method to select the ticket 
	public void Selectticket() throws InterruptedException
	{     
		  Actions action = new Actions(ldriver);		  
		  List<WebElement> hover = ldriver.findElements(By.xpath(hoverNewticket)) ; // getting all tickets webelements 
		  WebDriverWait wait = new WebDriverWait(ldriver,5);
		  wait.until(ExpectedConditions.visibilityOfAllElements(hover));        
		  action.moveToElement(hover.get(0)).build().perform();                     // getting the latest ticket with index 0
		  ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		  //Thread.sleep(2000);
		  List<WebElement> choosetick = ldriver.findElements(By.xpath(chooseticket)) ;  // getting all tickets checkbox webelements 
		  action.moveToElement(choosetick.get(1)).click().perform();	 // getting the latest ticket check box with index 1 , since index 0 is all check box option
		  
	}
	
	//method to click reply option 
	public void clickreply()
	{
		ldriver.switchTo().activeElement();
		ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		clickreply.click();
		
	}
	
	//method to click canned action 
	public void clickcannedAction( )
	{
		ldriver.switchTo().activeElement();
		ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		clickcannedAction.click();
	}
	
	//method to  choose canned reply options and send reply mail 
	public void Choosecannedreply()
	{
		ldriver.switchTo().activeElement();
		int cannedreply = 0;
		
//		canned reply type
//		0	Reply to customer Query
//		1	thank you note
//		2	accept ticket
//		3	discount on pricing 
//		4	bug reporting
//		5	due date info
//		6	service request
//		7	urgent request 
//		8	refund request
//		9	enhancement request

		WebElement reply = ldriver.findElement(By.xpath("//li[@class='ember-power-select-option' and @data-option-index='"+cannedreply+"']")); //index is passed to set canned reply types 
		reply.click();
		ldriver.switchTo().activeElement();
		ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		apply.click();
		sendreply.click();
	}
	

}
