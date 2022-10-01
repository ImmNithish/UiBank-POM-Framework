package Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class ApplyloanPage  extends TestBase{

	@FindBy(id="email")
	@CacheLookup
	WebElement email;
	
	
	@FindBy(id="amount")
	@CacheLookup
	WebElement amount;
	
	@FindBy(id="term")
	@CacheLookup
	WebElement dropdown; 

	@FindBy(id="income")
	@CacheLookup
	WebElement income;
	
	@FindBy(id="age")
	@CacheLookup
	WebElement age;
	
	@FindBy(id="submitButton")
	@CacheLookup
	WebElement submit;
	
	@FindBy(xpath="//h1[contains(text(),' You')]")
	@CacheLookup
	WebElement succestxt;
	
	public ApplyloanPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void applyloanform(String mail,String amt,String term,String inc,String ag) throws InterruptedException
	
	{	email.sendKeys(mail);
		amount.sendKeys(amt);
		Select sel = new Select(dropdown);
		sel.selectByVisibleText(term);
		income.sendKeys(inc);
		age.sendKeys(ag);
		submit.click();
		
		}


	
	
	
}
