package com.selenium.traning.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


// extends BasePage zaciąga jaki driver ma się uruchomić oraz czego szukamy np. name, id
public class GooglePage extends BasePage {

    private static String GOOGLE_URL = "https://www.google.com/";

    @FindBy(how = How.ID, using = "zV9nZe")
    WebElement agreeButton;

    @FindBy(how = How.NAME, using = "q")
    WebElement searchField;

    @FindBy(how = How.ID, using = "rcnt")
    WebElement resultPart;

    public void openGooglePage() {
        driver.get(GOOGLE_URL);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(searchField));
    }

    public void closeFrame() {
        driver.findElement(By.id("zV9nZe"));
        agreeButton.click();
    }

    public void searchInGoogle(String searchPhrase){
        searchField.sendKeys(searchPhrase);
        searchField.sendKeys(Keys.ENTER);
    }

    public void verifyIfResultsAreVisible() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(resultPart));
    }

}



