package tacos.data;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TacoRepository extends CrudRepository<Taco, Long> {
    Taco save(Taco design);
    Iterable<Taco> findAll();
    Optional<Taco> findById(Long id);
}
