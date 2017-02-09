package test.with.pageobj.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver ;
	
	@FindBy(css="body >table >tbody >tr>td >table>tbody>tr.heading3 >td")
	private WebElement mngTxt;
	
	@FindBy(linkText="LogOut")
	private WebElement logOut;
	
	public HomePage(WebDriver dr){
		this.driver = dr;
		System.out.println(driver.getCurrentUrl());
	}
	
	public String assertString(){
		return mngTxt.getText().toString();
	}
	
	public Guru99LoginPage LogOut(){
		logOut.click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		return PageFactory.initElements(driver, Guru99LoginPage.class);
	}

}
