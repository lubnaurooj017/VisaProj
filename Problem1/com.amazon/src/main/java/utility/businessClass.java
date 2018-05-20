package utility;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class businessClass 
{
	public static WebDriver dr = null;
	public WebDriver getDriver()
	{
		String browserName = System.getProperty("browser");	
		browserName = browserName.toUpperCase();
		//String browserName = "FIREFOX";
		switch(browserName) 
		{
		case "CHROME" :
			dr = new ChromeDriver();
			break;
		case "FIREFOX" :
			String vpath = new File("src/driverfile/geckodriver").getAbsolutePath();		
			System.setProperty("webdriver.gecko.driver", vpath);
			dr = new FirefoxDriver();
			break;	
		case "SAFARI" :   ///usr/bin/safaridriver --enable 
			dr = new SafariDriver();
			break;
		}
		return dr;
	}

	public static boolean isAlertPresent(WebDriver ldriver){		 
		try
		{	
			ldriver.switchTo().alert();		
			return true;	
		}
		catch(NoAlertPresentException ex)
		{	
			return false;	
		}
	}

	public static void handleAlert(WebDriver ldriver)
	{
		if(isAlertPresent(ldriver))
		{
			Alert alert = ldriver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
	}
}

