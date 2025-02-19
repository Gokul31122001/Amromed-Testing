package Billing;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.nio.channels.SelectableChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Patient_Statement {
	public static void main(String[]args) throws Exception {
		Locale locale = new Locale("fr", "FR");
		DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
		String pattern = "MMddyyyyhhMMss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.print(date);
		WebDriver driver=new ChromeDriver();
		driver.get("https://app.therapypms.com");


		FileInputStream fi=new FileInputStream("C:\\Users\\Admin.DESKTOP-IKQO0G1\\eclipse-workspace\\Amromed\\Testdata\\Testcases.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sheet=wb.getSheet("Patient_Statement");
		XSSFRow c=sheet.getRow(1);

		String eMail =c.getCell(0).getStringCellValue();
		String password=c.getCell(1).getStringCellValue();


		WebElement username = driver.findElement(By.name("email"));
		username.sendKeys(eMail);
		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys(password);
		WebElement signin = driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@class='custom-control-label']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

		driver.manage().window().maximize();
		int rowcount=sheet.getLastRowNum();
		int colcount=sheet.getRow(0).getLastCellNum();
		System.out.println("rowcount :"+rowcount+"colcount"+colcount);


		Thread.sleep(2000);

		WebElement mo = driver.findElement(By.xpath("//img[contains(@alt, 'tpms')][2]"));
		Actions a = new Actions(driver);

		a.moveToElement(mo).perform();

		driver.findElement(By.xpath("//i[@class='ri-exchange-dollar-line']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//i[@class='ri-file-text-fill']")).click();

		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@class='form-control form-control-sm generate_date']")).click(); Thread.sleep(1000);

		driver.findElement(By.xpath("//td[@class='mc-date mc-date--active mc-date--picked mc-date--today']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//button[@class='btn btn-sm btn-warning'])[1]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='multiselect-selected-text'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='form-check-input'])[1]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='form-control form-control-sm reportrange ps_reportrange']")).click();
		
		driver.findElement(By.xpath("//li[text()='Last Year']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='btn btn-sm btn-warning'])[2]")).click();
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='nav-link']")).click();
		
	WebElement m=driver.findElement(By.xpath("//select[@class='form-control form-control-sm sortby']"));
	m.click();
	Select s=new Select(m);
	s.selectByVisibleText("Invoice");
	
	WebElement n=driver.findElement(By.xpath("//select[@class='form-control form-control-sm paid_status']"));
	n.click();
	Select s1=new Select(n);
	s1.selectByVisibleText("All");
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//span[@class='multiselect-selected-text'])[1]")).click();

	Thread.sleep(1000);
	driver.findElement(By.xpath("(//input[@class='form-check-input'])[1]")).click();
	

	Thread.sleep(1000);
	driver.findElement(By.xpath("(//button[@class='btn btn-sm btn-warning'])[1]")).click();
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//td[@class='checkbox1_th checkbox_select344']")).click();
	
	WebElement se=driver.findElement(By.xpath("//select[@class='form-control form-control-sm action2']"));
	Select s2=new Select(se);
	s2.selectByVisibleText("Show Details(s)");
	
	driver.findElement(By.xpath("(//button[@class='btn btn-sm btn-primary'])[2]")).click();
	}
}
