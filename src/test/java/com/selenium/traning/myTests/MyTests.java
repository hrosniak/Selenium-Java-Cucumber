package com.selenium.traning.myTests;

import org.junit.Assert;
import org.junit.Test;

public class MyTests {

    public MyTests() {

        System.out.println("I am in my test!!!");
    }

    @Test
    public void myTestMethod() {
        System.out.println("I am in my test method right now!!!");

    }

    @Test
    public void mySecondTestMethod() {
        System.out.println("I am in my second test method right now!!!");
        String actualText = "This is actual text";
        String expectedText = "This is expected text";
        Assert.assertTrue("Expected text should be the same as actual: " + actualText + " but expected text is: " + expectedText, expectedText.equalsIgnoreCase(actualText));

    }
}
