package testRunner;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testUtility.TestUtils;

public class TestRunner {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo-I7\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.lambdatest.com/register");
		Thread.sleep(2000);
		
	}
	
	
	
	@Test(dataProvider = "getData")
	public void test_func(String org_name, String name, String eMail, String passWord, String phoNe) throws InterruptedException
	{
		
		driver.findElement(By.name("organization_name")).sendKeys(org_name);
		Thread.sleep(2000);
	    
	    driver.findElement(By.name("name")).sendKeys(name);
	    Thread.sleep(2000);
	    
	    driver.findElement(By.name("email")).sendKeys(eMail);
	    Thread.sleep(2000);
	    
	    driver.findElement(By.name("password")).sendKeys(passWord);
	    Thread.sleep(2000);
	    
	    driver.findElement(By.name("phone")).sendKeys(phoNe);
	    
	    Thread.sleep(3000);
	}
	
	@DataProvider
	public Iterator<Object[]> getData()
	{
		ArrayList<Object[]> testData = TestUtils.getDataFromExcel();
		return testData.iterator();
	}
		
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
