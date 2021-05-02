package com.selenium.traning;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Drivers {

    public static RemoteWebDriver DRIVER;

// Tutaj pobieramy nazwe przeglądarki jaką będziemy wykorzystywać
    private static String getDriverName(){
        String browserName = System.getProperty("browser", "chrome");
        return browserName;
    }


// Tutaj dodajemy nasze przeglądarki które obsługujemy
    public static void startDriver(){
        switch (getDriverName().toLowerCase()){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\huber\\Desktop\\Testy, programy itp\\Selenium\\drivers\\chromedriver.exe");
                DRIVER = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\huber\\Desktop\\Testy, programy itp\\Selenium\\drivers\\geckodriver.exe");
                DRIVER = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.msedge.driver", "C:\\Users\\huber\\Desktop\\Testy, programy itp\\Selenium\\drivers\\msedgedriver.exe");
                DRIVER = new EdgeDriver();
                break;
            default:
                throw new IllegalStateException("Unsupported driver - cannot start browser");
        }

// Metoda która pozwala nam otworzyć drivera w full screen
            DRIVER.manage().window().maximize();
    }

// Metoda która zamyka drivera
            public static void destroyDriver(){
                DRIVER.quit();
            }

// Wykonujemy screenshota
            private static void embedScreenshot(Scenario scenario){
                byte[] screenshot = DRIVER.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            }

// Zapisujemy screenshota
            private static void saveScreenshotFile(Scenario scenario) throws IOException {
                File srcFile = ((TakesScreenshot) DRIVER).getScreenshotAs(OutputType.FILE);
                String currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
                FileUtils.copyFile(srcFile, new File(currentPath + "/screenshots/" + scenario.getName() + ".png"));

            }

    // Sprawdzamy status scenariusza jeżeli poprawny nie robimy screenshota jeżeli błąd wykonujemy scenariusz
    public static void processExecutedScenario(Scenario scenario) throws IOException {
        if(scenario.isFailed() && DRIVER != null){
            embedScreenshot(scenario);
            saveScreenshotFile(scenario);
        }
        destroyDriver();
    }


}
