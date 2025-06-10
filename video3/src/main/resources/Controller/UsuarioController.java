package Controller;

import Video1.demo.model.Usuario;
import Video1.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

	import java.util.List;

	@RestController
	@RequestMapping("/usuarios")
	public class UsuarioController {

	    @Autowired
	    private UsuarioRepository repository;

	    @GetMapping
	    public List<Usuario> listarTodos() {
	        return repository.findAll();
	    }

	    @PostMapping
	    public Usuario criarUsuario(@RequestBody Usuario usuario) {
	        return repository.save(usuario);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
	        return repository.findById(id)
	                .map(usuario -> ResponseEntity.ok(usuario))
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
	        return repository.findById(id)
	                .map(usuario -> {
	                    usuario.setNome(usuarioAtualizado.getNome());
	                    usuario.setEmail(usuarioAtualizado.getEmail());
	                    Usuario atualizado = repository.save(usuario);
	                    return ResponseEntity.ok(atualizado);
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
	        return repository.findById(id)
	                .map(usuario -> {
	                    repository.deleteById(id);
	                    return ResponseEntity.ok().<Void>build();
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }
	}


}
