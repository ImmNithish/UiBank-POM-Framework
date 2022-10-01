package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;


public class RegisterPage extends TestBase {



	@FindBy(xpath="//small[text()='Register For Account']")
	@CacheLookup
	WebElement Registerbutn;

	@FindBy(id="firstName")
	@CacheLookup
	WebElement firstname;

	@FindBy(id="middleName")
	@CacheLookup
	WebElement middle;

	@FindBy(id="lastName")
	@CacheLookup
	WebElement lastele;

	@FindBy(id="password")
	@CacheLookup
	WebElement passbt;

	@FindBy(id="username")
	@CacheLookup
	WebElement usern; 

	@FindBy(id="age")
	@CacheLookup
	WebElement age;

	@FindBy(id="email")
	@CacheLookup
	WebElement emailbt;

	@FindBy(xpath="//button[text()='Register']")
	@CacheLookup
	WebElement registr;

	@FindBy(name="numberOfDependents")
	@CacheLookup 
	WebElement dependt;

	public RegisterPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void registerbtun()
	{
		Registerbutn.click();
	}

	public void Setfirstname(String fn) {

		firstname.sendKeys(fn);

	}


	public void SetTittle(String tl)
	{


		WebElement drop1 = driver.findElement(By.id("title"));
		Select oselect= new Select(drop1);
		oselect.selectByVisibleText(tl);
	}

	public void SetmiddleName(String md)
	{
		middle.sendKeys(md);
	}


	public void Setgender(String sx)
	{
		WebElement drop2 = driver.findElement(By.id("sex"));
		Select s2= new Select(drop2);
		s2.selectByVisibleText(sx);

	}


	public void Setempolymentdetail(String emp)
	{
		WebElement drop3 = driver.findElement(By.id("employmentStatus"));
		Select s3= new Select(drop3);
		s3.selectByVisibleText(emp);
	}

	public void SetAge(String ag)
	{
		age.sendKeys(ag);
	}

	public void Setmaritalstatus(String mar)
	{


		WebElement drop4 = driver.findElement(By.id("maritalStatus"));
		Select s4= new Select(drop4);
		s4.selectByVisibleText(mar);

	} 

	public void Setdepen(String dp)
	{
		dependt.sendKeys(dp);
	}


	public void Setusername(String username)
	{
		usern.clear();
		usern.sendKeys(username);

	}

	public void Setemail(String email)
	{	emailbt.clear();
		emailbt.sendKeys(email);
	}

	public void SetPass(String pass)
	{	passbt.clear();
		passbt.sendKeys(pass);
	}

	public void Setlastname(String ls) {

		lastele.sendKeys(ls);
	}

	public void clickresgistr()
	{
		registr.click();

	}


}


