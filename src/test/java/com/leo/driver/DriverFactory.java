package com.leo.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {

        WebDriver driver = null;

        switch (browser.toLowerCase()) {

            case "chrome":

                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();

                if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {

                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                }

                options.addArguments("--disable-blink-features=AutomationControlled");
                options.addArguments("--disable-infobars");
                options.addArguments("--start-maximized");

                options.addArguments(
                        "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                                "AppleWebKit/537.36 (KHTML, like Gecko) " +
                                "Chrome/137.0.0.0 Safari/537.36"
                );

                driver = new ChromeDriver(options);

                break;
        }
        return driver;    
    }
    
}