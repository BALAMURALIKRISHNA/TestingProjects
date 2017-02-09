package test.without.pageobj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Guru99Test {
	
	WebDriver driver = new FirefoxDriver();
	
	//@Test()
	public void login(){
		
		driver.get("http://demo.guru99.com/v4/");
		WebElement userNameTxt = driver.findElement(By.name("uid"));
		userNameTxt.sendKeys("mngr60925");
		WebElement pwdTxt = driver.findElement(By.name("password"));
		
		pwdTxt.sendKeys("EhUgyvE");
		WebElement btnSubmit = driver.findElement(By.name("btnLogin"));
		btnSubmit.click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://demo.guru99.com/v4/manager/Managerhomepage.php");
		WebElement mangTxt = driver.findElement(By.cssSelector("body >table >tbody >tr>td >table>tbody>tr.heading3 >td"));
		System.out.println("ManagerID"+mangTxt.getText().toString());
		WebElement el = driver.findElement(By.cssSelector("body >table >tbody >tr>td >table>tbody>tr.heading3"));
		System.out.println(el.getAttribute("align"));
		System.out.println(el.getAttribute("class"));
		System.out.println(el.getAttribute("name"));
		System.out.println(el.getLocation());
		System.out.println(el.getSize());
		System.out.println(el.getRect().getHeight());
		
	}
	
	
	@Test
	public void spCharacter() throws InterruptedException
	{
		driver.get("http://demo.guru99.com/v4/");
		WebElement userNameTxt = driver.findElement(By.name("uid"));
		
		//userNameTxt.sendKeys(Keys.chord(Keys.SHIFT,"bala"));
		//userNameTxt.clear();
		Thread.sleep(1000);
		Actions builder = new Actions(driver);
		//builder.keyDown(Keys.SHIFT).sendKeys(userNameTxt,"\tbala").keyUp(Keys.SHIFT).perform();
		builder.contextClick();
		
		Thread.sleep(1000);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
