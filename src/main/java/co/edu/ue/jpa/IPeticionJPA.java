package co.edu.ue.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Peticion;
import co.edu.ue.entity.Usuario;


public interface IPeticionJPA extends JpaRepository<Peticion, Integer> {

    List<Peticion> findByUsuario(Usuario usuarioId);
    //FuncionaGitHub
}
