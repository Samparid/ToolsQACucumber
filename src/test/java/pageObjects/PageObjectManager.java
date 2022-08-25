package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;
    public LandingPage landingPage;
    public OffersPage offersPage;
    public CheckoutPage checkoutPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage getLandingPage() {
        landingPage = new LandingPage(driver);
        return landingPage;
    }

    public OffersPage OfferPage(){
        OffersPage offersPage = new OffersPage(driver);
        return offersPage;
    }

    public CheckoutPage getCheckoutPage(){
         checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }
}
