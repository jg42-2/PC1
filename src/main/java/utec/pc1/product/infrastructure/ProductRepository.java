package utec.pc1.product.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.pc1.product.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
