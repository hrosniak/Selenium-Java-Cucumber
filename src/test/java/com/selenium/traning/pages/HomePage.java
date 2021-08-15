package com.selenium.traning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;


public class HomePage extends BasePage{
    private static String HOMEPAGE_URL = "https://www.gamivo.com/";


    @FindBy(how = How.XPATH, using = "/html/body/app-root/div/app-header/div/div[1]/div[1]/div[1]/h1/a/img[1]")
    WebElement picturesOnPage;

    @FindBy(how = How.ID, using = "onesignal-slidedown-cancel-button")
    WebElement cancel;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/div/div/app-home/section/app-home-games/section/div/app-games-gallery[3]/div/div/div[2]/div[1]/div/div[7]/a/app-home-game/div/div/div[1]/app-icon-button")
    WebElement seventhProductFromPopular;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/div/div/app-product/div[2]/div[3]/div[1]/div/div/div[1]/app-offers-table/div/table/tbody/tr[1]/td[5]/app-buy-now-button/button/span")
    WebElement firstOfferFromPage;

    @FindBy(how = How.XPATH, using = "/html/body/modal-container/div/div/app-added-to-cart-modal/div/div[2]/div[2]/div[1]/div/a")
    WebElement normalPrice;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/div/app-header/div/div[1]/div[2]/div[2]/div/div/app-cart/div/div[1]/a")
    WebElement goToCart;

    @FindBy(how = How.CLASS_NAME, using = "cart-icon")
    WebElement goToCartTwo;

    @FindBy(how = How.XPATH, using = "//html/body/app-root/div/div/ng-component/div/div/div[2]/div[1]/div/div/table/tbody/tr[1]/td[5]/div/button[2]/i")
    WebElement  addMore;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/div/div/ng-component/div/div/div[2]/div[1]/div/div/table/tbody/tr[1]/td[5]/div/button[2]/i")
    WebElement addMoreTwo;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/div/div/ng-component/div/div/div[2]/div[3]/div[1]/form/div[1]/div[2]")
    WebElement coupon;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/div/div/ng-component/div/div/div[2]/div[3]/div[1]/form/div[2]/input")
    WebElement addCoupon;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/div/div/ng-component/div/div/div[2]/div[3]/div[1]/form/div[2]/button")
    WebElement applyButton;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/div/div/ng-component/div/div/div[2]/div[3]/div[1]/form/div[2]")
    WebElement errorMessage;

    public void openHomePage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(picturesOnPage));
    }

    public void cancelNotification() throws InterruptedException {
        Thread.sleep(500);
        cancel.click();
    }

    public void switchToNextPopularGame(){
        Actions actions = new Actions(driver);
        actions.moveToElement(seventhProductFromPopular);
        actions.perform();
    }

    public void seventhProduct() throws InterruptedException {
        seventhProductFromPopular.click();
        Thread.sleep(1000);
    }

    public void firstOfferOnPage() throws InterruptedException{
        firstOfferFromPage.click();
        Thread.sleep(1000);
    }

    public void normalPriceOnPage() throws InterruptedException{
        normalPrice.click();
        Thread.sleep(1000);
    }

    public void switchToCart() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(goToCart).build().perform();
        Thread.sleep(1000);
        goToCartTwo.click();
        Thread.sleep(1000);
    }

    public void addToThree() throws InterruptedException {
        addMore.click();
        addMoreTwo.click();
        Thread.sleep(1000);
    }

    public void addCoupon() throws InterruptedException {
        coupon.click();
        addCoupon.sendKeys("BASKET-SMART");
        Thread.sleep(1000);

    }

    public void applyCouponButton(){
        applyButton.click();
    }

    public void getErrorMessage() throws InterruptedException{
        errorMessage.getText();
        assertTrue("The message is visibility", errorMessage.isDisplayed());
        Thread.sleep(3000);
    }



}
