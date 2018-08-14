package tacos.data;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Order save(Order order);
    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
