package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Estado;

public interface IEstadoService {
    
    List<Estado> GuardarEstado(Estado estado);
    Estado ActualizarEstado(Estado estado);
    List<Estado> listaCompleta();
    Estado BuscarID(int id_Estado);
}
