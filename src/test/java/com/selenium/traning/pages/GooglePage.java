package com.selenium.traning.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


// extends BasePage zaciąga jaki driver ma się uruchomić oraz czego szukamy np. name, id
public class GooglePage extends BasePage {

    private static String GOOGLE_URL = "https://www.google.com/";

    @FindBy(how = How.ID, using = "L2AGLb")
    WebElement agreeButton;

    @FindBy(how = How.NAME, using = "q")
    WebElement searchField;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[1]/div/div/div/div[2]/a")
    WebElement loginButton;

    @FindBy(how = How.ID, using = "identifierId")
    WebElement loginFrame;

    @FindBy(how = How.ID, using = "passwordNext")
    WebElement next;

    @FindBy(how = How.ID, using = "password")
    WebElement passwordFrame;

    @FindBy(how = How.XPATH, using = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]" )
    WebElement message;




    public void openGooglePage() {
        driver.get(GOOGLE_URL);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(searchField));
    }

    public void closeFrame() {
        agreeButton.click();
    }

    public void openLoginPage(){
        loginButton.click();
    }

    public void iClickAndSetLoginForGoogleAccount(String emailAddress){
        loginFrame.clear();
        loginFrame.sendKeys(emailAddress);
        loginFrame.sendKeys(Keys.ENTER);
    }

    public void iClickAndSetPasswordForGoogleAccount(String password) {
        passwordFrame.clear();
        passwordFrame.sendKeys(password);
    }

    public void iClickNextButton() throws InterruptedException {
        Thread.sleep(1000);
        next.click();
    }

    public Boolean errorMessage(){
        return message.isDisplayed();
    }

    public String getErrorMessage(){
        return message.getText();
    }

    public void authenticate(String email, String password) throws InterruptedException{
        iClickAndSetLoginForGoogleAccount(email);
        iClickAndSetPasswordForGoogleAccount(password);
        iClickNextButton();
    }


}



