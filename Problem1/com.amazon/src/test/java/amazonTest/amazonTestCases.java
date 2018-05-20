package amazonTest;

import org.testng.annotations.Test;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utility.businessClass;
import utility.parseJsonClass;
import visaChandler.com.amazon.loginPage;

public class amazonTestCases extends businessClass{

	parseJsonClass pjc= new parseJsonClass();
	JSONObject jsonObj= null;

	String browserUrl="";
	WebDriver dr = getDriver();
	loginPage lp = new loginPage();

	@BeforeSuite
	public void beforeSuite()
	{	
		dr.manage().window().maximize();
		browserUrl = System.getProperty("url");
		jsonObj = pjc.getJsonTestDataObject();
	}

	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before test");
		String url = "http://www.amazon.com/";
		dr.get(url);
		lp.pageRenderWait();
	}

	@BeforeMethod
	public void beforeMethod() 
	{
		System.out.println("Before Method");
	}



	@Test(priority = 0, enabled=true, description = "Open a browser with http://www.amazon.com/ url and validate Error for incorrect username Login !!")
	public void validateErrorForIncorrectUserName()
	{
		String userName =pjc.parseJsonTestData(jsonObj, "InvalidUserLogin", "username");

		lp.enterUserName(userName);
		if (lp.getInvalidUserErrorMsg().equals("We cannot find an account with that email address"))
		{
			System.out.println("Incorrect Username Error message is validated and is displayed correct");	
		}
		else
		{
			System.out.println("Incorrect Username Error message is not displayed");
		}
	}


	@Test(priority = 1, enabled=true, description = "Open a browser with http://www.amazon.com/ url and validate Error for incorrect Password Login !!")
	public void validateErrorForIncorrectPassword()
	{	
		String userName =pjc.parseJsonTestData(jsonObj, "InvalidPwdLogin", "username");
		String password =pjc.parseJsonTestData(jsonObj, "InvalidPwdLogin", "password");
		lp.getUserName().clear();
		lp.reEnterUserName(userName);
		lp.enterPassword(password);

		if (lp.getInvalidPwdErrorMsg().equals("Your password is incorrect"))
		{
			System.out.println("Incorrect Password Error message is validated and is correctly displayed");	
		}
		else
		{
			System.out.println("Incorrect Password Error message is not displayed");
		}
	}

	@Test(priority = 2, enabled=true, description = "Open a browser with http://www.amazon.com/ url and validate reenter correct Password Login !!")
	public void validateReenterCorrectPassword()
	{	
		String password =pjc.parseJsonTestData(jsonObj, "ValidLogin", "password");
		lp.enterPassword(password);

		if(lp.compareString(lp.getLoginAccountName(), lp.getLoginUserNameFromEmail()))
		{
			System.out.println("Logged in successfully by reentering the correct password");
		}
		else
		{
			System.out.println("Logged in failed even by reentering the correct password");
		}
	}

	@Test(priority = 3, enabled=true, description = "Open a browser with http://www.amazon.com/ url and validate Successful Login !!")
	public void validateSuccessfulLogin()
	{
		String userName =pjc.parseJsonTestData(jsonObj, "ValidLogin", "username");
		String password =pjc.parseJsonTestData(jsonObj, "ValidLogin", "password");

		if (lp.clickSignoutBtn() && lp.reLogin(userName, password))
		{
			System.out.println("Successfully logged in to Amazon");
		}
		else
		{
			System.out.println("Failed to login to Amazon");
		}
	}

}
