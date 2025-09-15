package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Peticion;
import co.edu.ue.entity.Usuario;

public interface IPeticionService {
    List<Peticion> GuardarPeticion(Peticion peticion);
    Peticion ActualizarPeticion (Peticion peticion);
    List<Peticion> listaCompleta();
    Peticion BuscarID (int id_Peticion);
    List<Peticion> BuscarUsuarioID (Usuario usuarioId);    
}
