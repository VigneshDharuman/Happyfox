package happyFox_TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import happyFox_PageObjects.LoginPage;
import happyFox_PageObjects.createStatus;
import happyFox_utilities.Assertion_helper;


public class Test_Scenario_1 extends BaseClass{
  
	// test run for login and data's are received from data provider and passed as  user and password
	@Test(dataProvider = "onlylogindata" ,dataProviderClass = BaseClass.class)
	public void a_login(String user,String password) throws InterruptedException, IOException {
		
		
		try {
			logger.info("----getting the URL----");
			driver.get(loginURL);		                                        // getting the base login url 
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			LoginPage lp =new LoginPage(driver);                                //object is created for loginpage class    
			
			lp.LoginUser(user ,password);                                               // method are called  with  object
			
			Assertion_helper ASSERT = new Assertion_helper();     
            String ActualTitle = driver.getTitle();
			ASSERT.verifyTitle(ActualTitle,"Login - HappyFox","logintitle");            //assertion to verify  title
			
			}
			catch(Exception e)                                                    //exception captured , logged and screenshot captured
			{
			    logger.error("Unexpected error", e);
			    captureScreen(driver,"Error_at_login");
			}
	}

	//test run for creating the status and data's are received from data provider and passed as  statusName and statusName
	@Test(dataProvider = "Statusdata",dataProviderClass = BaseClass.class)
	public void b_creatingStatus( String statusName, String statuscolor) throws InterruptedException, IOException {
		
		try {
			logger.info("----Hover to tickets and selecting status ----");
			createStatus CreateStatus = new createStatus(driver);                //object is created for create status class
			CreateStatus.HoverTickets_clickstatus();                           //all methods are called  with create status class object
			Thread.sleep(2000);
			
			Assertion_helper ASSERT = new Assertion_helper();     
            String ActualTitle = driver.getTitle();
			ASSERT.verifyTitle(ActualTitle,"Statuses - HappyFox","CreateStatustitle");            //assertion to verify  title
			
			logger.info("----Creating new status----");
			CreateStatus.CreateNewStatus();
			Thread.sleep(2000);
			logger.info("----entering status name----");
			CreateStatus.statusname(statusName);		
			logger.info("----choosing the status colour----");
			CreateStatus.Colouroption(statuscolor);			
			logger.info("----adding he status ----");
			CreateStatus.ClickAddStatus();
			Thread.sleep(2000);
			logger.info("----making status default----");
			CreateStatus.Makestatusdefault();
			Thread.sleep(2000);
			}
			catch(Exception e)                                             //exception captured , logged and screenshot captured
			{
			    logger.error("Unexpected error", e);
			    captureScreen(driver,"Error_at_creating_status");
			}		
	
	}
	
}
