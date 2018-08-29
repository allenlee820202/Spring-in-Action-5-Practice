package com.example.springclient;

import com.example.springclient.data.Ingredient;
import com.example.springclient.utils.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleClient {

    private static final Logger logger = LoggerFactory.getLogger(SimpleClient.class);

    public static void main(String[] args) {
        Connector connector = new Connector();
        Ingredient ingredient = connector.getIngredientById("FLTO");
        logger.info(ingredient.toString());
        connector.createIngredient(new Ingredient("BLCS", "Blue cheese", Ingredient.Type.CHEESE));
    }
}
