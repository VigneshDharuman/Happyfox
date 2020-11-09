package happyFox_TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import happyFox_PageObjects.DeleteStatus;
import happyFox_PageObjects.LoginPage;
import happyFox_PageObjects.createStatus;
import happyFox_utilities.Assertion_helper;


public class Test_Scenario_3 extends BaseClass{
	
	// test run for login and data's are received from data provider and passed as  user and password
	@Test(dataProvider = "onlylogindata" ,dataProviderClass = BaseClass.class)
	public void a_login(String user,String password ) throws InterruptedException, IOException {		
		
		try {
			logger.info("----getting the URL----");
			driver.get(loginURL);		                                            // getting the base login url 
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			LoginPage lp =new LoginPage(driver);                                      //object is created for loginpage class   
			
			lp.LoginUser(user ,password);                                               // method are called  with  object
			
			Assertion_helper ASSERT = new Assertion_helper();     
            String ActualTitle = driver.getTitle();
			ASSERT.verifyTitle(ActualTitle,"Login - HappyFox","logintitle");            //assertion to verify  title
						
			}
			catch(Exception e)                                                              //exception captured , logged and screenshot captured
			{
			    logger.error("Unexpected error", e);
			    captureScreen(driver,"Error_at_login");
			}
	}
	
	//test run for deleting status
	@Test
	public void b_deleteStatus() throws InterruptedException, IOException {
		
		try {	
		logger.info("----Hover to tickets and selecting status ----");
		createStatus CreateStatus = new createStatus(driver);                     //object is created 
		CreateStatus.HoverTickets_clickstatus();		                            // methods are called  with  object reference
		Thread.sleep(3000);
		
		Assertion_helper ASSERT = new Assertion_helper();     
        String ActualTitle = driver.getTitle();
		ASSERT.verifyTitle(ActualTitle,"Statuses - HappyFox","DeleteStatusTitle");     //assertion to verify  title
		
		logger.info("----Hover to status and selecting status ----");      
		DeleteStatus deleteStatus = new DeleteStatus(driver);
		deleteStatus.selectstatus();		
		deleteStatus.clickdelete();
		deleteStatus.clickdropdown();		
		deleteStatus.selectdroptext();		
		deleteStatus.pressdelete();
		Thread.sleep(5000);
		}
		catch(Exception e)                                                            //exception captured , logged and screenshot captured
		{
		    logger.error("Unexpected error", e);
		    captureScreen(driver,"Error_at_delete_status");
		}
	}
	@Test
	public void c_logout() throws InterruptedException, IOException {	
		
		try {			
		logger.info("----logging out----");				
		LoginPage lp =new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		lp.logoutuser();		
		}
		catch(Exception e)
		{
		    logger.error("Unexpected error", e);
		    captureScreen(driver,"Error_at_logout");
		}
	}

}
