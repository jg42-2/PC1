package utec.pc1.foodOrder.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.pc1.foodOrder.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
}
