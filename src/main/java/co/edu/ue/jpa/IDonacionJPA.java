package co.edu.ue.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Donacion;
import co.edu.ue.entity.Peticion;
import co.edu.ue.entity.Usuario;

public interface IDonacionJPA extends JpaRepository<Donacion, Integer>{
    List<Donacion> findByUsuarioId(Usuario usuarioId);
    List<Donacion> findByPeticionId(Peticion peticionId);
}
