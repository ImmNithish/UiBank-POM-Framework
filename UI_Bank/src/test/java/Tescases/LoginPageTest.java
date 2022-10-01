package Tescases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.TestBase;
import Pageobjects.HomePage;
import Pageobjects.Loginpage;

public class LoginPageTest extends TestBase {

	Loginpage login ;
	HomePage homepage ;

	public LoginPageTest()
	{
		super();

	}


	@BeforeClass
	public void setup()
	{
		initialsation();
		logger.info("Browser Opened");
		login = new Loginpage();
	}


	@Test(priority = 1)
	public  void loginpagetittleTest() throws IOException
	{
		logger.info("Verifying loginpage Tittle test");
		String Tittle = login.validateTittle();
		if(Tittle.equals("UiBank")) 
		{
			Assert.assertTrue(true);


		}
		else{
			logger.warn("TestCase Failed");
			
			Assert.assertTrue(false);

		}



	}

	@Test(priority = 2)
	public void logotest() throws InterruptedException, IOException

	{	

		logger.info("verifying login logo test");
		//boolean flag  =login.validateLogo();

		if(login.validateLogo()==true)
		{

			Assert.assertTrue(true);
			logger.info("Verified Logo" );
		}
		else {

			
			Assert.assertTrue(false);
			logger.warn("Testcase failed");
		}

	}

	@Test(priority = 3)
	public  void LogiTest()

	{

		homepage = login.login(prop.getProperty("username"),prop.getProperty("password"));
		logger.info("username and password entered");
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{ 
			takescreenshot(driver, result.getName());
		}
	}
	
	
	
	@AfterClass
	public void teardown()
	{
		logger.info("Browser closed");
		driver.quit();

	}



}
