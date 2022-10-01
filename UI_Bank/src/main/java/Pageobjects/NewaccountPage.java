package Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class NewaccountPage extends TestBase {

	@FindBy(name="accountNickname")
	@CacheLookup
	WebElement name;
	@FindBy(id="typeOfAccount")
	@CacheLookup
	WebElement Acctype;

	@FindBy(xpath="//button[text()='Apply']")
	@CacheLookup
	WebElement applybtn;

	@FindBy(id="viewAccounts")
	@CacheLookup
	WebElement Viewbtn;


	public NewaccountPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void setname(String uname)
	{
		name.sendKeys(uname);
	}

	public void setAccountType(String acc)
	{
		Select sel = new Select(Acctype);
		sel.selectByVisibleText(acc);

	}
	public void clickapplybtn()
	{
		applybtn.click();
	}

	public void clickviewbtn() {
		Viewbtn.click();

	}

}
