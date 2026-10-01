package utec.pc1.foodOrder.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utec.pc1.foodOrder.domain.status;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrderResponseDTO {
    private Long id;
    private Long productId;
    private String customerUsername;
    private Integer quantity;
    private BigDecimal totalAmount;
    private Enum<status> status;
}
