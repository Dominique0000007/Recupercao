package Entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class EntidadeProduto {

	@Entity
	public class Produto {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String nome;
	    private BigDecimal preco;
		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}
		/**
		 * @return the nome
		 */
		public String getNome() {
			return nome;
		}
		/**
		 * @param nome the nome to set
		 */
		public void setNome(String nome) {
			this.nome = nome;
		}
		/**
		 * @return the preco
		 */
		public BigDecimal getPreco() {
			return preco;
		}
		/**
		 * @param preco the preco to set
		 */
		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}
	   
	}
}
