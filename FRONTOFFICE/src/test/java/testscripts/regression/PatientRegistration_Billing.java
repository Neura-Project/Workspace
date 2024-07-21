package testscripts.regression;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;

public class PatientRegistration_Billing extends BaseTest {

    @Test
    public void Registration() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.linkText("Expand All")).click();
        driver.findElement(By.id("addpatients.do")).click();
        String parentWindowHandle = driver.getWindowHandle();
        driver.findElement(By.name("title")).sendKeys("Ms");
        driver.findElement(By.name("firstName")).sendKeys("laru");
        driver.findElement(By.name("lastName")).sendKeys("P");
        driver.findElement(By.id("gender")).sendKeys("Female");
        driver.findElement(By.id("dateOfBirth")).sendKeys("27072000");
        driver.findElement(By.id("mobile")).sendKeys("8790414449");
        driver.findElement(By.name("patientSourceId")).sendKeys("Advertisement");
        Thread.sleep(3000);
        new Select(driver.findElement(By.name("deptIdAttending"))).selectByVisibleText("CARDIOLOGY");
        Thread.sleep(4000);
        driver.findElement(By.name("consultingDoctorAttending")).click();
        new Select(driver.findElement(By.name("consultingDoctorAttending"))).selectByIndex(1);
        Thread.sleep(3000);
        driver.findElement(By.name("corrPincode")).sendKeys("500092");
        Thread.sleep(3000);
        driver.findElement(By.name("corrHsno")).sendKeys("2-6");
        Thread.sleep(3000);
        driver.findElement(By.name("save")).click();
        Thread.sleep(10000);

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
        
        driver.findElement(By.xpath("//span[text()='Encounter']")).click();
        
        String parentWindowHandle2 = driver.getWindowHandle(); 
        
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle); 
                break;
            }
        }

        // Now the WebDriver's focus should be on the new window containing the clinical notes

        // Clicking on the clinical notes image to open the new window
        driver.findElement(By.id("clinicalnotesImg")).click();

        // Switching back to the parent window
        driver.switchTo().window(parentWindowHandle2);

        // Switching to the new window containing the OP Main Note screen
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindowHandle2)) {
                driver.switchTo().window(windowHandle); 
                break;
            }
        }
        
      driver.findElement(By.id("save")).click();
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