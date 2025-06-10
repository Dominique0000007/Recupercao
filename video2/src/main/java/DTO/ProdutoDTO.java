package DTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ProdutoDTO {

	// DTO
		@Data
		@AllArgsConstructor
		@NoArgsConstructor
		public class ProdutoDTO1 {
		    private Long id;
		    private String nome;
		    private BigDecimal preco;
		}

		public String getNome1() {
			// TODO Auto-generated method stub
			return null;
		}

		public Double getPreco() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getNome() {
			// TODO Auto-generated method stub
			return null;
		}

}
