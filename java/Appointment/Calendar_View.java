package Appointment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
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

public class Calendar_View {
	public static void main(String[] args) throws InterruptedException, AWTException, IOException  {
		Locale locale = new Locale("fr", "FR");
		DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
		String pattern = "MMddyyyyhhMMss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String d = simpleDateFormat.format(new Date());
		System.out.print(d);
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://app.therapypms.com");

		
		FileInputStream fi=new FileInputStream("C:\\Users\\Admin.DESKTOP-IKQO0G1\\eclipse-workspace\\Amromed\\Testdata\\Testcases.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sheet=wb.getSheet("Calendar_View");
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



		Thread.sleep(2000);

		WebElement mo = driver.findElement(By.xpath("//img[contains(@alt, 'tpms')][2]"));
		Actions a = new Actions(driver);

		a.moveToElement(mo).perform();

		driver.findElement(By.xpath("(//a[@class='iq-waves-effect collapsed'])[1]")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class='iq-waves-effect'])[5]")).click();

		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//label[@class='custom-control-label'])[1]")).click();
		
		driver.findElement(By.xpath("//li[text()='8']")).click();
		
		Thread.sleep(1000);
		WebElement pr=driver.findElement(By.xpath("(//button[@class='multiselect dropdown-toggle custom-select text-center'])[1]"));
		pr.click();
		//Thread.sleep(3000);
	//	Select select=new Select(pr);
		//select.selectByVisibleText("Jensen, Cliff");
		
		driver.findElement(By.xpath("(//label[@class='form-check-label'])[61]")).click();
		
	WebElement b=driver.findElement(By.xpath("//select[@class='form-control form-control-sm time']"));
			b.click();
			Select s=new Select(b);
				s.selectByVisibleText("Thirty minute session");


		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='btn btn-sm btn-primary '])[1]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='badge no_avail_appointment'])[5]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='appointment-card'])[1]")).click();
		
		Thread.sleep(1000);
		Robot r=new Robot();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Select Patient']")).click();

		WebElement n=driver.findElement(By.xpath("(//input[@type='search'])[7]"));
		n.sendKeys("Zaid, Ahmed");
		r.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='multiselect dropdown-toggle custom-select text-center'])[11]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='form-check'])[162]")).click();
	//	Thread.sleep(1000);
		//driver.findElement(By.xpath("(//button[@class='multiselect dropdown-toggle custom-select text-center'])[11]")).click();


	
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='multiselect dropdown-toggle custom-select text-center'])[11]")).click();

		Robot r1=new Robot();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='select2-selection__rendered'])[4]")).click();
		WebElement pro=driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		pro.sendKeys("Suzane, Kay");
		r1.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@class='btn btn-warning'])[1]")).click();
		
		Thread.sleep(1000);
		WebElement toastMessage = driver.findElement(By.xpath("//div[@id='toast-container']"));
		System.out.println("Toastmessage: " + toastMessage.getText());
		String statusmessage=toastMessage.getText();

	}
}
