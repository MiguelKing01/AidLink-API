package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.ue.entity.Usuario;

public interface IUsuarioJPA extends JpaRepository<Usuario, Integer> {
    Usuario findByCorreo(String correo);
}
