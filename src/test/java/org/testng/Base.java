package org.testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver ts;
	public static void pageUrl() {
		String url = ts.getCurrentUrl();
		System.out.println(url);
	}public static void pageTilte() {
		String title = ts.getTitle();
		System.out.println(title);
	}public static void chromeDriver() {
		WebDriverManager.chromedriver().setup();
		ts=new ChromeDriver();
	}public static void lanuchUrl(String url) {
		ts.get(url);
	}public static void maxWindow() {
		ts.manage().window().maximize();
	}public static void waits() {
		ts.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}public static void textBox(WebElement element,String value ) {
		element.sendKeys(value);
	}public static void btnClk(WebElement ref) {
		ref.click();
	}public static void rightcl(WebElement ref) {
		Actions a=new Actions(ts);
		a.contextClick(ref).perform();
	}public static void doublecl(WebElement ref) {
		Actions a=new Actions(ts);
		a.doubleClick(ref).perform();
	}public static void moveTo(WebElement ref) {
		Actions a=new Actions(ts);
		a.moveToElement(ref).perform();
	}public static void keyPress(int key) throws AWTException {
		Robot r=new Robot();
		r.keyPress(key);
	}public static void keyRel(int key) throws AWTException {
		Robot r=new Robot();
		r.keyRelease(key);
	}public static void dropDown(WebElement ref,int index) {
		Select s=new Select(ref);
		s.selectByIndex(index);
	}public static String readExcel(int rowNo,int cellNo) throws IOException {
		File f=new File("");
		FileInputStream fin=new FileInputStream(f);
		Workbook bo=new XSSFWorkbook(fin);
		Sheet sh = bo.getSheet("email");
		Row r = sh.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		int type = c.getCellType();
		String name="";
		if (type==1) {
			 name = c.getStringCellValue();
		} else if(DateUtil.isCellDateFormatted(c)) {
			Date da = c.getDateCellValue();
			SimpleDateFormat form=new SimpleDateFormat("dd-mm-yyyy");
			 name = form.format(da);
		}else {
			double d = c.getNumericCellValue();
			long l=(long)d;
			name=String.valueOf(l);
		}
		
		return name;
		}
}

