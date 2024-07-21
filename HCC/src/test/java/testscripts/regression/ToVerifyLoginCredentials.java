package testscripts.regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class ToVerifyLoginCredentials extends BaseTest {
	

	@Test(priority=0)
	public void validLoginCredentials() {
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("FRONTOFFICE");
		driver.findElement(By.xpath("//input[@name='intialPassword']")).sendKeys("cgsl@123");
        driver.findElement(By.xpath("//input[@name='login']")).click();
        Assert.assertEquals(driver.getTitle(), "..:: Neura ::..");
	}
	@Test(priority=1)
	public void loginbyInvalidUsernameandValidPassword() {
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Frontoffice");
		driver.findElement(By.xpath("//input[@name='intialPassword']")).sendKeys("cgsl@123");
        driver.findElement(By.xpath("//input[@name='login']")).click();
        System.out.println(driver.switchTo().alert().getText());     
        driver.switchTo().alert().accept();
        System.out.println(driver.getTitle());
       Assert.assertEquals(driver.getTitle(), "Neura : Login Page");
        
	}
	@Test(priority=2)
	public void loginbyValidUsernameandInValidPassword(){
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("FRONTOFFICE");
		driver.findElement(By.xpath("//input[@name='intialPassword']")).sendKeys("cgsl@12");
        driver.findElement(By.xpath("//input[@name='login']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.getTitle(), "Neura : Login Page");
	}
	
	@Test(priority=3)
	public void loginbyInUsernameandInValidPassword()  {
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Frontoffice");
		driver.findElement(By.xpath("//input[@name='intialPassword']")).sendKeys("cgsl@12");
        driver.findElement(By.xpath("//input[@name='login']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.getTitle(), "Neura : Login Page");
	}

}


