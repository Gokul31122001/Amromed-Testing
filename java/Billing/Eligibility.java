package Billing;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class Eligibility {

	public static void main(String[] args) throws InterruptedException, AWTException, Exception  {
		Locale locale = new Locale("fr", "FR");
		DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
		String
		pattern = "MMddyyyyhhMMss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.print(date);
		WebDriver driver=new ChromeDriver();
		driver.get("https://app.therapypms.com");

		FileInputStream fi=new FileInputStream("C:\\Users\\Admin.DESKTOP-IKQO0G1\\eclipse-workspace\\Amromed\\Testdata\\Testcases.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sheet=wb.getSheet("Eligibility");
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
		driver.findElement(By.xpath("(//label[@class='custom-control-label'])[1]")).click();	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
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

		driver.findElement(By.xpath("//i[@class='las la-address-card']")).click();		
		Thread.sleep(1000);


		for(int i=6;i<=rowcount;i++) {

			XSSFRow cell=sheet.getRow(i);

			String Testcase_ID=cell.getCell(0).getStringCellValue(); 
			String Patient =cell.getCell(1).getStringCellValue();
			String Npi=cell.getCell(2).getStringCellValue();
			System.out.println(Testcase_ID);
			

		driver.findElement(By.xpath("(//button[@class='multiselect dropdown-toggle custom-select text-center'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='form-check-input'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='multiselect dropdown-toggle custom-select text-center'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='form-check-input'])[8]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='form-control form-control-sm reportrange']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='Last Year']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary view_btn select-form-grid-btn getData']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@class='btn btn-sm btn-warning request_eligibility']")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='select2-selection select2-selection--single'])[1]")).click();
		Thread.sleep(1000);
		WebElement web=driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		web.sendKeys(Patient);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@class='form-control form-control-sm eligibility_auth']")).click();
		Robot r2=new Robot();
		r2.keyPress(KeyEvent.VK_DOWN);
		r2.keyPress(KeyEvent.VK_DOWN);
		r2.keyPress(KeyEvent.VK_ENTER);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@class='form-control form-control-sm date-time eligibility_datetime']")).sendKeys("11/04/2024");

	WebElement s=driver.findElement(By.xpath("//select[@class='form-control form-control-sm eligibility_npi']"));
		Select select=new Select(s);
		select.selectByVisibleText(Npi);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='request_eligibility']")).click();
		















	}
}
}

