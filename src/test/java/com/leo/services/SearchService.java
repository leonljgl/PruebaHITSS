package com.leo.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leo.models.Product;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class SearchService {

    public List<Product> search(String product)
            throws IOException, InterruptedException {

        String url =
                "https://www.liverpool.com.mx/getSearchFacadeService" +
                        "?s=" + product.replace(" ", "%20") +
                        "&path=PLP" +
                        "&deviceType=desktop" +
                        "&categoryName=undefined";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request,
                        HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(response.body());

        JsonNode records =
                root
                        .path("mainContent")
                        .path("records");

        List<Product> products = new ArrayList<>();

        for(JsonNode record : records){

            String name =
                    record.path("_t").asText();

            Integer price = parsePrice(

                    record
                            .path("allMeta")
                            .path("variants")
                            .get(0)
                            .path("prices")
                            .path("salePrice")
                            .asText()

            );

            products.add(
                    new Product(name, price)
            );

        }

        return products;
    }

    private Integer parsePrice(String value){

        return (int) Double.parseDouble(value);

    }
}