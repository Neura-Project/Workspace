package testscripts.regression;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import base.BaseTest;

public class OPMainNote extends BaseTest {
    
    @Test
    public void OPNote() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.linkText("Expand All")).click();
        driver.findElement(By.xpath("//span[@id='EMR']")).click();
        driver.findElement(By.xpath("//span[text()=' OP WL']")).click();
        // Entering patient ID
        driver.findElement(By.xpath("//input[@name='patientId']")).sendKeys("HCC24002006");
        // Clicking on the search button
        driver.findElement(By.xpath("//a[contains(text(), 'HCC24002006')]")).click();
        // Clicking on the patient ID link
        driver.findElement(By.xpath("//input[@name='searchPaWl']")).click();       
        driver.findElement(By.xpath("//a[text()='HCC24002006']")).click(); 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       
        // Storing the parent window handle
        String parentWindowHandle = driver.getWindowHandle(); 
        
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
        driver.switchTo().window(parentWindowHandle);

        // Switching to the new window containing the OP Main Note screen
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle); 
                break;
            }
        }
        new Select(driver.findElement(By.id("templateId"))).selectByVisibleText("OP Main Note");
        
        // Now the WebDriver's focus should be on the new window containing the OP Main Note screen

        // Wait for patient banner to be visible
        WebElement patientBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("patientBanner")));
        
        // Extracting text content from the patient banner
        String patientDetails = patientBanner.getText();
        System.out.println(patientDetails);
        
        // Wait for allergies label to be visible
        WebElement allergies = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='allergiesMain']")));
        String allergiesText = allergies.getText();
        System.out.println("Allergies: " + allergiesText);
       
        Set<String> windowHandles = driver.getWindowHandles();

        // Iterate through window handles
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                // If the URL contains "clinical records", then break the loop and exit
                if (driver.getCurrentUrl().contains("clinicalrecords")) {
                    break;
                }
            }
        }
        
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        driver.findElement(By.linkText("Chief Complaints")).click();
  
        WebElement chiefComplaintsDropdown = driver.findElement(By.name("chiefComplaintDraft"));
        Select select = new Select(chiefComplaintsDropdown);
        select.selectByVisibleText("Abdominal Pain");
        select.selectByVisibleText("Back Ache");
        select.selectByVisibleText("Bloating Sensation");
        driver.findElement(By.xpath("//input[@onclick='moveOptionsFrom();']")).click();
        WebElement complaints = driver.findElement(By.xpath("//input[@id='1326CheckBox']"));
        WebElement complaints1 = driver.findElement(By.xpath("//input[@id='1334CheckBox']"));
        WebElement complaints2 = driver.findElement(By.xpath("//input[@id='1328CheckBox']"));
        
        
        if (!complaints.isSelected()) {
        	complaints.click();
        }
        
        if (!complaints1.isSelected()) {
        	complaints1.click();
        }
        
        if (!complaints2.isSelected()) {
        	complaints2.click();
        }
      
 
        
        Select illnessSelect = new Select(chiefComplaintsDropdown);
        illnessSelect.selectByVisibleText("Eating Disorder");
        illnessSelect.selectByVisibleText("Epigastric Pain");
        illnessSelect.selectByVisibleText("Neck Pain");
            
        driver.findElement(By.xpath("//input[@onclick='moveOptionsToHisIll();']")).click();
        driver.findElement(By.id("hisIllnessDesc2")).sendKeys("Test@123");
        driver.findElement(By.id("hisIllnessDesc3")).sendKeys("Test@123");
        driver.findElement(By.id("hisIllnessDesc4")).sendKeys("Test@123");
        
        new Select(driver.findElement(By.id("painScore"))).selectByVisibleText("8");
    driver.findElement(By.id("painScoreRemarks")).sendKeys("Testing");
    //Examinations
  /*  driver.findElement(By.linkText("Examination")).click();
    WebElement examinationsDropdown = driver.findElement(By.id("examinationDraft"));

 // Create a Select object for the dropdown
 Select examinationSelect = new Select(examinationsDropdown);

 // Select the desired options
 examinationSelect.selectByVisibleText("Consciousness");
 examinationSelect.selectByVisibleText("Agnosia");
 examinationSelect.selectByVisibleText("Asterixis");
 examinationSelect.selectByVisibleText("CN VII");
 // Create an Actions object
 Actions actions = new Actions(driver);

 // Double click each selected option
 List<WebElement> selectedOptions = examinationSelect.getAllSelectedOptions();
 for (WebElement option : selectedOptions) {
     actions.doubleClick(option).perform();
 }
     
 WebElement checkbox = driver.findElement(By.id("1083ExamCheckBox"));

if (!checkbox.isSelected()) {
  checkbox.click();
}
/*
 * List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

// Iterate over each checkbox and check it if it's not already checked
for (WebElement checkbox : checkboxes) {
    if (!checkbox.isSelected()) {
        checkbox.click();
    }
} 
 */

