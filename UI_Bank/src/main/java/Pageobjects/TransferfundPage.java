package Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class TransferfundPage extends TestBase {
	
	@FindBy(id="fromAccount")
	@CacheLookup
	WebElement from;
	
	@FindBy ( id="toAccount")
	@CacheLookup
	WebElement to;
	
	@FindBy(id="amountTransferred")
	@CacheLookup
	WebElement amountbox;
	
	@FindBy(xpath="//button[text()='Review']")
	@CacheLookup
	WebElement submitbutton;

	
	@FindBy(xpath="//button[text()='Confirm Transfer']")
	@CacheLookup
	WebElement confirmpop;
	
	
	public TransferfundPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void frombox()
	{
		Select osel = new Select(from);
		osel.selectByIndex(3);	
	}
	 public void tobox()
	 {
		 Select osel = new Select(to);
		 osel.selectByIndex(2);
	}
	 
	 public void amountbox()
	 {
		 amountbox.sendKeys(prop.getProperty("amount"));
	 }



	public void TransferConformation() {
		
		submitbutton.click();
		confirmpop.click();
		
	}


}
