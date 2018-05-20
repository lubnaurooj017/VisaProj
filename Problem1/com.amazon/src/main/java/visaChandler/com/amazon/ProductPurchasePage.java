package visaChandler.com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.businessClass;

public class ProductPurchasePage extends businessClass{
	
	public By searchTextBox = By.id("twotabsearchtextbox");
	public By goBtn = By.xpath("//div//input[@type='submit' and @value='Go']");
	public By firstProduct = By.xpath("//li[@id='result_0']//h2");
	public By productName = By.id("productTitle");
	public By productPrice = By.id("priceblock_ourprice");
	public By qty = By.id("quantity");
	
	public By addtoCartBtn = By.id("add-to-cart-button");
	public By proceedToCheckoutBtn = By.id("hlb-ptc-btn-native");
	public By cart = By.id("nav-cart");
	public By cartProductName = By.xpath("//a[@class='a-link-normal sc-product-link']//span[@class='a-size-medium sc-product-title a-text-bold']");
	public By cartProductPrice = By.xpath("//p[@class='a-spacing-small']//span[@class='a-size-medium a-color-price sc-price sc-white-space-nowrap sc-product-price sc-price-sign a-text-bold']");
	
	public WebElement getSearchTextBox()
	{
		return dr.findElement(searchTextBox);
	}
	
	public WebElement getgoBtn()
	{
		return dr.findElement(goBtn);
	}
	
	public WebElement getFirstProduct()
	{
		return dr.findElement(firstProduct);
	}
	
	public WebElement productName()
	{
		return dr.findElement(productName);
	}
	
	public WebElement productPrice()
	{
		return dr.findElement(productPrice);
	}
	
	public WebElement getqty()
	{
		return dr.findElement(qty);
	}
	
	public WebElement getaddtoCartBtn()
	{
		return dr.findElement(addtoCartBtn);
	}
	
	public WebElement getproceedToCheckoutBtn()
	{
		return dr.findElement(proceedToCheckoutBtn);
	}
	
	public WebElement getCart()
	{
		return dr.findElement(cart);
	}
	
	public WebElement cartProductName()
	{
		return dr.findElement(cartProductName);
	}
	
	public WebElement cartProductPrice()
	{
		return dr.findElement(cartProductPrice);
	}
	
	public void enterItemToSearchTextBox(String item)
	{
		getSearchTextBox().sendKeys(item);
	}
	
	public void clickSearchBtn()
	{
		getgoBtn().click();
	}
	
	public void clickFirstProduct()
	{	
		WebDriverWait wait = new WebDriverWait(dr,60);
		wait.until(ExpectedConditions.elementToBeClickable(getFirstProduct()));
		getFirstProduct().click();
	}
	
	public String getProductName()
	{
		return productName().getText();
	}
	
	public String getproductPrice()
	{
		return productPrice().getText();
	}
	
	public void selectQuantity(int qty)
	{
		getqty().click();
		WebElement addQty = dr.findElement(By.xpath("//select[@id ='quantity']//option[@value ="+qty+"]"));
		addQty.click();
	}
	
	public String getcartProductName()
	{
		return cartProductName().getText();
	}
	
	public String getcartProductPrice()
	{
		return cartProductPrice().getText();
	}
	
}