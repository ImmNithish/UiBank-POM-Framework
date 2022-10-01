package Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class Loginpage extends TestBase {
	
	// Page factory
	
	@FindBy(id="username")
	@CacheLookup
	 WebElement username;
	
	@FindBy(id="password")
	@CacheLookup
	 WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-block btn-blue btn-xl']")
	@CacheLookup
	WebElement submitBtn;
	
	@FindBy(id="emailHelp")
	@CacheLookup
	 WebElement register;
	
	@FindBy(xpath="//img[@class='vertical-center']")
	@CacheLookup
	 WebElement logo;
	
	@FindBy(xpath="//a[text()='Logout']")
	@CacheLookup
	WebElement logout;


	public Loginpage() {
		PageFactory.initElements(driver,this);
		
	}


	public String validateTittle()
	{
		return driver.getTitle();
		 
	}
	 public  boolean validateLogo()
	 {
		return logo.isDisplayed();
		 
	 }
	 
	 public  HomePage login(String us , String pass) {
	 username.sendKeys(us);
	 password.sendKeys(pass);
	 submitBtn.click();
	 return  new HomePage();
	 }
	 
	 public void setusername(String UserName)
	 {
		 username.sendKeys(UserName);
	 }
	 
	 public void setpassword(String Password)
	 {
		 password.sendKeys(Password);
	 }
	 
	 
	 public void submit()
	 {
		 
		 submitBtn.click();
		 
	 }
	 
	 public void clicklogout()
	 {
		 logo.click();
	 }
	 
	
}
