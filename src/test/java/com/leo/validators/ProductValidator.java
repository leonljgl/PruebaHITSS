package com.leo.validators;

import com.leo.models.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductValidator {

    public int validate(List<Product> uiProducts,
                        List<Product> apiProducts){

        int matches = 0;

        for(Product ui : uiProducts){

            boolean found = false;

            for(Product api : apiProducts){

                if(api.getName()
                        .toLowerCase()
                        .contains(ui.getName().toLowerCase())){

                    found = true;

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

            if(!found){

                System.out.println(
                        "❌ No encontrado: "
                                + ui.getName()
                );

            }

        }

        return matches;

    }

}