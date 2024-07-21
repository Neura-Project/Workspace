package FrontOffice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;

public class PatientRegistration extends BaseTest{

	
	@Test
    public void Registration() throws InterruptedException {
		Thread.sleep(3000);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));


        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Expand All"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("addpatients.do"))).click();

        String parentWindowHandle = driver.getWindowHandle();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("title"))).sendKeys("Ms");
        driver.findElement(By.name("firstName")).sendKeys("zaru");
        driver.findElement(By.name("lastName")).sendKeys("P");
        driver.findElement(By.id("gender")).sendKeys("Female");
        //driver.findElement(By.id("dateOfBirth")).sendKeys("27072000");
        driver.findElement(By.xpath("//input[@id='ageYear']")).sendKeys("30");
        driver.findElement(By.id("mobile")).sendKeys("8790414449");
        driver.findElement(By.name("patientSourceId")).sendKeys("Advertisement");
        
       WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='file']")));
        fileInput.sendKeys("C:\\Users\\akhila.chilukri\\Downloads\\download.jpg");

        driver.findElement(By.name("corrPincode")).sendKeys("500092");
        driver.findElement(By.name("corrHsno")).sendKeys("2-6");
             Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='save']"))).click();
        
        

      for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                if (driver.getCurrentUrl().contains("receipt.jsp")) {
                    driver.close();
                    break;
                }
            }
        }

        driver.switchTo().window(parentWindowHandle);
        WebElement successMessageElement = driver.findElement(By.tagName("h5"));
        String successMessage = successMessageElement.getText();
        System.out.println(successMessage);

        String patientId = extractPatientIdFromMessage(successMessage);
        System.out.println("Patient ID: " + patientId);
        
    }
    private static String extractPatientIdFromMessage(String message) {

        int startIndex = message.indexOf("PatientId:-");
        if (startIndex != -1) {
            int endIndex = message.indexOf("\n", startIndex);
            if (endIndex != -1) {
                return message.substring(startIndex + 11, endIndex).trim();
            }
        }
        return null;
    }	
   	

   }



