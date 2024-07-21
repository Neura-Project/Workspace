package testscripts.regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;

public class Encounter extends BaseTest  {

	@Test
	public void encounter() throws InterruptedException {
		Thread.sleep(5000);
	    driver.findElement(By.linkText("Expand All")).click();
	    driver.findElement(By.xpath("//span[text()=' Save Encounter']")).click();
	    Thread.sleep(3000 )  ;
	    driver.findElement(By.xpath("//input[@name='patientId']")).sendKeys("HCC24001923");
	    Thread.sleep(3000);
	     driver.findElement(By.xpath("//a[contains(text(),'HCC24001923')]")).click();
	   new Select( driver.findElement(By.xpath("//select[@name='episodeType']"))).selectByVisibleText(" OPD");
	   new Select(driver.findElement(By.xpath("//select[@name='deptIdAttending']"))).selectByVisibleText(" CARDIOLOGY");
	   Thread.sleep(3000);
	   new Select(driver.findElement(By.xpath("//select[@name='consultingDoctorAttending']"))).selectByIndex(1);
	   driver.findElement(By.xpath("//input[@name='save']")).click();
	   
	   WebElement successMessageElement = driver.findElement(By.tagName("h5"));
	   String successMessage = successMessageElement.getText();
	   System.out.println(successMessage);
	     driver.findElement(By.xpath("//span[text()='Payment']")).click();
	     driver.findElement(By.xpath("//input[@id='save']")).click();
	     driver.switchTo().alert().dismiss();
	}
	}
	


