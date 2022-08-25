package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefination {
    WebDriver driver;
    String offerPageProductName;
    TestContextSetup testContextSetup;


    public OfferPageStepDefination(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("^user search for (.+) shortname in offers page$")
    public void user_search_for_shortname_in_offers_page(String shortName) throws InterruptedException {
        //PageObjectManager pageObjectManager = new PageObjectManager(testContextSetup.driver);
        switchToOffersPage();
        OffersPage offersPage = testContextSetup.pageObjectManager.OfferPage();
        offersPage.searchItems(shortName);
        Thread.sleep(2000);
        offerPageProductName = offersPage.getProductName();

    }

    public void switchToOffersPage() {

        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        testContextSetup.genericUtils.SwitchWindowToChild();
    }

    @And("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        Assert.assertEquals(offerPageProductName, testContextSetup.LandingPageproductName);


    }
}
