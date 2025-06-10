package Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoEntitdade {

    @Id
    @Generated
    private Long id;

    @NotBlank
    private String nome;

    @Positive
    private BigDecimal preco;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;
}
