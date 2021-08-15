package com.selenium.traning.steps;

import com.selenium.traning.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Steps {
    HomePage homePage = new HomePage();



    @Given("Home page is opened")
    public void homePageIsOpened() throws InterruptedException{
        homePage.openHomePage();
        homePage.cancelNotification();
    }


    @When("I choose seventh product from popular")
    public void iChooseSeventhProductFromPopular() throws InterruptedException{
        homePage.switchToNextPopularGame();
        Thread.sleep(1000);
    }

    @And("I going to product page")
    public void iGoingToProductPage() throws InterruptedException{
        homePage.seventhProduct();
        Thread.sleep(1000);
    }

    @And("I choose first offer from list and add product to cart")
    public void iChooseFirstOfferFromListAndAddProductToCart() throws InterruptedException {
        homePage.firstOfferOnPage();
    }

    @And("I choose price without SMART service")
    public void iChoosePriceWithoutSMARTService() throws InterruptedException{
        homePage.normalPriceOnPage();
    }

    @And("I switch to cart")
    public void iSwitchToCart() throws InterruptedException {
        homePage.switchToCart();

    }

    @And("I increase number of products to three")
    public void iIncreaseNumberOfProductsToThree() throws InterruptedException{
        homePage.addToThree();
        Thread.sleep(5000);
    }

    @And("Add random coupon")
    public void addRandomCoupon() throws InterruptedException {
        homePage.addCoupon();
        homePage.applyCouponButton();
    }

    @Then("I see error message of coupon")
    public void iSeeErrorMessageOfCoupon() throws InterruptedException {
        homePage.getErrorMessage();

    }




}
