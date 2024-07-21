package Administration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;

public class SaveEmployee extends BaseTest {
	
	@Test
	
	public void saveemployee() throws InterruptedException {
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[@id='ADMINISTRATION']")).click();
		driver.findElement(By.xpath("//span[text()='User Profile']")).click();
		driver.findElement(By.xpath("//span[text()=' Save Employee']")).click();
		driver.findElement(By.xpath("//input[@id='empCode']")).sendKeys("2496");
		new Select(driver.findElement(By.xpath("//select[@name='empType']"))).selectByValue("1090");
		new Select(driver.findElement(By.xpath("//select[@name='title']"))).selectByValue("1004");
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("AKHILA");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("REDDY");	
		driver.findElement(By.xpath("//input[@id='dateOfBirth']")).click(); //.sendKeys("27/07/2000");
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']"));
		new Select(driver.findElement(By.xpath("//select[@data-handler='selectYear']"))).selectByValue("2000");
		new Select(driver.findElement(By.xpath("//select[@data-handler='selectMonth']"))).selectByValue("6");
		driver.findElement(By.xpath("//a[text()='27']")).click();
		driver.findElement(By.xpath("//input[@id='dateOfJion']")).click();//.sendKeys("01/06/2024");
		//driver.findElement(By.xpath("//div[@id='ui-datepicker-div']"));
		new Select(driver.findElement(By.xpath("//select[@data-handler='selectYear']"))).selectByValue("2024");
		new Select(driver.findElement(By.xpath("//select[@data-handler='selectMonth']"))).selectByValue("5");
		driver.findElement(By.xpath("//a[text()='10']")).click();
		new Select(driver.findElement(By.xpath("//select[@id='language']"))).selectByValue("1001");
        new Select(driver.findElement(By.xpath("//select[@id='department']"))).selectByValue("1104");
        new Select(driver.findElement(By.xpath("//select[@id='roleid']"))).selectByValue("1206");
        new Select(driver.findElement(By.xpath("//select[@id='employementStatus']"))).selectByValue("active");
        driver.findElement(By.xpath("//input[@id='relHsno']")).sendKeys("2-34");
        driver.findElement(By.xpath("//input[@id='relCity']")).sendKeys("Hyderabad");              
        new Select(driver.findElement(By.xpath("//select[@id='relCountry']"))).selectByValue("1001");
        new Select(driver.findElement(By.xpath("//select[@id='relState']"))).selectByValue("1094");
        driver.findElement(By.xpath("//input[@name='save']")).click();
        WebElement code = driver.findElement(By.xpath("//div[contains(@class, 'blockUI blockMsg blockPage')]"));
	    String Message = code.getText();
	    System.out.println(Message);
	}

	
}
