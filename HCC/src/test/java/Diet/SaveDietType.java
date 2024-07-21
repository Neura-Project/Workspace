package Diet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

	public class SaveDietType extends BaseTest {

	    @Test
	    public void testTextAreaPresence() {
	       
	        WebElement textArea = driver.findElement(By.xpath("//input[@id='dietTypeCode']"));
	        Assert.assertTrue(textArea.isDisplayed());
	    }

	    @Test
	    public void testEnterText() {
	     
	        WebElement textArea = driver.findElement(By.id("textarea-id"));
	        textArea.sendKeys("This is a test text");
	        Assert.assertEquals("This is a test text", textArea.getAttribute("value"));
	    }

	    @Test
	    public void testMaximumLength() {
	        
	        WebElement textArea = driver.findElement(By.id("textarea-id"));
	        int maxLength = 100;  // Example maximum length
	        String longText = "a".repeat(maxLength + 10);  // Create text longer than maximum allowed
	        textArea.sendKeys(longText);
	        String enteredText = textArea.getAttribute("value");
	        Assert.assertEquals(maxLength, enteredText.length());  // Ensure text is truncated to maximum length
	    }

	    @Test
	    public void testValidationMessages() {
	    
	        WebElement submitButton = driver.findElement(By.id("submit-button-id"));
	        submitButton.click();  // Assuming clicking submit triggers validation
	        WebElement validationMessage = driver.findElement(By.id("validation-message-id"));
	        Assert.assertEquals("Text area is required.", validationMessage.getText());  // Example validation message
	    }

	  

}
