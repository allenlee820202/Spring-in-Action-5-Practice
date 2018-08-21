package tacos.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TacoRepository extends CrudRepository<Taco, Long> {
    Taco save(Taco design);
    Iterable<Taco> findAll();
    Optional<Taco> findById(Long id);
    Page<Taco> findAll(Pageable page);
}
