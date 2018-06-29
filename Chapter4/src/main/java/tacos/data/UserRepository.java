package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.User;

/**
 * JPA style repository. JAP automatically generates the repository implementation of this interface.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
