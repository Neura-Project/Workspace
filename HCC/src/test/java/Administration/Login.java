package Administration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;

public class Login extends BaseTest  {
//2659
	@Test
	public void LoginTest() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("2659");
		driver.findElement(By.xpath("//input[@name='intialPassword']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@name='login']")).click();
        
        driver.findElement(By.xpath("//input[@name='intialPassword']")).sendKeys("cgsl@123");
        driver.findElement(By.xpath("//input[@name='repeatPassword']")).sendKeys("cgsl@123");
        new Select(driver.findElement(By.xpath("//select[@id='questionId']"))).selectByValue("1001");
        driver.findElement(By.xpath("//input[@id='answer']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@id='change']")).click();
        System.out.println(driver.switchTo().alert().getText());     
        driver.switchTo().alert().accept();
     
        
	}
	
	
}
