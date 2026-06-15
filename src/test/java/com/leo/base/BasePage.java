package com.leo.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.leo.utils.WaitHelper;

import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WaitHelper wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver);
    }

    protected WebElement find(By locator) {
        return wait.waitForVisibility(locator);
    }


    protected void click(By locator) {
        wait.waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {
        find(locator).sendKeys(text);
    }

    protected WebElement findVisible(By locator){

        List<WebElement> elements = driver.findElements(locator);

        for(WebElement element : elements){

            if(element.isDisplayed()){
                return element;
            }
        }

        throw new NoSuchElementException("No se encontró un elemento visible.");
    }
}