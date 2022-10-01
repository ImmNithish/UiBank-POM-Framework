package Tescases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Pageobjects.ApplyloanPage;
import Pageobjects.HomePage;
import Pageobjects.Loginpage;

public class ApplyLoanPageWay1Test extends TestBase {

	public Loginpage login;	
	HomePage homepage ;
	ApplyloanPage applyloanform;
	
	public ApplyLoanPageWay1Test()
	{
		super();
	}
	
	@BeforeMethod
	public void  setup()
	{
		initialsation();
		login = new Loginpage();
		homepage =login.login(prop.getProperty("username"),prop.getProperty("password"));
		applyloanform = homepage.clickapplyloan();
	
	}
	@DataProvider(name="excel")
	public 	Object[][] UIBankTestdata() throws Exception
	{
	
		Object[][] data = UtilitiesTest.DataProvider.getvalue("UIBank_DataSheet", "Loanform");
		return data;
	}
	
	
	@Test(dataProvider = "excel")
	public void validateApplyLoanformWay1(String mail,String amt,String term,String sal,String ag) throws InterruptedException, IOException
	{
		applyloanform.applyloanform(mail,amt,term,sal,ag);
		logger.info("Customer Details were imported from Excel sheet");
		Thread.sleep(4000);
		boolean result = driver.getPageSource().contains(" Congrats! ");
		if(result== true )
		{
			Assert.assertTrue(true);
			logger.info("Loan Applied");
		}
		else{
			
			Assert.assertTrue(false);
			logger.warn("Test case Failed for Apply loan");
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
