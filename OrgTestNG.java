package Vtiger;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Commonutil.BaseClass;
import Commonutil.ExelUtil;
import Commonutil.JavaUtil;
import Commonutil.PropertyFileUtil;
import Commonutil.WebDriverUtil;

public class OrgTestNG extends BaseClass{
	
	//public WebDriver d;

		PropertyFileUtil putil = new PropertyFileUtil();
		WebDriverUtil wutil = new WebDriverUtil(); 
		ExelUtil eutil = new ExelUtil();
		JavaUtil  jutil = new JavaUtil();
		@Test
		public void OrganizationsTest() throws IOException, InterruptedException
		{
			//ChromeDriver d = new ChromeDriver();
			//wutil.maximize(d);
		//	d.manage().window().maximize();	
			//d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//read data from property file
			
			//String URL = putil.getDataFromPropertyFile("Url");
//			String USERNAME = putil.getDataFromPropertyFile("Username");
//			String PASSWORD = putil.getDataFromPropertyFile("Password");
			String ORGNAME = eutil.getDataFromExcel("Organizations", 0, 1);
			String GROUP = eutil.getDataFromExcel("Organizations", 1, 1);
			
			//To launch the application 
			//d.get(URL);
			
			//To login to application
//			d.findElement(By.name("user_name")).sendKeys(USERNAME);
//			d.findElement(By.name("user_password")).sendKeys(PASSWORD);
//			d.findElement(By.id("submitButton")).click();
			
			//click on organization
			d.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
			
			//click on + sing
			d.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
			
			//click on organization name tf & enter the company name
			d.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.getRandomNumber());
			
			//in assignto click on group
			d.findElement(By.cssSelector("input[value='T']")).click();
			
			//in the dropdown select support group
			WebElement dropdown = d.findElement(By.name("assigned_group_id"));
			wutil.handledropdown(dropdown, GROUP);
			
			//to click on save button
			d.findElement(By.xpath("(//input[@name='button'])[1]")).click();
			
			//Thread.sleep(3000);
//			//Mousehover on image
//			WebElement img = d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
//			wutil.mousehovere(d, img);
//			
//			//click on sing out
//			d.findElement(By.xpath("//a[text()='Sign Out']")).click();
			
						
			
		
	}


}
