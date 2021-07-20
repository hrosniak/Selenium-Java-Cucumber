package com.selenium.traning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    private static String HOMEPAGE_URL = "https://www.gamivo.com/pl/";

    @FindBy(how = How.ID, using = "onesignal-slidedown-cancel-button")
    WebElement laterButton;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/div/app-header/div/div[1]/div[1]/div[1]/h1/a/img[1]")
    WebElement picturesOnPage;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/div/app-header/div/div[1]/div[2]/div[2]/div/div/div/a")
    WebElement loginButton;


    public void openHomePage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(picturesOnPage));
    }

    public void clickLaterButtonOnTop(){
        laterButton.click();
    }

    public void clickLoginButton(){
        loginButton.click();
    }

}