//Allergies
driver.findElement(By.linkText("Allergies")).click();
new Select(driver.findElement(By.id("allergyCategoryID"))).selectByIndex(2);
new Select(driver.findElement(By.id("allergenID"))).selectByIndex(2);
new Select(driver.findElement(By.id("reactionID"))).selectByIndex(3);
driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
driver.findElement(By.xpath("//input[@id='allergySave']")).click();

//HIstory
driver.findElement(By.linkText("History")).click();
driver.findElement(By.xpath("//textarea[@name='medicalAndSurgicalHistoryText']")).sendKeys("TEst@123");
driver.findElement(By.xpath("//textarea[@name='surgicalHistoryText']")).sendKeys("Test@123");
driver.findElement(By.xpath("//textarea[@name='familyHistoryText']")).sendKeys("Test@123");
new Select(driver.findElement(By.xpath("//select[@name='personalHistory']"))).selectByIndex(2);
driver.findElement(By.xpath("//input[@onclick='addRowFromSmoke();']")).click();
driver.findElement(By.xpath("//textarea[@name='occupationalHistoryText']")).sendKeys("Test@123");
driver.findElement(By.xpath("//textarea[@name='medicationHistoryText']")).sendKeys("Test@123");
new Select(driver.findElement(By.xpath("//select[@name='menstrualHistory']"))).selectByIndex(1);
driver.findElement(By.xpath("//input[@onclick=\"addRowToMenstrualTable('0','');\"]")).click();
driver.findElement(By.id("msdescription1")).sendKeys("Test@123");
new Select(driver.findElement(By.xpath("//select[@name='obstreticHistory']"))).selectByIndex(1);
driver.findElement(By.xpath("//input[@onclick=\"addRowToObstreticTable('0');\"]")).click();
driver.findElement(By.id("remarks1")).sendKeys("Test@123");
//Review of system
driver.findElement(By.linkText("Review Of Systems")).click();
//Locate the checkboxes
WebElement checkbox1 = driver.findElement(By.id("rosDeptCheck1"));
WebElement checkbox2 = driver.findElement(By.id("rosDeptCheck2"));
WebElement checkbox3 = driver.findElement(By.id("rosDeptCheck3"));

//Check the checkboxes if they are not already checked
if (!checkbox1.isSelected()) {
 checkbox1.click();
}

if (!checkbox2.isSelected()) {
 checkbox2.click();
}

if (!checkbox3.isSelected()) {
 checkbox3.click();
}

driver.findElement(By.linkText("Physical Examination")).click();
WebElement Examinations = driver.findElement(By.id("gesDeptCheck5"));
if (!Examinations.isSelected()) {
	Examinations.click();
	}
WebElement SubExaminations1 = driver.findElement(By.name("genExamCheck51"));
WebElement SubExaminations2 = driver.findElement(By.name("genExamCheck52"));
WebElement SubExaminations3 = driver.findElement(By.name("genExamCheck54"));
if (!SubExaminations1.isSelected()) {
	SubExaminations1.click();
	}
if (!SubExaminations2.isSelected()) {
	SubExaminations2.click();
	}
