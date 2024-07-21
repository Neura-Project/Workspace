package Administration;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class EmpolyeecreationToLogin extends BaseTest {

@Test(priority=1)
	
	public void saveemployee() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("akhila");
		driver.findElement(By.xpath("//input[@name='intialPassword']")).sendKeys("cgsl@1");
        driver.findElement(By.xpath("//input[@name='login']")).click();
        Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@id='ADMINISTRATION']")).click();
		driver.findElement(By.xpath("//span[text()='User Profile']")).click();
		driver.findElement(By.xpath("//span[text()=' Save Employee']")).click();
		driver.findElement(By.xpath("//input[@id='empCode']")).sendKeys("2963");
		new Select(driver.findElement(By.xpath("//select[@name='empType']"))).selectByValue("1090");
		new Select(driver.findElement(By.xpath("//select[@name='title']"))).selectByValue("1004");
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("AKKI");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("R");	
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
        Thread.sleep(3000);
        new Select(driver.findElement(By.xpath("//select[@id='relState']"))).selectByValue("1094");
        driver.findElement(By.xpath("//input[@name='save']")).click();
        WebElement code = driver.findElement(By.xpath("//div[contains(@class, 'blockUI blockMsg blockPage')]"));
	    String Message = code.getText();
	    System.out.println(Message);
	}

@Test(priority=2)
public void saveUserProfile() throws InterruptedException

{
	driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("akhila");
	driver.findElement(By.xpath("//input[@name='intialPassword']")).sendKeys("cgsl@1");
    driver.findElement(By.xpath("//input[@name='login']")).click();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@id='ADMINISTRATION']")).click();
	driver.findElement(By.xpath("//span[text()='User Profile']")).click();
    driver.findElement(By.xpath("//span[text()=' Save/Update User Profile']")).click();
	driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("8790");
	new Select(driver.findElement(By.xpath("//select[@id='serviceEntity']"))).selectByValue("1001");
	new Select(driver.findElement(By.xpath("//select[@name='location']"))).selectByValue("1001");
	driver.findElement(By.xpath("//input[@name='initial']")).sendKeys("1");
	driver.findElement(By.xpath("//input[@name='repeat']")).sendKeys("1");
	new Select(driver.findElement(By.xpath("//select[@name='userStatus']"))).selectByValue("Active");
	new Select(driver.findElement(By.xpath("//select[@name='secuQues']"))).selectByValue("1001");
	driver.findElement(By.xpath("//input[@name='answer']")).sendKeys("1");
	Thread.sleep(3000);
	new Select(driver.findElement(By.xpath("//select[@name='employeeId']"))).selectByVisibleText("  Miss AKKI R");	                                                                                               
	driver.findElement(By.xpath("//input[@name='save']")).click();
	WebElement code = driver.findElement(By.xpath("//div[contains(@class, 'blockUI blockMsg blockPage ')]"));
    String Message = code.getText();
    System.out.println(Message);
    
	
}

@Test(priority=3)
public void LoginTest() throws InterruptedException {
	
	driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("8790");
	driver.findElement(By.xpath("//input[@name='intialPassword']")).sendKeys("1");
    driver.findElement(By.xpath("//input[@name='login']")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@name='intialPassword']")).sendKeys("cgsl@123");
    driver.findElement(By.xpath("//input[@name='repeatPassword']")).sendKeys("cgsl@123");
    new Select(driver.findElement(By.xpath("//select[@id='questionId']"))).selectByValue("1001");
    driver.findElement(By.xpath("//input[@id='answer']")).sendKeys("1");
    driver.findElement(By.xpath("//input[@id='change']")).click();
    System.out.println(driver.switchTo().alert().getText());     
    driver.switchTo().alert().accept();
    
}
@Test(priority=4)
public void Login() {
	
	driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("8790");
	driver.findElement(By.xpath("//input[@name='intialPassword']")).sendKeys("cgsl@123");
    driver.findElement(By.xpath("//input[@name='login']")).click();
    Assert.assertEquals(driver.getTitle(), "..:: Neura ::..");
    

}

}