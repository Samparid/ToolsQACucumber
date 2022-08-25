package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

    WebDriver driver;
    public OffersPage(WebDriver driver){
        this.driver = driver;
    }

   private By search =By.xpath("//input[@type = 'search']");
   private By productSearch = By.xpath("//td[normalize-space() = 'Tomato']");

    public void searchItems(String name){
        driver.findElement(search).sendKeys(name);
    }

    public  String getProductName(){
        return driver.findElement(productSearch).getText();
    }
}
