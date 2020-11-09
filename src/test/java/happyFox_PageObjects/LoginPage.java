package happyFox_PageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	
WebDriver ldriver;
	
    //constructor 
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);		
		
	}
	
	// web elements for login and logout 
	
	// web element for input user name 
	@FindBy(id="id_username")
	@CacheLookup
	WebElement enterUsername;
	
	// web element for input password 
	@FindBy(id="id_password")
	@CacheLookup
	 WebElement enterPassword;	
	
	// web element for clicking the login button 
	@FindBy(xpath="//input[@class='smooth-button']")
	@CacheLookup
	WebElement clickLogin;
	
	// web element for clicking staff menu option on top right corner 	
	@FindBy(xpath="//div[@data-test-id='staff-menu']")
	@CacheLookup
	WebElement staffmenu ;
	
	// web element for clicking the logout button 
	@FindBy(xpath="//li[@data-test-id='staff-menu_logout']")
	@CacheLookup
	WebElement logout ;
	
	//method for login 
	public void LoginUser(String user ,String password) throws IOException
	{
		
		ldriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		enterUsername.sendKeys(user);
		enterPassword.sendKeys(password);
		
		clickLogin.click();
		
	}
	//method for logout 
	public void logoutuser()
	{    
		ldriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		staffmenu.click();
		ldriver.switchTo().activeElement();
		logout.click();
		
	}
	

}
