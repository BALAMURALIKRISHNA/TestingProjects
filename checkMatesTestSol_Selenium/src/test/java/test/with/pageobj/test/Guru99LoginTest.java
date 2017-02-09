package test.with.pageobj.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import test.with.pageobj.pages.Guru99LoginPage;
import test.with.pageobj.pages.HomePage;

public class Guru99LoginTest {
	

	WebDriver  driver;
	@BeforeTest
	public void setup(){
		driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", "/Users/bkrishnankutty/Desktop/MyFolder/Study/chromedriver");
		//ChromeSystem.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
//		Options options = new ChromeOptions();
//		options.addArguments("--user-data-dir=/path/to/ChromeUserDir");
//		options.addArguments("--profile-directory=Profile 2");
	//	WebDriver driver = new ChromeDriver(options);
		
		driver = new ChromeDriver();
	}
	
	@DataProvider(name="dp")
	public String[][] dp(){
		String[][] srr = {{"kez","EhUgyvE"},{"mngr60925","ssd"},{"ffg","sdds"}};
		return srr;
	}
	
	@Test
	public void LoginTest(){		
		Guru99LoginPage logInPage = PageFactory.initElements(driver, Guru99LoginPage.class);
		HomePage hgPage = logInPage.login("mngr60925", "EhUgyvE");
		Assert.assertEquals(hgPage.assertString(), "Manger Id : mngr60925");
	
	}
	
	@Test(dataProvider="dp")
	public void negativeLoginTest(String usr, String pwd){
		
		Guru99LoginPage logInPage = PageFactory.initElements(driver, Guru99LoginPage.class);
		String str = logInPage.loginWithNegative(usr, pwd);
		System.out.println(str);
		
	
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
}
