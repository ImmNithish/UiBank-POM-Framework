package Tescases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Pageobjects.RegisterPage;

public class RegisterationPageTest extends TestBase {
	
	 RegisterPage Register;
	
	public RegisterationPageTest()
	{
		super();	
	}
	
	@BeforeClass
	public void setup()
	{
		initialsation();
		Register= new RegisterPage();
		Register.registerbtun();
		
	}
	
	
	
	@DataProvider(name="excel")
	public Object[][] registerdetails() throws Exception
	{
		Object[][] Registerdetails = UtilitiesTest.DataProvider.getvalue("UIBank_DataSheet", "Registeration");
		return Registerdetails;
	}
	
	@Test (dataProvider="excel")
	public void ValidateRegisterPageTest(String fn,String tl,String md,String ls,String gn,String em,String dob,String ms,String dep ) throws IOException, InterruptedException
	{
		
		Register.Setfirstname(fn);
		logger.info("First  name provided");
		Register.SetTittle(tl);
		logger.info("Mittle provided");
		Register.SetmiddleName(md);
		logger.info("middle  name provided");
		Register.Setlastname(ls);
		logger.info("Last name provided");
		Register.Setgender(gn);
		logger.info("Gender provided");
		Register.Setempolymentdetail(em);
		logger.info("Employement details provided");
		Register.SetAge(dob);
		logger.info("Date OF Birth  provided");
		Register.Setmaritalstatus(ms);
		logger.info("Marital provided");
		Register.Setdepen(dep);
		logger.info("Number of Dependent provided");
		String randomUsername = RandomUsername();
		Register.Setusername(randomUsername);
		logger.info("User name provided");
		String Remail =RandomMail()+"@gamil.com";
		Register.Setemail(Remail);
		logger.info("Mail id provided");
		String randomPassword = RandomPassword();
		Register.SetPass(randomPassword);
		logger.info("Password provided");
		Register.clickresgistr();
		logger.info("Register submit button clicked");
		Thread.sleep(5000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated( driver.getPageSource().contains( "Welcome To The UiBank Family!" ))));
		boolean result = driver.getPageSource().contains( "Welcome To The UiBank Family!" );

		if(result== true)
		{
			Assert.assertTrue(true);

			logger.info("New User was Registered");
		}
		else
		{
			
			Assert.assertTrue(false);
			logger.info("Test case Failed");
		}

	}	
	public String RandomMail()
	
	{
		String randomMail = RandomStringUtils.randomAlphabetic(5);
		 return randomMail;
	}
	
	public String RandomPassword()
	{
		String randomPassword = RandomStringUtils.randomAlphanumeric(8);
		return (randomPassword);
		
	}
	public String RandomUsername()
	{
		String randomName = RandomStringUtils.randomAlphabetic(7);
		return randomName;
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
	public void  tearDown()
	{
		driver.quit();
	}

	
	
	
	
}
