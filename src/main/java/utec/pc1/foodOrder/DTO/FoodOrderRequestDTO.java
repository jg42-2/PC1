package utec.pc1.foodOrder.DTO;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrderRequestDTO {
    private Long productId;

    @Min(value = 1)
    private Integer quantity;
}
