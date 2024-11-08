package Createappointment_New;
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
import org.openqa.selenium.support.ui.Select;

public class Broadcast {



		public static void main(String[]args) throws InterruptedException, AWTException, IOException {
			WebDriver driver=new ChromeDriver();
			driver.get("https://app.therapypms.com");
			
				
			Locale locale = new Locale("fr", "FR");
			DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
			String pattern = "MMddyyyyhhMMss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
			System.out.print(date);

			FileInputStream fi=new FileInputStream("C:\\Users\\Admin.DESKTOP-IKQO0G1\\eclipse-workspace\\Amromed\\Testdata\\Testcases.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fi);
			XSSFSheet sheet=wb.getSheet("Broadcast");
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
			
			int rowcount=sheet.getLastRowNum();
			int colcount=sheet.getRow(0).getLastCellNum();
			System.out.println("rowcount :"+rowcount+"colcount"+colcount);
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//i[contains(@class,'las la-plus')])[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//a[@class='dropdown-item'])[7]")).click();
			Thread.sleep(1000);

			for(int i=6;i<=6;i++) {

				XSSFRow cell=sheet.getRow(i);

				String Testcase_ID=cell.getCell(0).getStringCellValue(); 
				String Patient =cell.getCell(1).getStringCellValue();
				String Patientname =cell.getCell(2).getStringCellValue();
				String Message =cell.getCell(3).getStringCellValue();
				String Provider =cell.getCell(4).getStringCellValue();
				String Providername =cell.getCell(5).getStringCellValue();
				String Message2 =cell.getCell(6).getStringCellValue();
				
				System.out.println(Testcase_ID);
				 

					WebElement we=driver.findElement(By.xpath("//select[@class='form-control form-control-sm broadcast_user_type']"));
			         Select s=new Select(we);
			         s.selectByVisibleText(Patient);
			         
			         Thread.sleep(1000);
			         Robot r=new Robot();
			         WebElement web=driver.findElement(By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[2]"));
			         web.sendKeys(Patientname);
			         r.keyPress(KeyEvent.VK_ENTER);

			   
				
						Thread.sleep(1000);
						
					
					driver.findElement(By.xpath("//textarea[@class='form-control form-control-sm broadcast_message']")).sendKeys(Message);
						driver.findElement(By.xpath("//button[@class='btn btn-warning send_broadcast']")).click();
						Thread.sleep(1000);
						WebElement toastMessage = driver.findElement(By.xpath("//div[@id='toast-container']"));
						System.out.println("Toastmessage: " + toastMessage.getText());
						String statusmessage=toastMessage.getText();	
						
						Thread.sleep(2000);
						driver.navigate().refresh();
					

						Thread.sleep(1000);
						driver.findElement(By.xpath("(//i[contains(@class,'las la-plus')])[1]")).click();
						Thread.sleep(1000);
						driver.findElement(By.xpath("(//a[@class='dropdown-item'])[7]")).click();
						Thread.sleep(1000);
						
						WebElement pro=driver.findElement(By.xpath("//select[@class='form-control form-control-sm broadcast_user_type']"));
				         Select s1=new Select(pro);
				         s1.selectByVisibleText(Provider);
				         Thread.sleep(1000);
				         
				         Robot r1=new Robot();
				         WebElement w=driver.findElement(By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[3]"));
				         w.sendKeys(Providername);
				         Thread.sleep(1000);
				         r1.keyPress(KeyEvent.VK_ENTER);


						
							
							
							
						
						driver.findElement(By.xpath("//textarea[@class='form-control form-control-sm broadcast_message']")).sendKeys(Message2);
							driver.findElement(By.xpath("//button[@class='btn btn-warning send_broadcast']")).click();
							Thread.sleep(1000);
							WebElement t = driver.findElement(By.xpath("//div[@id='toast-container']"));
							System.out.println("Toastmessage: " + t.getText());
							String status=t.getText();
			 }
}

}