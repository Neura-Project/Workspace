package FrontOffice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class PatientSource extends BaseTest {

	@Test
	public void patientSource() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	   Thread.sleep(3000);
	   wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Expand All"))).click();
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='patientSource.do']"))).click();
	   driver.findElement(By.xpath("//input[@id='save']")).click();
	   WebElement code = driver.findElement(By.xpath("//div[contains(@class, 'patientSourceDescformError')]"));
	   String errorMessage = code.getText();
	   System.out.println("Patient source code:"+ errorMessage);
	   Assert.assertEquals(errorMessage, "* This field is required");
	   
	   WebElement description = driver.findElement(By.xpath("//div[contains(@class, 'patientSourceCodeformError ')]"));
	   String errorMessage2 = description.getText();
	   System.out.println("Description:" + errorMessage2);
	   Assert.assertEquals(errorMessage2, "* This field is required");
	   
	   
}
}