package staffportal;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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



public class Workschedule {

	public static void main(String[]args) throws InterruptedException, AWTException, IOException {
		Createprovider Work=new Createprovider();
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
		XSSFSheet sheet=wb.getSheet("Workschedule");
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

		String tblcss="<style>table { border-spacing: 3px 10px; border-collapse: collapse; border: 1px solid red; }th { border: 1px solid blue; background:#AAC9FF; }td { border: 1px solid black; } .th_title {background:#7fb5da;}</style>\r\n";

		String Columnames="<tr><th>Testcase_ID</th><th>Name</th><th>Start</th><th>End</th><th>Type</th><th>Start time</th><th>End time</th><th>Description</th><th>statusmessage</th></tr>";
		Work.saveReport("Work schedule"+date+".html",tblcss+"<table border='1'><tr><th colspan=14><center>Staff Portal</center></th>"+Columnames);



		Thread.sleep(2000);
		WebElement mo = driver.findElement(By.xpath("//img[contains(@alt,'tpms')][2]"));
		Actions a = new Actions(driver);
		a.moveToElement(mo).perform();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//i[@class='fa fa-user-md']")).click();


		for(int i=6;i<=rowcount;i++) {

			XSSFRow cell=sheet.getRow(i);

			String Testcase_ID=cell.getCell(0).getStringCellValue(); 
			String name =cell.getCell(1).getStringCellValue();
			String Start=cell.getCell(2).getStringCellValue();
			String End=cell.getCell(3).getStringCellValue();
			String Type=cell.getCell(4).getStringCellValue();	
			String Starttime=cell.getCell(5).getStringCellValue();
			String Endtime=cell.getCell(6).getStringCellValue();
			String Description=cell.getCell(7).getStringCellValue();
			System.out.println(Testcase_ID);

			driver.findElement(By.xpath("//input[@class='form-control form-control-sm search_name common_selector']")).sendKeys(name);

			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='mr-2']")).click();


			driver.findElement(By.xpath("(//a[@class='nav-link'])[12]")).click();
			Thread.sleep(1000);


			driver.findElement(By.xpath("//input[@class='form-control form-control-sm mon_start']")).sendKeys(Start);

			driver.findElement(By.xpath("//input[@class='form-control form-control-sm mon_end']")).sendKeys(End);
			Thread.sleep(1000);

			driver.findElement(By.xpath("//button[@id='copy_times']")).click();

			//    driver.findElement(By.xpath("//i[@class='ri-file-copy-line ']")).click();

			driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@class='form-control form-control-sm date_range reportrange']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//li[text()='Last 7 Days']")).click();
			WebElement w= driver.findElement(By.xpath("//select[@class='form-control form-control-sm bo_type']"));
			w.click();
			Thread.sleep(1000);
			Select s= new Select(w);
			s.selectByVisibleText(Type);

			//	WebElement we= driver.findElement(By.xpath("(//button[@class='multiselect dropdown-toggle custom-select text-center'])[1]"));
			//we.click();  
			//Thread.sleep(1000);
			//Robot r=new Robot();
			//r.keyPress(KeyEvent.VK_DOWN);
			//r.keyPress(KeyEvent.VK_DOWN);
			//r.keyPress(KeyEvent.VK_DOWN);
			//r.keyPress(KeyEvent.VK_DOWN);
			//r.keyRelease(KeyEvent.VK_ENTER);
			//	      Select ss= new Select(we);
			//	        ss.selectByIndex(3);
			//  Thread.sleep(2000);
			//driver.findElement(By.xpath("(//span[@class='form-check'])[4]")).click();    
			//Thread.sleep(1000);
			//   driver.findElement(By.xpath("(//button[@class='multiselect dropdown-toggle custom-select text-center'])[1]")).click();

			WebElement day=driver.findElement(By.xpath("(//button[@class='multiselect dropdown-toggle custom-select text-center'])[1]"));
			day.click();
			Robot r=new Robot();
			WebElement ad=driver.findElement(By.xpath("//input[@class='multiselect-search form-control']"));
			ad.sendKeys("Tues");
			driver.findElement(By.xpath("(//input[@class='form-check-input'])[4]")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@class='form-control form-control-sm bo_st']")).sendKeys(Starttime);

			driver.findElement(By.xpath("//input[@class='form-control form-control-sm bo_et']")).sendKeys(Endtime);


			driver.findElement(By.xpath("//textarea[@class='form-control form-control-sm bo_description']")).sendKeys(Description);


			driver.findElement(By.xpath("(//button[@class='btn btn-warning'])[1]")).click();

			Thread.sleep(1000);
			WebElement toastMessage = driver.findElement(By.xpath("//div[@id='toast-container']"));
			System.out.println("Toastmessage: " + toastMessage.getText());
			String statusmessage=toastMessage.getText();

			Work.saveReport("Work Schedule"+date+".html",patientBillhtml(Testcase_ID,
					name,
					Start,
					End,
					Type,
					Starttime,
					Endtime,
					Description,statusmessage));




			driver.navigate().refresh();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//i[@class='fa fa-user-md']")).click();






		}
		Work.saveReport("Work schedule"+date+".html","</table>");

	}
	public static String  patientBillhtml(String Test_Case_ID,
			String name,
			String Start ,
			String End,
			String Type,
			String Starttime,
			String Endtime,
			String Description,
			String statusmessage)

	{
		String retval="";

		retval="<tr><td>"+Test_Case_ID+"</td>"+
				"<td>"+name+"</td>"+
				"<td>"+Start+"</td>"+ 
				"<td>"+End+"</td>"+
				"<td>"+Type+"</td>"+
				"<td>"+Starttime+"</td>"+
				"<td>"+Endtime+"</td>"+
				"<td>"+Description+"</td>"+
				"<td>"+statusmessage+"</td></tr>";
		return retval;


	}
}