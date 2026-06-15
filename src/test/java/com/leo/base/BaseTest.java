package com.leo.base;
import com.leo.driver.DriverFactory;
import com.leo.listeners.TestListener;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
@Listeners(TestListener.class)
public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void iniciaDriver() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.liverpool.com.mx/tienda/home");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(src, new File("home.png"));
    }

    @AfterMethod
    public void finalizaDriver() {
        driver.quit();
    }
}