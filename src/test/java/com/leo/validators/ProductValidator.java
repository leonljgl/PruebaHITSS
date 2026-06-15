package com.leo.validators;

import com.leo.models.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.text.Normalizer.normalize;

public class ProductValidator {

    public int validate(List<Product> uiProducts,
                        List<Product> apiProducts){

        int matches = 0;

        for(Product ui : uiProducts){

            for(Product api : apiProducts){

                if(normalize(api.getName())
                        .equals(normalize(ui.getName()))){

                    matches++;

                    if(!ui.getPrice().equals(api.getPrice())){

                        System.out.println(
                                "⚠️ Precio diferente para "
                                        + ui.getName()
                        );

                    }

                    break;

                }

            }

        }

        return matches;

    }

    private String normalize(String text){

        return text.toLowerCase()
                .replace("playstation", "")
                .replace("sony", "")
                .replaceAll("\\s+", " ")
                .trim();
    }

}