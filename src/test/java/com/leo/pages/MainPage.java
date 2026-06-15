package com.leo.pages;

import com.leo.base.BasePage;
import com.leo.models.Product;
import com.leo.utils.WaitHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {

    //aplica wait;
    WaitHelper helper = new WaitHelper(driver);

    // Locators
    private By buscarField = By.cssSelector("input[placeholder*='Buscar por producto']");
    private By txtBlanco = By.xpath("//div[@class=\"newCategoriesChipsContainer\"]//div[contains(text(), 'Blanco')]");
    private By ordenarDropDown = By.cssSelector("#sortby");
    private By menorPrecio = By.xpath("//button[normalize-space()='Menor precio']");
    private By productCards = By.cssSelector("li.m-product__card");
    private By productName = By.cssSelector("h3.a-card-description");
    private By productPrice = By.cssSelector("p.a-card-discount");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void buscarProducto(String producto){
        helper.waitForVisibility(buscarField);
        List<WebElement> inputs = driver.findElements(buscarField);

        for(WebElement input : inputs){

            if(input.isDisplayed()){

                input.sendKeys(producto, Keys.ENTER);
                return;
            }
        }
        throw new NoSuchElementException("No se encontró un buscador visible.");
    }

    public void seleccionarColor(String color){
        helper.waitForVisibility(txtBlanco);
        driver.findElement(txtBlanco).click();
    }

    public void ordenarPorPrecio() throws InterruptedException {
        findVisible(ordenarDropDown).click();
        findVisible(menorPrecio).click();
        Thread.sleep(4000);
        System.out.println(driver.getCurrentUrl());

        System.out.println(driver.getTitle());

        System.out.println(
                driver.findElements(By.cssSelector("li[data-prodid]")).size()
        );

        System.out.println(
                driver.findElements(By.cssSelector("li.m-product__card")).size()
        );

        System.out.println(
                driver.findElements(By.cssSelector("h3.a-card-description")).size()
        );
    }



    public List<Product> obtenerPrimerosCincoProductos(){

        List<Product> products = new ArrayList<>();

        List<WebElement> cards = driver.findElements(productCards);

        for(WebElement card : cards){

            String nombre = card.findElement(productName).getText();
            String precioTexto = card
                    .findElement(productPrice)
                    .getText();

            Integer precio = Integer.valueOf(
                    precioTexto
                            .replace("$", "")
                            .replace(",", "")
                            .replace(".00", "")
                            .trim()

            );


            products.add(new Product(nombre, precio));

            if(products.size() == 5){
                break;
            }
        }
        System.out.println("Cards encontradas: "
                + cards.size());
        return products;
    }
}