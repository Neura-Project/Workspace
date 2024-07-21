package FrontOffice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;

public class SearchPatientCategory extends BaseTest {
	
@Test
public void SearchPatientCat() {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));

    try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Expand All"))).click();
   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='searchPatientCategory.do']"))).click();
	
	driver.findElement(By.xpath("//label[text()='Search: ']")).sendKeys("Test");
	
}

}
