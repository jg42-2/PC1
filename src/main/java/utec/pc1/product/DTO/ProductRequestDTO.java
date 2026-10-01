package utec.pc1.product.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
   private String name;

    @DecimalMin(value = "0.1")
    private BigDecimal price;

    @Min(value = 0)
    private Integer stock;

}
