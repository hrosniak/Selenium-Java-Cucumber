package com.selenium.traning.steps;

import com.selenium.traning.pages.HomePage;
import com.selenium.traning.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;

public class AuthenticationsStepdefs {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("Home page is opened")
    public void homePageIsOpened() {
        homePage.openHomePage();
    }

    @When("I open login page")
    public void iOpenLoginPage() {
        homePage.clickSignInButtonOnTopMenu();
    }

    @And("I click Sign button")
    public void iClickSignButton() throws InterruptedException {
        loginPage.clickSignInButton();
    }

    @And("I fill email address field")
    public void iFillEmailAddressField() {
        loginPage.fillEmailAddressField("test");
    }

    @And("I fill password field")
    public void iFillPasswordField() {
        loginPage.feelPasswordField("test1");

    }

    @Then("I can see error message")
    public void iCanSeeErrorMessage() {
        assertThat("Error message should be displayed", loginPage.errorMessage());
    }


    @Then("Login Page is opened")
    public void loginPageIsOpened() {
        loginPage.verifyLoginPageIsOpened();
    }

}

