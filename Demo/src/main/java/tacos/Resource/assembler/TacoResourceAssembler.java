package tacos.Resource.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import tacos.Resource.TacoResource;
import tacos.data.Taco;
import tacos.repositoryRestController.RecentTacosController;

public class TacoResourceAssembler extends ResourceAssemblerSupport<Taco, TacoResource> {

    public TacoResourceAssembler() {
        super(RecentTacosController.class, TacoResource.class);
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
