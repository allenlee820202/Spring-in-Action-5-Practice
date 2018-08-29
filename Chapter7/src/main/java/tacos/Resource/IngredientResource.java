package tacos.Resource;

import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import tacos.data.Ingredient;

public class IngredientResource extends ResourceSupport {
    @Getter
    private final String ingredientid;

    @Getter
    private final String name;

    @Getter
    private final Type type;

    @Getter
    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

    public IngredientResource(Ingredient ingredient) {
        this.ingredientid = ingredient.getIngredientid();
        this.name = ingredient.getName();
        this.type = Type.CHEESE;
    }
}
