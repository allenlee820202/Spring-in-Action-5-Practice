package tacos.data;

import org.springframework.data.domain.Pageable;
import tacos.User;

import java.util.List;

public interface OrderRepository {
    Order save(Order order);
    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
