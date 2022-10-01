package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static  Logger logger;
	
	public TestBase()
	{
	
	prop = new Properties();
	try {
		FileInputStream ip = new FileInputStream("./Configuration/Config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	
	}
	
	
	
	public static void initialsation()
	{
		
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();

		}
		else if(browserName.equalsIgnoreCase("firefox"))
		
		{
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
			
		{
			System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		logger = Logger.getLogger("uibank");
		PropertyConfigurator.configure("log4j.properties");
		
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));
		
	}
	 public void   takescreenshot(WebDriver driver, String filename) throws IOException
	 {	 TakesScreenshot ts =(TakesScreenshot)driver;
	 	File source = ts.getScreenshotAs(OutputType.FILE);
	 	
		 String screenpath = System.getProperty("user.dir")+"/Screenshots/"+filename+ ".png"; // this doesnt rewrite file
		 File desti = new File(screenpath);
		
		 FileUtils.copyFile(source, desti);
		//return screenpath;
		 logger.info("screenshot Taken");
		 
	 }
	
	
	
	
	
	
}
