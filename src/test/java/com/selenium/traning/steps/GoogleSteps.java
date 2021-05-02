package com.selenium.traning.steps;

import com.selenium.traning.pages.GooglePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// W tym miejscu łączymy wszystkie metody feature z google page
public class GoogleSteps {
    GooglePage googlePage = new GooglePage();

    @Given("Google Page is opened")
    public void googlePageIsOpened() {
        googlePage.openGooglePage();

    }

    @When("I close cookie Frame")
    public void iCloseCookieFrame() {
        googlePage.closeFrame();
    }

    @And("I search for phrase {string}")
    public void iSearchForPhrase(String searchPhrase) {
        googlePage.searchInGoogle(searchPhrase);
    }

    @Then("I can see search results")
    public void iCanSeeSearchResults() {
        googlePage.verifyIfResultsAreVisible();
    }



}
