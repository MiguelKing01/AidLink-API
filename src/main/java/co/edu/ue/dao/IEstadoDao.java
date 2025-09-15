package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Estado;

public interface IEstadoDao {
    List<Estado> GuardarEstado(Estado estado);
    Estado ActualizarEstado(Estado estado);
    List<Estado> listaCompleta();
    Estado BuscarID(int id_Estado);
    
}
