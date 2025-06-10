package Repository;

package Video1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Video1.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
