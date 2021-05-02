package com.selenium.traning.pages;

import com.selenium.traning.Drivers;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;


// W tym miejscu używamy naszego drivera
public abstract class BasePage {
    public RemoteWebDriver driver;

    public BasePage() {
        this.driver = Drivers.DRIVER;
        PageFactory.initElements(this.driver, this);
    }
}
