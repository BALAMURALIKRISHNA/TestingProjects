package test.without.pageobj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class QBOSignIN {
	
	@Test
	public void testQBOSignIn()
	{
		WebDriver fd = new FirefoxDriver();
		fd.get("https://qbo.intuit.com");
		fd.close();
	}
	

}
