package com.selenium.traning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    private static String HOMEPAGE_URL = "https://www.callofduty.com/pl/";

    @FindBy(how = How.CSS, using = "body > div.root.responsivegrid > div > div:nth-child(1) > section > div > div > div > div > header > div.desktop-header > div > div.cod-global-header-right > div.cod-login > div.logged-out > a.sso-login")
    WebElement topMenuSignInButton;

    @FindBy(how = How.CSS, using = "body > div.root.responsivegrid > div > div:nth-child(2) > section > div > div > div > div > div > div.tile-bgs > div.hero-tile-img.desktop-only")
    WebElement pictureOnPage;


    public void openHomePage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(pictureOnPage));
    }

    public void clickSignInButtonOnTopMenu() {
        topMenuSignInButton.click();
      //  new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOf(pictureOnPage));
    }


}
