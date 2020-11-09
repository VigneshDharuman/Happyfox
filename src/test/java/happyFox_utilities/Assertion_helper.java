package happyFox_utilities;

import java.io.IOException;
import org.testng.Assert;
import happyFox_TestCases.BaseClass;

public class Assertion_helper extends BaseClass{
	
	
	public Assertion_helper()
	{
				
		
	}
	public void verifyTitle(String ActualTitle ,String ExpectedTitle ,String assertname ) throws IOException{
		
		
		System.out.println("Actual Title :"+ActualTitle);
		System.out.println("Expected Title :"+ExpectedTitle);         
		//Soft assert applied to verify title
		try {	
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		logger.info("----assert passed----");
		}
		catch(Exception e)                                                    //exception captured , logged and screenshot captured
		{
		    logger.error("assertion error", e);
		    captureScreen(driver,"asserterror_"+assertname);
		}
		}		

}
