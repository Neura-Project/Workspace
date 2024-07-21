package FrontOffice;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class SavePatientSource extends BaseTest {

@Test
public void patientSource() throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
   Thread.sleep(3000);
   wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Expand All"))).click();
   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='patientSource.do']"))).click();
    driver.findElement(By.xpath("//input[@name='patientSourceCode']")).sendKeys("TSRFT");
    driver.findElement(By.xpath("//input[@name='patientSourceDesc']")).sendKeys("Testetrss");   
    driver.findElement(By.xpath("//input[@id='save']")).click();
   //  driver.findElement(By.xpath("//input[@id='reset']")).click();
	
	
   

   
} 

}
	


