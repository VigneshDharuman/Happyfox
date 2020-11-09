package happyFox_TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import happyFox_PageObjects.CreateNewTicket;
import happyFox_PageObjects.LoginPage;
import happyFox_PageObjects.replyTicket;
import happyFox_utilities.Assertion_helper;


public class Test_Scenario_2 extends BaseClass{
	
	//test run for creating new ticket  and data's are received from data provider and passed 
	@Test(dataProvider = "newticketdata")
	public void a_CreateNewTicket(String subject,String message ,String filelocation, String name , String email ,String number ) throws InterruptedException, IOException {		
			
		
		try {
		logger.info("getting the New  ticketURL");
		driver.get(NewticketURL);		                                                  // getting the base create ticket url 
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Assertion_helper ASSERT = new Assertion_helper();     
        String ActualTitle = driver.getTitle();
		ASSERT.verifyTitle(ActualTitle,"New Ticket  - Tenmiles - powered by HappyFox","newticketTitle");            //assertion to verify  title
		
		CreateNewTicket newticket =new CreateNewTicket(driver);                          //object is created 
		logger.info("----Entering the subject----");
		newticket.enterSubject(subject);	                                               // methods are called  with  object reference
		logger.info("----Entering the message----");
		newticket.enterMessage(message);		
		logger.info("----attching the screenshot----");
		newticket.attachScreenshot(filelocation);				
		logger.info("----Entering the name ----");
		newticket.enterName(name);		
		logger.info("----Entering the email----");
		newticket.enterEmail(email);		
		logger.info("----Entering the phone----");
		newticket.enterPhone(number);		
		logger.info("----submitting the new ticket----");
		newticket.clickSubmit();
		
		
		}
		catch(Exception e)                                                     //exception captured , logged and screenshot captured
		{
		    logger.error("Unexpected error", e);
		}
		
		
	}	
	
	// test run for login and data's are received from data provider and passed as  user and password	
	@Test(dataProvider = "onlylogindata" ,dataProviderClass = BaseClass.class)
	public void b_login(String user,String password ) throws InterruptedException, IOException {
		
		
		try {
			logger.info("----getting the URL----");
			driver.get(loginURL);		                                                // getting the base login url 
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			LoginPage lp =new LoginPage(driver);                                     //object is created for loginpage class  		
			
			lp.LoginUser(user ,password);                                               // method are called  with  object
			
			Assertion_helper ASSERT = new Assertion_helper();     
            String ActualTitle = driver.getTitle();
			ASSERT.verifyTitle(ActualTitle,"Login - HappyFox","logintitle");            //assertion to verify  title
			}
			catch(Exception e)                                                                  //exception captured , logged and screenshot captured
			{
			    logger.error("Unexpected error", e);
			    captureScreen(driver,"Error_at_login");
			}
	}
	
	//test run for selecting the ticket
	@Test
	public void c_SelectTicket_responding() throws InterruptedException, IOException {	
		
		try {
					
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);			
			replyTicket replyticket =new replyTicket(driver);			            //object is created 
			logger.info("----sorting the tickets ----"); 
			replyticket.Sorttickets();		                                         // methods are called  with  object reference
			logger.info("----selecting the ticket ----");
			replyticket.Selectticket();	
			logger.info("----choosing reply option----");
			replyticket.clickreply();
			Thread.sleep(1000);
			logger.info("----clicking  canned reply----");
			replyticket.clickcannedAction();
			Thread.sleep(1000);		
			logger.info("----replying with cannedreply ----");

			Assertion_helper ASSERT = new Assertion_helper();     
            String ActualTitle = driver.getTitle();
			ASSERT.verifyTitle(ActualTitle,"Mass Reply - HappyFox","replytitle");            //assertion to verify  title
			
			replyticket.Choosecannedreply();
			Thread.sleep(1000);
			}
			catch(Exception e)                                                 //exception captured , logged and screenshot captured
			{
			    logger.error("Unexpected error", e);
			    captureScreen(driver,"Error_at_selecting_&_responding");
			}		
	
	}	
	
	
}
