package com.selenium.traning.steps;

import com.selenium.traning.Drivers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;
// Definiuje co gdzie i kiedy wykonujemy

public class Hooks {

// Co mamy zrobić przed uruchomieniem scenariusza
    @Before
    public void beforeScenario(Scenario scenario){
        System.out.println("SCENARIO " + scenario.getName() + " STARTED");
        Drivers.startDriver();
    }

// Co mamy wykonać po wykonanym scenariuszu
    @After
    public void afterScenario(Scenario scenario) throws IOException {
        Drivers.processExecutedScenario(scenario);
    }
}
