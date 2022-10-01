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
import Pageobjects.NewaccountPage;

public class NewAccountCreationPageTest extends TestBase{

	
	Loginpage login;
	HomePage homepage ;
	NewaccountPage newaccount;
	
	 public NewAccountCreationPageTest()
	{
		super();
	}
	
	 @BeforeMethod
	 public void setup()
	 {
		 initialsation();
		 login = new Loginpage();
		 homepage =login.login(prop.getProperty("username"),prop.getProperty("password"));
		 homepage.clicknewaccount();
		 newaccount= new NewaccountPage();		 
	 }
	 
	 
	 @Test(priority = 1)
	 public void verifyNewAccountTittleTest() throws IOException
	 {
		 boolean res1 = driver.getPageSource().contains("Apply For A New Account");
		 if(res1== true)
		 {
			 Assert.assertTrue(true);
			 logger.info("USer Landed in New Account Creation page");
		 }
		 else {
			 
			 Assert.assertTrue(false);
			 logger.warn("Test case failed");
		 }
	 }
	 
	 @Test(priority = 2)
	 public void ValidateNewAccountCreationTest() throws InterruptedException, IOException
	 {
		 
		 newaccount.setname(prop.getProperty("accountname"));
		 logger.info("New USer Name provided");
		 newaccount.setAccountType(prop.getProperty("accounttype"));
		 logger.info("Accoount type provided");
		 newaccount.clickapplybtn();
		 Thread.sleep(2000);
		 logger.info("submit button clicked");
		 newaccount.clickviewbtn();
		 Thread.sleep(3000);
		 
		 boolean res =driver.getPageSource().contains(prop.getProperty("accountname"));
		 if(res== true)
		 {
			 Assert.assertTrue(true);
			 logger.info("New Account was created");
		 }
		 else {
			 
			 Assert.assertTrue(false);
			 logger.warn("Test case failed");
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
