package com.leo.test;
import com.leo.base.BaseTest;
import com.leo.models.Product;
import com.leo.network.NetworkInterceptor;
import com.leo.pages.MainPage;
import com.leo.services.SearchService;
import com.leo.validators.ProductValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class MainPageTest extends BaseTest {

    @Test
    public void searchForPlayStation() throws InterruptedException, IOException {
        MainPage mp = new MainPage(driver);

        mp.buscarProducto("PlayStation 5");
        //mp.seleccionarColor("Blanco");
        //mp.ordenarPorPrecio();
        List<Product> productos =
                mp.obtenerPrimerosCincoProductos();

        for(Product producto : productos){

            System.out.println(producto);

        }

        SearchService service =
                new SearchService();

        List<Product> apiProducts =
                service.search("Playstation 5");

        List<Product> uiProducts =
                mp.obtenerPrimerosCincoProductos();

        ProductValidator validator =
                new ProductValidator();

        int matches =
                validator.validate(
                        uiProducts,
                        apiProducts);

        System.out.println("UI PRODUCTS");

        for(Product p : uiProducts){
            System.out.println(p);
        }

        System.out.println("----------------");

        System.out.println("API PRODUCTS");

        for(Product p : apiProducts){
            System.out.println(p);
        }

        Assert.assertTrue(

                matches >= 3,

                "Menos de 3 productos coinciden.");
    }
}