package com.selenium.traning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {


    @FindBy(how = How.ID, using = "username")
    WebElement emailAddressFrame;

    @FindBy(how = How.ID, using = "password")
    WebElement passwordFrame;

    @FindBy(how = How.ID, using = "login-button")
    WebElement signInButton;

    @FindBy(how = How.ID, using = "password-error")
    WebElement errorMessage;

    @FindBy(how = How.ID, using = "login-button")
    WebElement needHelp;


    public void fillEmailAddressField(String email) {
        emailAddressFrame.clear();
        emailAddressFrame.sendKeys(email);
    }

    public void feelPasswordField(String password) {
        passwordFrame.clear();
        passwordFrame.sendKeys(password);
    }

    public void clickSignInButton() throws InterruptedException {
        Thread.sleep(1000);
        signInButton.click();
    }

    public Boolean errorMessage(){
        return errorMessage.isDisplayed();
    }

    public void verifyLoginPageIsOpened(){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(needHelp));
    }

}
