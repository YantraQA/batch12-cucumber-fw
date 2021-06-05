package com.yantraQA.stepdefs;

import com.yantraQA.core.TestContext;
import com.yantraQA.core.WebDriverFactory;
import com.yantraQA.pageobjects.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.List;
import java.util.Map;

@Log4j2
public class StepDefs2{// extends TestContext {

    TestContext testContext;
    public  WebDriver driver;
    public String base_url;
    public Scenario scn;
    public CmnPageObjects cmnPageObjects;
    public HomePageObjects homePageObjects;
    public SignInPageObjects signInPageObjects;
    public SearchPageObjects searchPageObjects;
    public ProductDescriptionPageObjects productDescriptionPageObjects;

    //Dependency Injections
    public StepDefs2(TestContext testContext){
        this.testContext = testContext;
        cmnPageObjects = testContext.cmnPageObjects;
        homePageObjects = testContext.homePageObjects;
        signInPageObjects = testContext.signInPageObjects;
        searchPageObjects = testContext.searchPageObjects;
        productDescriptionPageObjects = testContext.productDescriptionPageObjects;
        base_url = testContext.base_url;
    }

    @When("User click on any product")
    public void user_click_on_any_product() {
        searchPageObjects.ClickOnTheProductLink(0);//0 here means click on the first link
    }

    @Then("Product Description is displayed in new tab")
    public void product_description_is_displayed_in_new_tab() {
        WebDriverFactory.switchBrowserToTab();
        scn.log("Switched to the new window/tab");

        productDescriptionPageObjects.ValidateProductTileIsCorrectlyDisplayed();
        productDescriptionPageObjects.ValidateAddToCartButtonIsCorrectlyDisplayed();
    }

    @Then("User cart is updated with the products and quantity")
    public void user_cart_is_updated_with_the_products_and_quantity() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
        //This part is pending
        //Click on the cart button on top right
        //Check all the products with the right products and prices and quantity are added
        //Total is correct
    }

    @When("User enters minimum price as {string} and maximum price as {string} mentioned in below table")
    public void user_enters_minimum_price_as_and_maximum_price_as_mentioned_in_below_table(String min, String max) {
        searchPageObjects.FilterSearchResultByPrice(min,max);
    }

    @Then("Verify that Search results gets filtered with price range between {int} and {int}")
    public void search_results_gets_filtered_with_price_range_between_and(int min, int max) {
        searchPageObjects.VerifyThatSearchedProductsAreInPriceRange(min,max);
    }

}
