package Flipkart_MavenAutomation.Flipkart_MavenProject;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FlipkartProj1 {

	@Test

	public void Ecommerce() throws Exception {
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement search = driver.findElement(By.xpath("//input[@name=\"q\"]"));
		search.sendKeys("iphone");
		search.sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@title='1GB and Below']//div[@class='_24_Dny']")).click();

		System.out.println("Ram got Clicked!");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt='Apple iPhone 14 (Blue, 128 GB)']")).click();

		System.out.println("Iphone 14 get clicked");

		Set<String> window = driver.getWindowHandles();
		System.out.println(window);
		Iterator<String> nexttab = window.iterator();
		String win1 = nexttab.next();
		String win2 = nexttab.next();

		driver.switchTo().window(win2);
		System.out.println("Window :" + win2);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		WebDriverWait place = new WebDriverWait(driver, 10);
		place.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")))
				.click();

	}

}
