package Administration;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;

public class UserProfile extends BaseTest {
	
@Test
public void saveUserProfile() throws InterruptedException

{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   Thread.sleep(3000);
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='ADMINISTRATION']"))).click();
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='User Profile']"))).click();
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Save/Update User Profile']"))).click();

       // Fill in the User Profile form
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userName']"))).sendKeys("2709");
       new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='serviceEntity']")))).selectByValue("1001");
       new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='location']")))).selectByValue("1001");
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='initial']"))).sendKeys("1");
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='repeat']"))).sendKeys("1");
       new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='userStatus']")))).selectByValue("Active");
       new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='secuQues']")))).selectByValue("1001");
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='answer']"))).sendKeys("1");

       // Ensure the employeeId dropdown is in view and clickable
       WebElement employeeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='employeeId']")));
       js.executeScript("arguments[0].scrollIntoView(true);", employeeDropdown);  // Scroll into view

       // Print all options for debugging
       Select employeeSelect = new Select(employeeDropdown);
       for (WebElement option : employeeSelect.getOptions()) {
           System.out.println("Option: " + option.getText());
       }

       // Select the employee by visible text
       employeeSelect.selectByVisibleText("  Miss KAT G");

       // Save the User Profile
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='save']"))).click();

       // Validate the success message
       WebElement code = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'blockUI blockMsg blockPage ')]")));
       String message = code.getText();
       System.out.println(message);

      
    
	
}

}
