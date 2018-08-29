package tacos;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import tacos.data.Ingredient;
import tacos.utils.SSLUtil;

import static org.junit.Assert.assertEquals;

public class RestTest {

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testIngredientGetById() {
        turnOffSslChecking();
        ResponseEntity<Ingredient> responseEntity = getIngredientById("FLTO");
        assert(responseEntity.getBody().getName().equals("Flour Tortilla"));
    }

    @Test
    public void testIngredientCreate() {
        turnOffSslChecking();

        ResponseEntity<Ingredient> ingredientResponseEntity = getIngredientById("BLCS");
        assertEquals(200, ingredientResponseEntity.getStatusCode().value());

        postIngredient(new Ingredient("BLCS", "Blue cheese", Ingredient.Type.CHEESE));

        ingredientResponseEntity = getIngredientById("BLCS");
        assertEquals("Blue cheese", ingredientResponseEntity.getBody().getName());
    }

    private ResponseEntity<Ingredient> getIngredientById(String ingredientId) {
        String ingredientUrl = "https://localhost:8443/api/ingredients/{id}";
        return restTemplate.getForEntity(ingredientUrl, Ingredient.class, ingredientId);
    }

    private void postIngredient(Ingredient ingredient) {
        restTemplate.postForObject("https://localhost:8443/api/ingredients/create",
                ingredient,
                Ingredient.class);
    }

    private void turnOffSslChecking() {
        try {
            SSLUtil.turnOffSslChecking();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
