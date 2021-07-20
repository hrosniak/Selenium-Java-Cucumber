package com.selenium.traning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{

    @FindBy(how = How.XPATH, using = "/html/body/app-root/div/div/ng-component/div/div/div/form/div[1]/input")
    WebElement userName;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/div/div/ng-component/div/div/div/form/div[2]/input")
    WebElement passwordFrame;

    @FindBy(how = How.XPATH, using = "/html/body/app-root/div/div/ng-component/div/div/div/form/div[5]/button[1]")
    WebElement loginButton;



    public void fillUserName(String email){
        userName.clear();
        userName.sendKeys(email);
    }

    public void fillPassword(String password){
        passwordFrame.clear();
        passwordFrame.sendKeys(password);
    }

    public void clickSignInButton() throws InterruptedException {
        Thread.sleep(1000);
        loginButton.click();
    }

    public void authenticate(String email, String password) throws InterruptedException {
        fillUserName(email);
        fillPassword(password);
        clickSignInButton();
    }
}



