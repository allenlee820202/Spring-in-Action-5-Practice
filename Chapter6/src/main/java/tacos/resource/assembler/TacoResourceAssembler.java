package tacos.resource.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import tacos.controller.rest.DesignTacoControllerRest;
import tacos.data.Taco;
import tacos.resource.TacoResource;

public class TacoResourceAssembler extends ResourceAssemblerSupport<Taco, TacoResource> {

    public TacoResourceAssembler() {
        super(DesignTacoControllerRest.class, TacoResource.class);
    }

    @Override
    protected TacoResource instantiateResource(Taco taco) {
        return new TacoResource(taco);
    }

    @Override
    public TacoResource toResource(Taco taco) {
        return createResourceWithId(taco.getId(), taco);
    }
}
