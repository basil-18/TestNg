package org.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrow {
	public WebDriver d;
	@Parameters({"browser"})
	@Test
	public void browser(String BrName) {
		if (BrName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			d=new ChromeDriver();
		} else if(BrName.contains("ff")) {
			WebDriverManager.firefoxdriver().setup();
			d=new FirefoxDriver();
		}else {
			WebDriverManager.edgedriver().setup();
			d=new EdgeDriver();
		}
		d.get("https://www.flipkart.com/account/login");
	}
	@Test
	private void ts1() {
		WebElement user = d.findElement(By.xpath("(//input[@type='text'])[2]"));
		user.sendKeys("greens@123");
		WebElement pa = d.findElement(By.xpath("//input[@type='password']"));
		pa.sendKeys("098765");
		WebElement lo = d.findElement(By.xpath("(//button[@type='submit'])[2]"));
		lo.click();
		
	}

}