if (!SubExaminations3.isSelected()) {
	SubExaminations3.click();
	}
WebElement Examinations1 = driver.findElement(By.id("gesDeptCheck4"));
if (!Examinations1.isSelected()) {
	Examinations1.click();
	}


driver.findElement(By.linkText("Impressions")).click();
WebElement diagnosis = driver.findElement(By.id("favICDCheck"));
if (!diagnosis.isSelected()) {
	diagnosis.click();
	}

WebElement diagnosis1 = driver.findElement(By.name("icd1"));
WebElement diagnosis2 = driver.findElement(By.name("icd2"));
if (!diagnosis1.isSelected()) {
	diagnosis1.click();
	}
if (!diagnosis2.isSelected()) {
	diagnosis2.click();
	}
driver.findElement(By.xpath("//input[@value='Add to Provisional Diagnosis']")).click();
driver.findElement(By.id("pddescriptionn1")).sendKeys("Test@123");
WebElement diagnosis3 = driver.findElement(By.name("icd3"));
WebElement diagnosis4 = driver.findElement(By.name("icd4"));
if (!diagnosis3.isSelected()) {
	diagnosis3.click();
	}
if (!diagnosis4.isSelected()) {
	diagnosis4.click();
	}
driver.findElement(By.xpath("//input[@value='Add to Final Diagnosis']")).click();
driver.findElement(By.id("fddescriptionn1")).sendKeys("Test@123");

driver.findElement(By.linkText("Plan Of Care")).click();
 driver.findElement(By.xpath("//input[@name='serviceName']")).sendKeys("CBC");
//driver.findElement(By.xpath("//a[contains(text(),'CBC')]")).click();
//driver.findElement(By.xpath("//span[contains(text(), 'HEMOGRAM (CBC + RETIC + PS)=>LABORATORY=>LABORATORY')]")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'CBC')]"))).click();
driver.findElement(By.xpath("//input[@onclick='getServicePriceandUOM();']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//input[@name='drugs']")).sendKeys("Dolo 650");
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'DOLO 650 TAB')]"))).click();
new Select(driver.findElement(By.name("dosages1"))).selectByVisibleText("OD");
driver.findElement(By.xpath("//textarea[@id='physianAdvice']")).sendKeys("Test@123");
WebElement AdviceAdmission = driver.findElement(By.name("adviceAdmissionCheck"));
if (!AdviceAdmission.isSelected()) {
	AdviceAdmission.click();
	}
driver.findElement(By.xpath("//textarea[@id='adviceAdmission']")).sendKeys("Test@123");

driver.findElement(By.xpath("//textarea[@id='pendingInvestigations']")).sendKeys("Test@123");

driver.findElement(By.id("appointmentDate")).click();
driver.findElement(By.xpath("//a[@data-handler= 'next']")).click();
driver.findElement(By.xpath("//a[text()= '7']")).click();
Thread.sleep(3000);
String parentWindowHandle2 = driver.getWindowHandle();
WebElement appointmentdate =driver.findElement(By.xpath("//input[@value='Book Appointment']")) ;
appointmentdate.click();
System.out.println(appointmentdate);
driver.findElement(By.xpath("//input[@name='appointmentButn']")).click();

// Iterate through window handles
for (String windowHandle : driver.getWindowHandles()) {
    if (!windowHandle.equals(parentWindowHandle)) {
        driver.switchTo().window(windowHandle);
        // If the URL contains "clinical records", then break the loop and exit
        if (driver.getCurrentUrl().contains("showcalend.do?")) {
            break;
        }
    }
}
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='cb3']"))).click();
driver.findElement(By.xpath("//input[@id='book']")).click();

driver.switchTo().window(parentWindowHandle2);
driver.findElement(By.xpath("//input[@value='Get Appointment Info']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//textarea[@id = 'followupAdvice']")).sendKeys("Test@123");
driver.findElement(By.xpath("//input[@name='orderSave']")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='mainRecord']"))).click();

driver.switchTo().alert().accept();
     
     
    }
}
