package org.testng;

import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sam extends PojoCl{
	@BeforeClass
	private void bef() {
		chromeDriver();maxWindow();waits();
		lanuchUrl("https://mail.google.com/mail/u/0/");
	}
	@BeforeMethod
	public void befMet() {
		Date d=new Date();
		System.out.println(d);
	}
	@Test(groups="sanity")
	public void ts() {
		System.out.println("launched Succesfully");
	}
	@AfterMethod
	public void afeM() {
		Date d=new Date();
		System.out.println(d);
	}
}
