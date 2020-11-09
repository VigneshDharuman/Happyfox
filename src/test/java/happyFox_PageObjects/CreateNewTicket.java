package happyFox_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewTicket {
	
	WebDriver ldriver;
	
	//constructor 
	public CreateNewTicket(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);		
		
	}
	
	// web elements for creating the ticket  
	
	// web element for input subject 
	@FindBy(xpath="//input[@class='hf-form-field_value hf-subject-field-input']")
	@CacheLookup
	WebElement enterSubject;
	
	// web element for input message 
	@FindBy(xpath="//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	@CacheLookup
	WebElement enterMessage;	
	
	// web element for input attachment 
	@FindBy(xpath="//input[@id='attach-file-input']")
	@CacheLookup
	WebElement attachScreenshot;
	
	// web element for input name 
	@FindBy(xpath="//input[@id='id_name']")
	@CacheLookup
	WebElement enterName;
	
	// web element for input email 
	@FindBy(xpath="//input[@id='id_email']")
	@CacheLookup
	WebElement enterEmail;
	
	// web element for input phone 
	@FindBy(xpath="//input[@id='id_phone']")
	@CacheLookup
	WebElement enterPhone;
	
	// web element for clicking create ticket 
	@FindBy(xpath="//button[@class='hf-form-field_btn hf-mod-form-field-btn-small']")
	@CacheLookup
	WebElement clickSubmit;
	
	//  method to enter subject 
	public void enterSubject(String subject)
	{
		enterSubject.sendKeys(subject);
		
	}
    //  method to enter message
	public void enterMessage(String message)
	{
		enterMessage.sendKeys(message);
		
	}
    //  method to attach file 
	public void attachScreenshot(String filelocation)
	{
		String path=System.getProperty("user.dir")+filelocation ;
		attachScreenshot.sendKeys(path);
		
	}
     //  method to enter name 
	public void enterName(String name)
	{
		enterName.sendKeys(name);
		
	}
    //  method to enter email
	public void enterEmail(String email)
	{
		enterEmail.sendKeys(email);
		
	}
   //  method to enter number 
	public void enterPhone(String number)
	{
		enterPhone.sendKeys(number);
		
	}
     //  method to click create ticket 
	public void clickSubmit()
	{
		clickSubmit.click();
		
	}


}
