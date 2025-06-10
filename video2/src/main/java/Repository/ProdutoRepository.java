package Repository;

import java.util.List;

import Controller.ProdutoEntidade;
import DTO.ProdutoDTO;

public interface ProdutoRepository extends JpaRepository<ProdutoDTO, Long> {

	List findAll();

	boolean existsById(Long id);

	void deleteById(Long id);

	ProdutoEntidade save(ProdutoEntidade produto);

	Object findById(Long id);
	
}
