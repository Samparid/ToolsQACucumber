package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

public class LandingPage {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    private By search = By.xpath("//input[@type = 'search']");
    private By productSearch = By.xpath("//h4[@class='product-name']");

    By topDeals = By.xpath("//a[normalize-space()='Top Deals']");
    By increment = By.cssSelector("a.increment");
    By addToCart = By.cssSelector(".product-action button");


    public void searchItems(String name) {
        driver.findElement(search).sendKeys(name);
    }

    public String getSearchText() {
        return driver.findElement(search).getText();
    }

    public String getProductName() {
        return driver.findElement(productSearch).getText();
    }

    public void selectTopDealsPage() {
        driver.findElement(topDeals).click();
    }

    public String getTitleLandingPage(){
        return driver.getTitle();
    }

    public void incrementQuantity(int Quantity){
        int i = Quantity-1;
        while (i>0){
            driver.findElement(increment).click();
            i--;
        }
    }

    public void addToCart(){
        driver.findElement(addToCart).click();
    }
}
