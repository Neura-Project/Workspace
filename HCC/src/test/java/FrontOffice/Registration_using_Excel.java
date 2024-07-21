package FrontOffice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.ExcelUtils;

public class Registration_using_Excel extends BaseTest {

   
    @Test
    public void registration() throws IOException, InterruptedException {
        // Wait for page to load
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        // Expand all and navigate to add patients
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Expand All"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("addpatients.do"))).click();
        String parentWindowHandle = driver.getWindowHandle();
        //String FilePath = System.getProperty("user.dir") + "\\testdata\\Excels\\PatentRegistration.xlsx";
        
      
        String FilePath = "E:/Workspace/HCC/src/test/resources/testdata/Excels/PatentRegistration.xlsx";
        System.out.println("FilePath: " + FilePath); // Print the file path to verify it's correct
        int rows = ExcelUtils.getRowCount(FilePath, "Sheet1");
        
        for (int i = 1; i<= rows; i++) {
            
                String title = ExcelUtils.getCellData(FilePath, "Sheet1", i, 0);
                String Fname = ExcelUtils.getCellData(FilePath, "Sheet1", i, 1);
                String Lname = ExcelUtils.getCellData(FilePath, "Sheet1", i, 2);
                String Age = ExcelUtils.getCellData(FilePath, "Sheet1", i, 3);
                String Phn = ExcelUtils.getCellData(FilePath, "Sheet1", i, 4);
                String patientsource = ExcelUtils.getCellData(FilePath, "Sheet1", i, 5);
                String pincode = ExcelUtils.getCellData(FilePath, "Sheet1", i, 6);
                String Hno = ExcelUtils.getCellData(FilePath, "Sheet1", i, 7);

                // Fill in patient registration form
                new Select(driver.findElement(By.name("title"))).selectByValue(title);
                driver.findElement(By.name("firstName")).sendKeys(Fname);
                driver.findElement(By.name("lastName")).sendKeys(Lname);
                driver.findElement(By.xpath("//input[@id='ageYear']")).sendKeys(Age);
                driver.findElement(By.id("mobile")).sendKeys(Phn);
                new Select(driver.findElement(By.name("patientSourceId"))).selectByValue(patientsource);

                WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='file']")));
                fileInput.sendKeys("C:\\Users\\akhila.chilukri\\Downloads\\download.jpg");

                driver.findElement(By.name("corrPincode")).sendKeys(pincode);
                driver.findElement(By.name("corrHsno")).sendKeys(Hno);
                Thread.sleep(3000);
                driver.findElement(By.xpath("//input[@name='save']")).click();
                
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
              driver.findElement(By.xpath("//span[text()='Close']")).click();
               Thread.sleep(3000);
     
        }
    
    }
}
