package tacos.repositoryRestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import tacos.Resource.IngredientResource;
import tacos.Resource.assembler.IngredientResourceAssembler;
import tacos.data.Ingredient;
import tacos.data.IngredientRepository;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

@RepositoryRestController
@RequestMapping("/api/ingredients/create")
public class CreateIngredientController {

    private static final Logger logger = LoggerFactory.getLogger(CreateIngredientController.class);

    private IngredientRepository ingredientRepository;

    @Autowired
    public CreateIngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Resources<IngredientResource>> createIngredient(@RequestBody Ingredient ingredient) {
        logger.info("create ingredient: " + ingredient.toString());
        ingredientRepository.save(ingredient);
        List<Ingredient> ingredients = new ArrayList<>();
        List<IngredientResource> ingredientList = new IngredientResourceAssembler().toResources(ingredients);
        Resources<IngredientResource> ingredientResources = new Resources<>(ingredientList);
        ingredientResources.add(
                        linkTo(methodOn(CreateIngredientController.class).createIngredient(ingredient)).
                        withRel("created"));
        return new ResponseEntity<>(ingredientResources, HttpStatus.CREATED);
    }

    @Bean
    public ResourceProcessor<PagedResources<Resource<Ingredient>>> ingredientProcessor(EntityLinks links) {
        return new ResourceProcessor<PagedResources<Resource<Ingredient>>>() {
            @Override
            public PagedResources<Resource<Ingredient>> process(PagedResources<Resource<Ingredient>> resource) {
                resource.add(
                        links.linkFor(Ingredient.class)
                        .slash("create")
                        .withRel("created"));
                return resource;
            }
        };
    }


}
