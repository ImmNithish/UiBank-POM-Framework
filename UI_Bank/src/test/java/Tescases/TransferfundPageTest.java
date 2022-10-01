package Tescases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pageobjects.HomePage;
import Pageobjects.Loginpage;
import Pageobjects.TransferfundPage;

	public class TransferfundPageTest extends TestBase{
	
	public Loginpage login;	
	HomePage homepage ;
	TransferfundPage transferfundpage;
		
	
	public TransferfundPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialsation();
		login = new Loginpage();
		homepage =login.login(prop.getProperty("username"),prop.getProperty("password"));
		logger.info("User logged in");
		transferfundpage= new TransferfundPage();
		homepage.clicktransferfund();
		logger.info("User landed to Transfer fund page");
	}
	
	@Test(priority = 1)
	public void verifyfromboxTest()
	{	logger.info("From option provided");
		transferfundpage.frombox();
		
	}
	
	@Test(priority = 2)
	public void verifyToboxTest() 
	{
		transferfundpage.tobox();
		logger.info("TO option provided");
	}
	
	@Test(priority = 3)
	public void VerifyConfrimTransferTest() throws InterruptedException, IOException
	
	{	
		
		transferfundpage.frombox();
		logger.info("From option provided");
		transferfundpage.tobox();
		logger.info("TO option provided");
		transferfundpage.amountbox();
		logger.info("Amount entered");
		 transferfundpage.TransferConformation();
		logger.info(" Conformation Required");
		Thread.sleep(3000);
		boolean re=driver.getPageSource().contains("transfer was");
		if(re== true)
		{
			Assert.assertTrue(true);
			logger.info("Amount Transfered");
		}
		else{
			logger.warn("Test Case failed");
			Assert.assertTrue(false);
			
		}
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{ 
			takescreenshot(driver, result.getName());
		}
		driver.quit();
	}
	
}
