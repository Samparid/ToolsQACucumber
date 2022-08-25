package stepDefinations;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageDefination {

    CheckoutPage checkoutPage;
    TestContextSetup testContextSetup;

    public CheckoutPageDefination(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }



    @Then("Verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {

        Assert.assertTrue(checkoutPage.VerifyPromoBtn());
        Assert.assertTrue(checkoutPage.VerifyPlaceOrder());

    }

    @Then("^User proceed to Checkout and validate the (.+) items in checkout page$")
    public void user_proceed_to_checkout_and_validate_the_tom_items_in_checkout_page(String name) throws InterruptedException {
        checkoutPage.CheckoutItems();

    }


}
