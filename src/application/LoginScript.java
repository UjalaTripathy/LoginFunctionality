package application;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginScript {

	public static void main(String[] args) {
	}
	@Test(priority = 1)
	public void positiveTest() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		Thread.sleep(4000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		String expectedTitle = "Logged In Successfully | Practice Test Automation";
		String actualTitle = driver.getTitle();
		//assertEquals(actualTitle, expectedTitle);
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Logged In Successfully");

		}else {
			System.out.println("Invalid credentials");
		}
		driver.close();


	}
	@Test(priority = 2)
	public static void negativeTest() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("student123");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		String expectedTitle = "Logged In Successfully | Practice Test Automation";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle); 

	}
}
