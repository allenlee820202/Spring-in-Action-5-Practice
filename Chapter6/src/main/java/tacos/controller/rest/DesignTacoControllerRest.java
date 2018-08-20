package tacos.controller.rest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import tacos.data.Taco;
import tacos.data.TacoRepository;
import tacos.resource.TacoResource;
import tacos.resource.assembler.TacoResourceAssembler;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path="/design",
        produces="application/json")
public class DesignTacoControllerRest {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(DesignTacoControllerRest.class);

    private TacoRepository tacoRepository;

    @Autowired
    public DesignTacoControllerRest (TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping("/recent")
    public Resources<TacoResource> recentTacos() {
        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        Iterable<Taco> tacos = tacoRepository.findAll();

        List<TacoResource> tacoResources = new TacoResourceAssembler().toResources(tacos);
        Resources<TacoResource> recentResources = new Resources<>(tacoResources);

        recentResources.add(
                ControllerLinkBuilder.linkTo(
                        ControllerLinkBuilder.methodOn(DesignTacoControllerRest.class)
                        .recentTacos())
                        .withRel("recent"));

        return recentResources;
    }

    @GetMapping("/{id}")
    public Taco tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRepository.findById(id);
        if (optTaco.isPresent()) {
            return optTaco.get();
        } else {
            return null;
        }
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepository.save(taco);
    }


}
