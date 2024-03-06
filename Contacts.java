package Vtiger;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Commonutil.BaseClass;
import Commonutil.ExelUtil;
import Commonutil.JavaUtil;
import Commonutil.PropertyFileUtil;
import Commonutil.WebDriverUtil;
@Listeners(ListenerImplimentation.class)
public class Contacts extends BaseClass{
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil(); 
	ExelUtil eutil = new ExelUtil();
	JavaUtil  jutil = new JavaUtil();
	@Test
	public void OrganizationsTest() throws IOException, InterruptedException
	{
		ChromeDriver d = new ChromeDriver();
		wutil.maximize(d);
	//	d.manage().window().maximize();	
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//read data from property file
		String URL = putil.getDataFromPropertyFile("Url");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		String FIRSTNAME = eutil.getDataFromExcel("Contact", 0, 1);
		String LAASTNAME = eutil.getDataFromExcel("Contact", 1, 1);
		String DROP = eutil.getDataFromExcel("Contact", 2, 1);
		String orname = eutil.getDataFromExcel("Contact", 3, 1);
		
		//To launch the application 
		d.get(URL);
		
		//To login to application
		d.findElement(By.name("user_name")).sendKeys(USERNAME);
		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
		d.findElement(By.id("submitButton")).click();
		
		//click on contacts
		d.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//click on + sing
		d.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		
		//click on first name tf & enter the name
		d.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		
		//click on last name tf & enter the name
		d.findElement(By.name("lastname")).sendKeys(LAASTNAME);
		
		//To fail the testscript
	/*	String actualurl = d.getCurrentUrl();
		String expectedurl = "http://localhost:8888/pune/index.php?module=Contacts&action=index";
		Assert.assertEquals(actualurl, expectedurl);*/
		
		//click on + sing
		d.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		
		//to go child window
		wutil.switchTo(d,"http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		
		//Screenshot
		wutil.screenSho(d, orname);
		
		//to enter text
		d.findElement(By.cssSelector("input[name='search_text']")).sendKeys(orname);
		
		//to click on search
		d.findElement(By.cssSelector("input[name='search']")).click();
		
		//click on Organization Name		
		d.findElement(By.xpath("//a[text()='HP1']")).click();
		
		//to come back parent window
		wutil.switchTo(d, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
		//to select redio button
		d.findElement(By.cssSelector("input[value='T']")).click();
		
		//in the dropdown select group
		d.findElement(By.cssSelector("select[name='assigned_group_id']")).sendKeys(DROP);
		
		//to click on save button
		d.findElement(By.xpath("(//input[@name='button'])[1]")).click();	
		
		//Mousehover on image
		WebElement img = d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mousehovere(d, img);
				
		//click on sing out
		d.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
					
		
	}

}
