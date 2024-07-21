package FrontOffice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;

public class SaveEncounter extends BaseTest{
	@Test
	public void encounter() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    driver.findElement(By.linkText("Expand All")).click();
	    driver.findElement(By.xpath("//span[text()=' Save Encounter']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='patientId']"))).sendKeys("HCC24002205");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'HCC24002205')]"))).click();
	    new Select( driver.findElement(By.xpath("//select[@name='episodeType']"))).selectByValue("opd");
	    new Select(driver.findElement(By.xpath("//select[@name='deptIdAttending']"))).selectByValue("1104");
	    Thread.sleep(3000);	    	    
	    new Select(driver.findElement(By.xpath("//select[@name='consultingDoctorAttending']"))).selectByIndex(3);
	    Thread.sleep(5000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='save']"))).click();
	    WebElement successMessageElement = driver.findElement(By.tagName("h5"));
		String successMessage = successMessageElement.getText();
		   System.out.println(successMessage);
	     driver.findElement(By.xpath("//span[text()='Payment']")).click();
	     driver.findElement(By.xpath("//input[@id='save']")).click();
	     driver.switchTo().alert().dismiss();
	}

}
