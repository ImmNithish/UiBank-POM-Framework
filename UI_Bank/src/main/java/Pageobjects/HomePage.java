package Pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import UtilitiesTest.Wait;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//div[@class='btn btn-white card-header-item']")
	@CacheLookup
	WebElement Newaccount;
	
	@FindBy(xpath="//a[text()=' Transfer Funds ']")
	@CacheLookup
	WebElement transferfund;

	@FindBy(xpath="//a[text()=' Apply For A Loan ']")
	@CacheLookup
	WebElement applyloan;
	
	@FindBy(xpath="(//button[@id='applyButton'])[1]")
	@CacheLookup
	WebElement applybutton;
	
	@FindBy(xpath="//a[text()=' Loan Status ']")
	@CacheLookup
	WebElement loanstatus;
	Wait wait;
	
	@FindBy(id="navbarDropdown")
	@CacheLookup
	WebElement drop;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String homepagetilttle()
	{
		String homepagetitle = driver.getTitle();
		return homepagetitle;
	}
	
	 public NewaccountPage clicknewaccount()
	 {
		 Newaccount.click();
		 return new NewaccountPage();
	 }
	 
	public TransferfundPage clicktransferfund()
	{
		 transferfund.click();
		 return new TransferfundPage();
		 
	}
	
	 
	public ApplyloanPage clickapplyloan()
	{	
		wait = new Wait();
		applyloan.click();
		wait.implicitwait();
		applybutton.click();
		return new ApplyloanPage();
		 
	}
	
	
	public  ApplyloanPage clickonProduct()
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("navbarDropdown"))).click().pause(Duration.ofSeconds(2)).perform();
		action.moveToElement(driver.findElement(By.xpath("//div[@class='dropdown-menu show']/a[1]")))
		.pause(Duration.ofSeconds(2)).click().perform();
		applybutton.click();
	
		return new ApplyloanPage();
	}
	
	
	
	
}
