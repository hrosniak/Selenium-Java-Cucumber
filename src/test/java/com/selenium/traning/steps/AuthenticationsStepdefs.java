package com.selenium.traning.steps;

import com.selenium.traning.pages.HomePage;
import com.selenium.traning.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

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


    @And("I fill email address field {string}")
    public void iFillEmailAddressField(String emailAddress) {
        loginPage.fillEmailAddressField(emailAddress);
    }


    @And("I fill password field {string}")
    public void iFillPasswordField(String password) {
        loginPage.feelPasswordField(password);
    }


    @Then("I can see error message {string}")
    public void iCanSeeErrorMessage(String errorMessage) {
        String visibleMessage = loginPage.getErrorMessage();
        assertThat("Error message should be displayed", loginPage.errorMessage());
        assertThat("Error message should be as expected", visibleMessage.contains(errorMessage));
    }

    @Then("Login Page is opened")
    public void loginPageIsOpened() {
        loginPage.verifyLoginPageIsOpened();
    }


    @When("I authenticate using credentials")
    public void iAuthenticateUsingCredentials(DataTable credentials) throws InterruptedException {
       List<String> userCredentials = credentials.row(1);
        String addressEmail = userCredentials.get(0);
        String password = userCredentials.get(1);
        loginPage.authenticate(addressEmail, password);
    }

    @Then("I can see My Account Page")
    public void iCanSeeMyAccountPage() throws InterruptedException {
        Thread.sleep(2000);
    }
}

