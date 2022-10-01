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

public class HomePageTest  extends TestBase{

	public Loginpage login;	
	HomePage homepage ;
	TransferfundPage transferfundpage;
	
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialsation();
		login = new Loginpage();
		 transferfundpage = new TransferfundPage();
		homepage =login.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomepageTittleTest()
	{
		String homepageTilttle = homepage.homepagetilttle();
		Assert.assertEquals(homepageTilttle, "UiBank");
	
	}
	
	@Test(priority = 2)
	public void VerifyclickTransfrerFundTest()
	{
	 transferfundpage = homepage.clicktransferfund();
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
