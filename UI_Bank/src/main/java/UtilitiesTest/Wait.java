package UtilitiesTest;

import java.time.Duration;

import Base.TestBase;

public class Wait extends TestBase {

	
	
	public  void implicitwait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
}
