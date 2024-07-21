package FrontOffice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;

public class BookResourceSchedule extends BaseTest {


@Test
public void scheduling() throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
   Thread.sleep(3000);
   wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Expand All"))).click();
   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Book Resource Schedule']"))).click();
   String parentWindowHandle = driver.getWindowHandle();
	driver.findElement(By.xpath("//td[text()='Dr.  Srikar  Reddy']")).click();
	Set<String> windowHandles = driver.getWindowHandles();
	for (String windowHandle : windowHandles) {
	    // Switch to the window if it's not the parent window
	    if (!windowHandle.equals(parentWindowHandle)) {
	        driver.switchTo().window(windowHandle);
	        break; 
	    }
	}
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='patientId']"))).sendKeys("HCC2400074");
	//driver.findElement(By.xpath("//input[@name='patientId']")).sendKeys("HCC2400074");
	driver.findElement(By.xpath("//a[contains(text(),'HCC24000749')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='cb55']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='book']")).click();
	
	
}
	
}
