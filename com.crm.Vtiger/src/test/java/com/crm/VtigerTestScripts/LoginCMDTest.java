package com.crm.VtigerTestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginCMDTest {

	@Test 
	public void logincmd()
	{
		WebDriver driver=null;
		String browser=System.getProperty("browser");
		
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		
		 if(browser.equalsIgnoreCase("chrome"))
		 {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 System.out.println("Lounched browser is " + browser);
		 }
		 else if(browser.equalsIgnoreCase("firefox"))
		 {

			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			 System.out.println("Lounched browser is " + browser);
		 }
		 else
		 {
			 System.out.println("Specify a valid browser");

		 }
		 

		 driver.manage().window().maximize();
		 String url=System.getProperty("url");
			driver.get(url);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
		 
		 WebElement mouseover= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions action =new Actions(driver);
		 action.moveToElement(mouseover).perform();
		 
		 
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		 driver.close();
	}
}
