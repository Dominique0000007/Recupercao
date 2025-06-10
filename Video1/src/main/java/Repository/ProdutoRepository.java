package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.EntidadeProduto.Produto;

//Repositório
	public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	}