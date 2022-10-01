package Tescases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Pageobjects.Loginpage;

public class LoginPageDDTest2 extends TestBase{

	Loginpage login;

	public LoginPageDDTest2 ()
	{
		super();

	}

	@BeforeClass
	public void setup()
	{
		initialsation();
		login = new Loginpage();
	}


	@DataProvider(name="excel")

	public Object[][] logindata() throws Exception
	{
		Object[][] loginvalue = UtilitiesTest.DataProvider.getvalue("UIBank_DataSheet", "LoginCredential"); 
		return loginvalue;
	}



	@Test(dataProvider = "excel")
	public void ValidateloginCredtential(String userName,String Password) throws IOException, InterruptedException
	{
		login.setusername(userName);
		logger.info("user name provided");
		login.setpassword(Password);
		logger.info("password provided");
		login.submit();
		Thread.sleep(3000);
		boolean res= driver.getPageSource().contains("Welcome!");

		if( res==true)
		{	
			logger.info("Logged In");
			Assert.assertTrue(true);
			login.clicklogout();

		}

		else
		{

			logger.warn("Invalid credential entered");
			logger.info("login failed");
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
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();

	}
}
