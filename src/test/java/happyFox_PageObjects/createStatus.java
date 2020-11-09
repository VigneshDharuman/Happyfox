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


public class createStatus {
	
	
	WebDriver ldriver;
	
	//constructor 
	public createStatus(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);		
		
	}
	 
	// web elements for creating status 
	
	// web element for hovering to tickets menu 
	@FindBy(id="ember26")
	@CacheLookup
	WebElement hoverTickets;
	
	//web element for selecting status from tickets menu 
	@FindBy(xpath="//a[@href = '/staff/manage/statuses']")
	@CacheLookup
	WebElement clickStatus;		
	
	//web element for clicking create status 
	@FindBy(xpath="//button[@class='hf-mod-create']")
	@CacheLookup
	WebElement createNewStatus; 
	
	//web element for input ticket name 
	@FindBy(xpath="//input[@data-test-id='form-field-name']")
	@CacheLookup
	WebElement statusname;
	
    //web element for input colour code
	@FindBy(xpath="//div[@class='sp-preview-inner']")
	@CacheLookup
	WebElement choosecolor;
	
     //  web element for entering  colour code
	@FindBy(xpath="//input[@class='sp-input']")
	@CacheLookup
	WebElement entercolor;
	
     //  web element for clicking the add status
	@FindBy(xpath="//button[@data-test-id='add-status']")
	@CacheLookup
	WebElement ClickAddStatus ;	
	
	// web element to get all the available status
	String hoverdefault = "//td[@class='lt-cell align-center hf-mod-no-padding ember-view']";	
    //  web element for make default button 
	String clickmakedefault = "//a[@class= 'hf-make-default']" ;	
	
	
	//method to hover ticket menu and selecting status 
	public void HoverTickets_clickstatus()
	{    
		 Actions action = new Actions(ldriver);
		 action.moveToElement(hoverTickets).build().perform();
		 clickStatus.click();	     
		
	}
	
	//method to click create new status + button 
	public void CreateNewStatus()
	{
		createNewStatus.click();
		
	}
	
	//method to enter the status name 
	public void statusname(String statusName)
	{
		//String generatedstring=RandomStringUtils.randomAlphabetic(2);
		ldriver.switchTo().activeElement();
		ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		statusname.sendKeys(statusName);
		 
		
	}
	
	//method to enter the status color code 
	public void Colouroption(String statuscolor)
	{
		choosecolor.click();
		entercolor.clear();
		entercolor.sendKeys(statuscolor);
		
	}
	
	//method to click add status 
	public void ClickAddStatus()
	{
		ClickAddStatus.click();
		
	}
	//method to hover created status and make as default
	public void Makestatusdefault() throws InterruptedException
	{
		  Actions action = new Actions(ldriver);
		  List<WebElement> a=ldriver.findElements(By.xpath(hoverdefault)) ;  // getting all status webelements 
		  int xpathCount1 = a.size();
		  action.moveToElement(a.get(xpathCount1-1)).build().perform();        // getting the last created status  with index (len-1)
		  ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  List<WebElement> b=ldriver.findElements(By.xpath(clickmakedefault)) ;  // getting all status make default button webelements 
		  int xpathCount2 = b.size();                                               // getting the last created status make default with index (len-1)
		  b.get(xpathCount2-1).click();
	}
	
}
