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
import utils.TestContextSetup;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class LandingPageStepDefination {
    WebDriver driver;
    String LandingPageProductName;
    String offerPageProductName;
    LandingPage landingPage;
    TestContextSetup testContextSetup;

    public LandingPageStepDefination(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("User is on Green Landing page")
    public void user_is_on_green_landing_page() throws IOException {
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));

    }

    @When("^user searched with Shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {

        landingPage.searchItems(shortName);
        Thread.sleep(2000);
        testContextSetup.LandingPageproductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.LandingPageproductName + " is the extracted from Home Page");
    }

    @When("And Added {string} items of the selected product to cart")
    public void and_added_items_of_the_selected_product_to_cart(String quantity){

        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();

    }


}
