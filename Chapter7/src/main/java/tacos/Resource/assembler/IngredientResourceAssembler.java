package tacos.Resource.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import tacos.Resource.IngredientResource;
import tacos.data.Ingredient;
import tacos.repositoryRestController.CreateIngredientController;

public class IngredientResourceAssembler extends ResourceAssemblerSupport<Ingredient, IngredientResource> {

    public IngredientResourceAssembler() {
        super(CreateIngredientController.class, IngredientResource.class);
    }

    @Override
    protected IngredientResource instantiateResource(Ingredient ingredient) {
        return new IngredientResource(ingredient);
    }

    @Override
    public IngredientResource toResource(Ingredient ingredient) {
        return createResourceWithId(ingredient.getName(), ingredient);
    }
}
