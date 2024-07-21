package testscripts.regression;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;

public class OP_WL extends BaseTest {
    
    @Test
    public void OPNOTE() throws InterruptedException {
    	Thread.sleep(5000);
	    driver.findElement(By.linkText("Expand All")).click();        
        driver.findElement(By.xpath("//span[@id='EMR']")).click();
        driver.findElement(By.xpath("//span[text()=' OP WL']")).click();
     //   new Select(driver.findElement(By.xpath("//select[@name='deptIdAttending']"))).selectByVisibleText("CARDIOLOGY");
        driver.findElement(By.xpath("//input[@name='patientId']")).sendKeys("HCC24001923");
        //new Select(driver.findElement(By.xpath("//a[contains(text(), 'HCC24000440')]"))).selectByVisibleText("HCC24000440");
        driver.findElement(By.xpath("//a[contains(text(), 'HCC24001923')]")).click();
        driver.findElement(By.xpath("//input[@name='searchPaWl']")).click();       
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        
        
WebElement patientRecord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='HCC24001923']")));
              
      Actions actions = new Actions(driver);
        actions.contextClick(patientRecord).perform();
        Thread.sleep(3000);
        WebElement consultationInProgressOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Consultation in progress')]")));
        consultationInProgressOption.click();
        
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//span[text()='Vitals']")).click();
        Thread.sleep(3000);
        driver.manage().window().maximize();
        String parentWindowHandle = driver.getWindowHandle();
     Set<String> allWindowHandles = driver.getWindowHandles();

     for (String handle : allWindowHandles) {
       
         if (!handle.equals(parentWindowHandle)) {
             driver.switchTo().window(handle);
             driver.findElement(By.xpath("//input[@id='heartRate']")).sendKeys("120");
             driver.findElement(By.xpath("//input[@id='respiration']")).sendKeys("120");
             driver.findElement(By.xpath("//input[@id='heightFeet']")).sendKeys("6");
             driver.findElement(By.xpath("//input[@id='bloodPressureSBP']")).sendKeys("120");
             new Select(driver.findElement(By.xpath("//select[@id='hh']"))).selectByVisibleText("01");
             new Select(driver.findElement(By.xpath("//select[@id='mm']"))).selectByVisibleText("01");
             new Select(driver.findElement(By.xpath("//select[@id='temperatureFrom']"))).selectByVisibleText("Oral");
             driver.findElement(By.xpath("//input[@id='temperatureC']")).sendKeys("60");         
             driver.findElement(By.xpath("//input[@id='spo2']")).sendKeys("120");    
             driver.findElement(By.xpath("//input[@id='weight']")).sendKeys("56"); 
             new Select(driver.findElement(By.xpath("//select[@id='painScore']"))).selectByVisibleText("03");
             driver.findElement(By.xpath("//textarea[@id='comments']")).sendKeys("Test@123");    
             driver.findElement(By.xpath("//input[@name='add']")).click(); 
             WebElement Vitals = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myGrid-box-focus")));
             //WebElement gridTable = driver.findElement(By.id("myGrid-box-focus"));          
          List<WebElement> rows = Vitals.findElements(By.tagName("tr"));
          for (WebElement row : rows) {
              List<WebElement> cells = row.findElements(By.tagName("td"));
              for (WebElement cell : cells) {
                  System.out.print(cell.getText() + "\t");
              }
              System.out.println();
          }
             }

         }
     }

    
        
    }

