package test.with.pageobj.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Factory;

public class Guru99LoginPage {
	
	@FindBy(how=How.NAME,using="uid" )
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement pwd;
	
	@FindBy(xpath="//*[@value='LOGIN']")
	private WebElement logIn;
	
	WebDriver driver;
	
	public Guru99LoginPage(WebDriver dr){
		this.driver =dr;
		driver.get("http://demo.guru99.com/v4/");
	}
	
	public Boolean isPageloaded(){
	return true;	
	}
	
	public HomePage login(String usr,String psd){
		userName.sendKeys(usr);//mngr60925
		pwd.sendKeys(psd);//EhUgyvE
		logIn.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public String loginWithNegative(String usr,String psd){
		userName.sendKeys(usr);//mngr60925
		pwd.sendKeys(psd);//EhUgyvE
		logIn.click();
		Alert al = driver.switchTo().alert();
		String str= al.getText();
		al.accept();
		return str;
	}
	
	
//	WebElement userNameTxt = driver.findElement(By.name("uid"));
//	userNameTxt.sendKeys("mngr60925");
//	WebElement pwdTxt = driver.findElement(By.name("password"));
//	
//	pwdTxt.sendKeys("EhUgyvE");
//	WebElement btnSubmit = driver.findElement(By.name("btnLogin"));
//	btnSubmit.click();
//	Assert.assertEquals(driver.getCurrentUrl(), "http://demo.guru99.com/v4/manager/Managerhomepage.php");

}
