package FrontOffice;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;

public class SavePatientCategory extends BaseTest {
	
@Test
	public void PatientCategory() throws InterruptedException {
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));

     Thread.sleep(3000);
    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Expand All"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='savepatientCategory.do']"))).click();
    driver.findElement(By.xpath("//input[@name='patientCategoryCode']")).sendKeys("TSRT");
    driver.findElement(By.xpath("//input[@name='patientCategoryDesc']")).sendKeys("Testerrss");
    driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("10.05");
    new Select(driver.findElement(By.xpath("//select[@id='glAccountSpDesc']"))).selectByValue("20400420");
    driver.findElement(By.xpath("//input[@id='save']")).click();
  //  driver.findElement(By.xpath("//input[@id='reset']")).click();
}

}
