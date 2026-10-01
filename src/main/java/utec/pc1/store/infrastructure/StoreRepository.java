package utec.pc1.store.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import utec.pc1.store.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
