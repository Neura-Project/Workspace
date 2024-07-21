package Laboratory;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class LabFlow extends BaseTest{
	
	@Test
	public void lab() throws InterruptedException {

	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//a[text()='Expand All']")).click();
	//driver.findElement(By.xpath("//span[@id='BILLING']")).click();
	//driver.findElement(By.xpath("//input[@id='INPATIENTBILLING']")).click();
	driver.findElement(By.xpath("//span[text()=' IP Investigations Billing']")).click();
    driver.findElement(By.xpath("//input[@id='patientId']")).sendKeys("0000");
    driver.findElement(By.xpath("//a[@id='ui-id-62']")).click();

	
	}
}