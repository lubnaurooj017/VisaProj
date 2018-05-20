package amazonTest;

import org.testng.annotations.Test;

import java.util.HashMap;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utility.businessClass;
import utility.parseJsonClass;
import visaChandler.com.amazon.ProductPurchasePage;
import visaChandler.com.amazon.loginPage;

public class amazonTestCases extends businessClass{

	parseJsonClass pjc= new parseJsonClass();
	JSONObject jsonObj= null;
	HashMap<String,String> hashmapvar=new HashMap<String,String>(); 
	
	String browserUrl="";
	WebDriver dr = getDriver();
	loginPage lp = new loginPage();
	ProductPurchasePage pp = new ProductPurchasePage();
	
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
		//String url = "http://www.amazon.com/";
		dr.get(browserUrl);
		lp.pageRenderWait();
	}

	@BeforeMethod
	public void beforeMethod() 
	{
		System.out.println("Before Method");
	}

	
	@Test(priority = 0, enabled=true, description = "Launch “www.amazon.com” page and validate page header!!")
	public void validatePageHeader()
	{
		if(lp.compareString(lp.getPageHeader(), "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"))
		{
			System.out.println("The Page Header is displayed correctly");
		}
		else
		{
			System.out.println("The Page Header is not displayed correctly");
		}
	}
	

	@Test(priority = 1, enabled=true, description = "Click on login link and Provide incorrect username and validate error.!!")
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


	@Test(priority = 2, enabled=true, description = "Provide incorrect password and validate error.")
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

	@Test(priority = 3, enabled=true, description = "reenter the correct password !!")
	public void validateReenterCorrectPassword()
	{	
		String userName =pjc.parseJsonTestData(jsonObj, "ValidLogin", "username");
		String password =pjc.parseJsonTestData(jsonObj, "ValidLogin", "password");
		lp.enterPassword(password);

		if(lp.compareString(lp.getLoginAccountName(), lp.getLoginUserNameFromEmail(userName)))
		{
			System.out.println("Logged in successfully by reentering the correct password");
		}
		else
		{
			System.out.println("Logged in failed even by reentering the correct password");
		}
	}

	@Test(priority = 4, enabled=true, description = "Provide correct username/password and validate home page header.!!")
	public void validateSuccessfulLoginandPageHeader()
	{
		String userName =pjc.parseJsonTestData(jsonObj, "ValidLogin", "username");
		String password =pjc.parseJsonTestData(jsonObj, "ValidLogin", "password");

		if (lp.clickSignoutBtn() && lp.reLogin(userName, password))
		{
			System.out.println("Successfully logged in to Amazon");
			if(lp.compareString(lp.getPageHeader(), "Your Amazon.com"))
			{
				System.out.println("The Page Header after Login is displayed correctly");
			}
			else
			{
				System.out.println("The Page Header after Login is not displayed correctly");
			}
		}
		else
		{
			System.out.println("Failed to login to Amazon");
		}
	}
	
	@Test(priority = 5, enabled=true, description = "Search for iphone x 64 gb and click on 1st product and move to product page.!!")
	public void validateSearchAndAddFirstProduct()
	{
		String productName =pjc.parseJsonTestData(jsonObj, "ProductInfo", "ProductName");
		pp.enterItemToSearchTextBox(productName);
		pp.clickSearchBtn();
		pp.clickFirstProduct();
		//handleAlert(dr);
		if(pp.getaddtoCartBtn().isDisplayed())
		{
			System.out.println("The product : " + productName + " is searched and clicked on first product and moved to Product Page Successfully");
		}
		else
		{
			System.out.println("The product : " + productName + " is unable to be searched");
		}
	}
	
	@Test(priority = 6, enabled=true, description = "Capture product name and price and add 1 quantity to basket.!!")
	public void validateItemNameAndPriceAndAddtoCart()
	{
		String productName = pp.getProductName();
		String ProductPrice = pp.getproductPrice();
		hashmapvar.put("ProductName", productName);
		hashmapvar.put("ProductPrice", ProductPrice);
		pp.selectQuantity(1);
		pp.getaddtoCartBtn().click();
		if(pp.getproceedToCheckoutBtn().isDisplayed())
		{
			System.out.println("The product Name is : " + productName + " and the Product Price is : " + ProductPrice + " 1 Product is added to the Basket");
		}
		else
		{
			System.out.println("The product Name is : " + productName + " and the Product Price is : " + ProductPrice + " 1 Product is NOT added to the Basket");
		}
		
	}
	
	@Test(priority = 7, enabled=true, description = "Validate product is added into basket on product page !!")
	public void validateProductAddedtoCart()
	{
		
		if(pp.getproceedToCheckoutBtn().isDisplayed())
		{
			System.out.println("The product : " + hashmapvar.get("ProductName") + " is added to the Basket on Product Page");
		}
		else
		{
			System.out.println("The product : " + hashmapvar.get("ProductName") + " is NOT added to the Basket on Product Page");
		}
		
	}
	
	@Test(priority = 8, enabled=true, description = "Vaidate product price and name on basket page. !!")
	public void validateProductPriceAndNameInCart()
	{
		pp.getCart().click();
		String cartProductName = pp.getcartProductName();
		String cartProductPrice = pp.getcartProductPrice();
		
		if((cartProductName.equalsIgnoreCase(hashmapvar.get("ProductName"))) && (cartProductPrice.equalsIgnoreCase(hashmapvar.get("ProductPrice"))))
		{
			System.out.println("The product and Price for : " + hashmapvar.get("ProductName") + " is validated on Basket Page");
		}
		else
		{
			System.out.println("The product and Price for  : " + hashmapvar.get("ProductName") + " is NOT validated on Basket Page");
		}
	}
	
	
	@Test(priority = 9, enabled=true, description = "Logout and login again validate product in basket is present or not. !!")
	public void validateProductPresentAfterLogoutAndRelogin()
	{
		String userName =pjc.parseJsonTestData(jsonObj, "ValidLogin", "username");
		String password =pjc.parseJsonTestData(jsonObj, "ValidLogin", "password");
		
		
		if (lp.clickSignoutBtn() && lp.reLogin(userName, password))
		{
			pp.getCart().click();
			String cartProductName = pp.getcartProductName();
			String cartProductPrice = pp.getcartProductPrice();
			if((cartProductName.equalsIgnoreCase(hashmapvar.get("ProductName"))) && (cartProductPrice.equalsIgnoreCase(hashmapvar.get("ProductPrice"))))
			{
				System.out.println("The product and Price for : " + hashmapvar.get("ProductName") + " is Present in cart after Logout and Relogin");
			}
			else
			{
				System.out.println("The product and Price for  : " + hashmapvar.get("ProductName") + " is NOT Present in cart after Logout and Relogin");
			}
		}
		else
		{
			System.out.println("Either SignOut Or Relogin Failed");
		}
		
	}

}
