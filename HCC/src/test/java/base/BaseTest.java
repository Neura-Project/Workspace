package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	public WebDriver driver;
	public static FileInputStream fis1;
	public static Properties configProp;
	//public static FileInputStream fis2;
	//public static Properties locatorsProp;
	
	@BeforeTest
	public void  fileSetUp() throws IOException
	{
		fis1=new FileInputStream("src\\test\\resources\\Properties\\config.properties");
		
		configProp=new Properties();
		
		configProp.load(fis1);
				
	//	locatorsProp.load(fis2);
		
	} 
	
	@BeforeMethod
	public void setup()
	{
		

		String browserName=configProp.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		//driver=new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
       
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
		driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
		driver=new EdgeDriver();
		}
		
		driver.get(configProp.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitWait"))));
	      
	    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("FRONTOFFICE");
		driver.findElement(By.xpath("//input[@name='intialPassword']")).sendKeys("cgsl@123");
        driver.findElement(By.xpath("//input[@name='login']")).click();
        
	}
	
	@AfterMethod
	public void teardown() 
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}

	

}