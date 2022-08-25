package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By cartBag = By.xpath("//button[normalize-space()='ADD TO CART']");
    private By checkOutButton = By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']");

    private By clickOnBag = By.xpath("//img[@alt='Cart']");
    private By promoBtn = By.xpath("//button[normalize-space()='Apply']");
    private By placeOrder = By.xpath("//button[normalize-space()='Place Order']");

    public void CheckoutItems(){
        driver.findElement(cartBag).click();
        driver.findElement(clickOnBag).click();
        driver.findElement(checkOutButton).click();
    }

    public boolean VerifyPromoBtn(){
       return driver.findElement(promoBtn).isDisplayed();
    }

    public boolean VerifyPlaceOrder(){
        return driver.findElement(placeOrder).isDisplayed();
    }


}
