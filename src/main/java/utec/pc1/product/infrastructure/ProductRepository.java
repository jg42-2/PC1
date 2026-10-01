package utec.pc1.product.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.pc1.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
