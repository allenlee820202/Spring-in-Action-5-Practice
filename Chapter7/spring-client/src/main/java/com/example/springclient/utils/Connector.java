package com.example.springclient.utils;

import com.example.springclient.data.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class Connector {

    private static final Logger logger = LoggerFactory.getLogger(Connector.class);

    private RestTemplate restTemplate = new RestTemplate();

    private String INGREDIENT_URL = "https://localhost:8443/api/ingredients/{id}";

    public Connector() {
        turnOffSslChecking();
    }

    private void turnOffSslChecking() {
        try {
            SSLUtil.turnOffSslChecking();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Ingredient getIngredientByIdStyle1(String ingredientId) {
        return restTemplate.
                getForObject(INGREDIENT_URL,
                        Ingredient.class,
                        ingredientId);
    }

    public Ingredient getIngredientByIdStyle2(String ingredientId) {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", ingredientId);
        return restTemplate.
                getForObject(INGREDIENT_URL,
                        Ingredient.class,
                        urlVariables);
    }

    public Ingredient getIngredientByIdStyle3(String ingredientId) {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", ingredientId);
        URI url = UriComponentsBuilder
                .fromHttpUrl(INGREDIENT_URL).
                        build(urlVariables);
        return restTemplate.getForObject(url, Ingredient.class);
    }

    public Ingredient getIngredientById(String ingredientId) {
        ResponseEntity<Ingredient> responseEntity =
            restTemplate.getForEntity(INGREDIENT_URL,
                    Ingredient.class,
                    ingredientId);
        logger.info("Fetched time: " + responseEntity.getHeaders().getDate());
        return responseEntity.getBody();
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return restTemplate.postForObject("https://localhost:8443/api/ingredients/create",
                ingredient,
                Ingredient.class);
    }


}
