package co.edu.ue.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Donacion;
import co.edu.ue.entity.Envio;
import co.edu.ue.entity.Estado;
import co.edu.ue.entity.Peticion;

public interface IEnvioJPA extends JpaRepository<Envio, Integer>{
    
    List<Envio> findByPeticionId(Peticion peticionId);
    List<Envio> findByDonacionId(Donacion peticion);
    List<Envio> findByEstadoId(Estado estadoId);
}
