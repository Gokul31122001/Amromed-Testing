package Appointment;
import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class Recurring_session {

		public static void main(String[] args) throws InterruptedException, AWTException  {
			WebDriver driver=new ChromeDriver();
			driver.get("https://app.therapypms.com");
			driver.findElement(By.name("email")).sendKeys("admin@admin.com");
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Niyaz@1007");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
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
		driver.findElement(By.xpath("(//a[@class='iq-waves-effect'])[7]")).click();
		
		
		driver.findElement(By.xpath("//input[@class='form-control form-control-sm rec_daterange reportrange']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='This Month']")).click();

		Thread.sleep(1000);
		 WebElement w=driver.findElement(By.xpath("//select[@class='form-control form-control-sm sortby']"));
		 w.click();
		 Thread.sleep(1000);
		 Select s=new Select(w);
		 s.selectByIndex(1);
		 
	//	Thread.sleep(2000);
		//driver.findElement(By.xpath("(//button[@class='multiselect dropdown-toggle custom-select text-center'])[1]")).click();
		 //Thread.sleep(1000);
		 //driver.findElement(By.xpath("(//input[@class='form-check-input'])[1]")).click();
		 

		 
			Thread.sleep(3000);
		 driver.findElement(By.xpath("//button[@class='btn btn-sm btn-warning go-btn']")).click();
		
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//i[@class='fa fa-pencil-square-o'])[1]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//div[@class='custom-control custom-checkbox'])[8]")).click();
		
		 WebElement we=driver.findElement(By.xpath("//select[@class='form-control form-control-sm action_dropdown']"));
		 we.click();
		Select se=new Select(we);
		se.selectByIndex(1);
		 Thread.sleep(1000);
		 WebElement web=driver.findElement(By.xpath("//select[@class='form-control form-control-sm ml-2 days_select_dropdown']"));
		 web.click();
		 Select ses=new Select(web);
			ses.selectByIndex(2);
		 
			 Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@class='btn btn-sm btn-warning ml-2 bulk_day_btn']")).click();
		
		
		
		
		
		
		
	}
	}


