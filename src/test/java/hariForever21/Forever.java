package hariForever21;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Forever {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Hariprasath\\eclipse-workspace\\Sample1\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.forever21.in/");
		driver.findElement(By.xpath("//*[@id=\"headerSearch\"]")).sendKeys("sneakers");
		Thread.sleep(3000);
	Robot r = new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[@id=\"divF21ProductList\"]/div[1]/div[1]/a/ul/li[1]/div/img")).click();
	Thread.sleep(6000);
	driver.findElement(By.xpath("//a[@value='8']")).click();
	driver.findElement(By.xpath("//button[@id='add_to_cart']")).click();
	 String value1 = driver.findElement(By.xpath("//*[@id=\"product_infodet\"]/div/h2")).getText();
	 System.out.println(value1);
	 String value2 = driver.findElement(By.xpath("//*[@id=\"final_change_price\"]")).getText();
	 System.out.println(value2);
	 File loc = new File ("C:\\Users\\Hariprasath\\eclipse-workspace\\hariForever21\\excel\\sam.xlsx");
	 Workbook w = new XSSFWorkbook();
	 Sheet s = w.createSheet("Sneakers");
	 Row R = s.createRow(1);
	Cell c = R.createCell(1);
	 c.setCellValue(value1);
	 Cell c1 = R.createCell(2);
	 c1.setCellValue(value2);
	 FileOutputStream f=new FileOutputStream(loc);
	 w.write(f);
	 
	       
	}

}
