package happyFox_TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import happyFox_utilities.XLUtils;


public class BaseClass {
	
	//global variables
	public WebDriver driver ;
	public static Logger logger;
	public String  loginURL  = "https://interview.supporthive.com/staff/login" ;
	public String  NewticketURL  = "https://interview.supporthive.com/new" ;
	
	
	//before class created to initiate chrome browser
	@BeforeClass
	public void setup() throws InterruptedException
	{   				
		logger = Logger.getLogger("Happyfox");		          //logger method
		PropertyConfigurator.configure("Log4j.properties");		 //properties for logger method
		
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();	
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					
	}	
	
	//after class to close the browser
	@AfterClass
	public void closebrowser()
	{
		driver.quit();
	}
	
	//Capture screenshot method is created in base class and called with (driver ,file_name)
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourse =  ts.getScreenshotAs(OutputType.FILE);
		File target =new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(sourse, target);
		System.out.println("Screenshot taken");		
		
	}
	//data's for creating status 
	@DataProvider(name = "Statusdata")
	String [][] getstatusData() throws IOException{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\happyFox_utilities\\testdata.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");// path and sheet name is passed 
		int colcount=XLUtils.getCellCount(path,"Sheet1",1); // path , sheet name and starting row is passed 
		
		String statusData[][] =new  String [rownum][colcount];
		
		 // loops starts with row= 1 , coloum = 0 and receive data in 1,0 and  1,1 
		for(int i= 1;i<=rownum;i++)
		{
			for (int j = 0 ; j<colcount;j++)
			{
				statusData[i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j); //1 0
				
			}
		}

		return statusData;
	}
	// login credential details 
	@DataProvider(name = "onlylogindata")
	String [][] getData2() throws IOException{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\happyFox_utilities\\testdata.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet4"); // path and sheet name is passed 
		int colcount=XLUtils.getCellCount(path,"Sheet4", 1); // path , sheet name and starting row is passed 
		
		String logindata[][] =new  String [rownum][colcount];
		
		 // loops starts with row= 1 , coloum = 0 and receive data in (1,0)  (1,1) ( 1,2) (1,3) (1,4) (1,5) ..
		for(int i= 1;i<=rownum;i++)
		{
			for (int j = 0 ; j<colcount;j++)
			{
				logindata[i-1][j]= XLUtils.getCellData(path, "Sheet4", i, j); 
				
			}
		}

		return logindata;
     }
	
	//new tickets data's
	@DataProvider(name = "newticketdata")
	String [][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\happyFox_utilities\\testdata.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet2"); // path and sheet name is passed 
		int colcount=XLUtils.getCellCount(path,"Sheet2", 1); // path , sheet name and starting row is passed 
		
		String Createticket[][] =new  String [rownum][colcount];
		
		 // loops starts with row= 1 , coloum = 0 and receive data in 1,0 and 1,1 
		for(int i= 1;i<=rownum;i++)
		{
			for (int j = 0 ; j<colcount;j++)
			{
				Createticket[i-1][j]= XLUtils.getCellData(path, "Sheet2", i, j); //1 0
				
			}
		}

		return Createticket;
	}
		
}
