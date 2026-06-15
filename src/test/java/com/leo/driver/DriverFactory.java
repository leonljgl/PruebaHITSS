package com.leo.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {

        WebDriver driver;

        switch (browser.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                //driver = new ChromeDriver();
                ChromeOptions options = new ChromeOptions();

                if(Boolean.parseBoolean(System.getProperty("headless","false"))){

                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");

                }

                driver = new ChromeDriver(options);
                break;

            default:
                throw new IllegalArgumentException("Browser no soportado");
        }

        driver.manage().window().maximize();

        return driver;
    }
}