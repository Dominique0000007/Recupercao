package Controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.management.ObjectName;
import javax.swing.text.html.ObjectView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import DTO.ProdutoDTO;
import Repository.ProdutoRepository;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private static final Long ID = null;
	@Autowired
    private ProdutoRepository produtoRepository;
	private java.lang.Object produtosDTO;

    @GetMapping
    public void listar() {
    	
 
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarPorID() {


        ProdutoDTO dto = new ProdutoDTO();
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criar(@Valid @RequestBody ProdutoDTO produtoDTO) {
        ProdutoEntidade produto = new ProdutoEntidade();
        produto.setNome(produtoDTO.getNome());
        produto.setPreco(produtoDTO.getPreco());

        ProdutoEntidade salvo = produtoRepository.save(produto);
        ProdutoDTO dto = new ProdutoDTO();
		return null;
        
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
        }
    }