package tacos;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import tacos.data.*;
import tacos.data.Ingredient.Type;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);

    private IngredientRepository ingredientRepo;

    private TacoRepository tacoRepository;

    @Autowired
    public DesignTacoController(
            IngredientRepository ingredientRepo,
            TacoRepository tacoRepository) {
        this.ingredientRepo = ingredientRepo;
        this.tacoRepository = tacoRepository;
    }


	@GetMapping
	public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));


        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    ingredients.stream().
                            filter(ingredient -> ingredient.getType().equals(type)).collect(Collectors.toList()));
        }

        model.addAttribute("design", new Taco());
        return "design";
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @PostMapping
    public String processDesign(
            @Valid Taco design,
            Errors errors,
            @ModelAttribute Order order) {

        if (errors.hasErrors()) {
            System.out.println("error");
            return "redirect:/design";
        }

        log.info("Processing taco: " + design);
        Taco saved = tacoRepository.save(design);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }

}
