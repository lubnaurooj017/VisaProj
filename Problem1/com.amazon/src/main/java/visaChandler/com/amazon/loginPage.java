package visaChandler.com.amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.businessClass;


public class loginPage extends businessClass{
	
	public By  accountList = By.id("nav-link-accountList");
	public By signinBtn = By.className("nav-action-inner");
	public By userName = By.id("ap_email");
	public By conitnueBtn = By.id("continue");
	public By password =  By.id("ap_password");
	public By signInSubmitBtn = By.id("signInSubmit");
	public By loginAccountObj = By.xpath("//a[@id='nav-link-accountList']//span[@class='nav-line-1']");
	public By signOutBtn = By.xpath("//a[@id='nav-item-signout-sa']");
	public By invalidUserError = By.className("a-list-item");
	public By invalidPasswordError = By.className("a-list-item");



	Actions actions = new Actions(dr);

	public WebElement accountList()
	{
		return dr.findElement(accountList);
	}

	public WebElement getSigninBtn()
	{
		return dr.findElement(signinBtn);
	}

	public WebElement getUserName()
	{
		return dr.findElement(userName);
	}

	public WebElement getContinueBtn()
	{
		return dr.findElement(conitnueBtn);
	}

	public WebElement getPassword()
	{
		return dr.findElement(password);
	}

	public WebElement getSignInSubmitBtn()
	{
		return dr.findElement(signInSubmitBtn);
	}

	public WebElement getLoginAccountObj()
	{
		return dr.findElement(loginAccountObj);
	}

	public WebElement getInvalidUserError()
	{
		return dr.findElement(invalidUserError);
	}

	public WebElement getInvalidPwdError()
	{
		return dr.findElement(invalidPasswordError);
	}

	public WebElement getSignOutBtn()
	{
		return dr.findElement(signOutBtn);
	}
	
	

	public void  pageRenderWait()
	{
		dr.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		new WebDriverWait(dr, 2000).until(dr -> ((JavascriptExecutor) dr).executeScript("return document.readyState").equals("complete"));
	}

	public String getPageHeader()
	{
		return dr.getTitle();
	}
	
	public void enterUserName(String loginEmailId)
	{
		actions.moveToElement(accountList()).build().perform();

		WebDriverWait wait = new WebDriverWait(dr,60);
		wait.until(ExpectedConditions.elementToBeClickable(getSigninBtn()));

		getSigninBtn().click();
		getUserName().sendKeys(loginEmailId);
		getContinueBtn().click();
	}

	public void enterPassword(String loginPassword)
	{
		getPassword().sendKeys(loginPassword);
		getSignInSubmitBtn().click();
	}

	public void loginToAmazon(String loginEmailId, String loginPassword)
	{
		enterUserName(loginEmailId);
		enterPassword(loginPassword);
		getSignInSubmitBtn().click();
	}

	public boolean reLogin(String loginEmailId, String loginPassword)
	{
		getUserName().sendKeys(loginEmailId);
		getContinueBtn().click();
		getPassword().sendKeys(loginPassword);
		getSignInSubmitBtn().click();
		if (compareString(getLoginUserNameFromEmail(loginEmailId), getLoginAccountName()))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	public void reEnterUserName(String loginEmailId)
	{
		getUserName().sendKeys(loginEmailId);
		getContinueBtn().click();
	}

	public boolean validateLogin(String loginEmailId, String loginPassword)
	{	
		loginToAmazon(loginEmailId, loginPassword);
		if (compareString(getLoginUserNameFromEmail(loginEmailId), getLoginAccountName()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public String getInvalidUserErrorMsg()
	{
		return getInvalidUserError().getText();
	}

	public String getInvalidPwdErrorMsg()
	{
		return getInvalidPwdError().getText();
	}

	public String getLoginAccountName()
	{
		return getLoginAccountObj().getText();
	}

	public String getLoginUserNameFromEmail(String loginEmailId)
	{
		return "Hello, " + loginEmailId.split("@")[0];
	}

	public boolean compareString(String s1, String s2)
	{
		if(s1.equals(s2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean clickSignoutBtn()
	{
		actions.moveToElement(accountList()).build().perform();

		WebDriverWait wait = new WebDriverWait(dr,60);
		wait.until(ExpectedConditions.elementToBeClickable(getSignOutBtn()));	
		getSignOutBtn().click();
		if(getUserName().isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}


}
