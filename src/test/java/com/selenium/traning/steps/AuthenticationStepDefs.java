package com.selenium.traning.steps;

import com.selenium.traning.pages.GooglePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class AuthenticationStepDefs {

    GooglePage googlePage = new GooglePage();

    @Given("Home page is opened")
    public void homePageIsOpened() {
        googlePage.openGooglePage();
    }

    @When("I close cookie frame")
        public void cookieFrameIsClosed(){
        googlePage.closeFrame();
    }


    @Then("Login Page is opened")
    public void loginPageIsOpened() {
        googlePage.openLoginPage();
    }

    @And("I click Sign button")
    public void iClickSignButton() throws InterruptedException {
        Thread.sleep(1000);
        googlePage.iClickNextButton();
    }



    @And("I fill email address field {string}")
    public void iFillEmailAddressField(String emailAddress) {
        googlePage.iClickAndSetLoginForGoogleAccount(emailAddress);
    }

    @And("I fill password field {string}")
    public void iFillPasswordField(String password) {
        googlePage.iClickAndSetPasswordForGoogleAccount(password);
    }


    @Then("I can see error message {string}")
    public void iCanSeeErrorMessage(String errorMessage) {
        String visibleMessage = googlePage.getErrorMessage();
        assertThat("Error message should be displayed", googlePage.errorMessage());
        assertThat("Error message should be as expected", visibleMessage.contains(errorMessage));
    }




    @When("I authenticate using credentials")
    public void iAuthenticateUsingCredentials(DataTable credentials) throws InterruptedException {
        List<String> userCredentials = credentials.row(1);
        String addressEmail = userCredentials.get(0);
        String password = userCredentials.get(1);
        googlePage.authenticate(addressEmail, password);
    }

    @Then("I can see My Account Page")
    public void iCanSeeMyAccountPage() throws InterruptedException {
        Thread.sleep(2000);
    }


}
