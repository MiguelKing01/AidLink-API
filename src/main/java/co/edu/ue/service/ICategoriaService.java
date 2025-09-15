package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Categoria;

public interface ICategoriaService {
    
    List<Categoria> GuardarCategoria(Categoria categoria);
    Categoria ActualizarCategoria(Categoria categoria);
    List<Categoria> listaCompleta();
    Categoria BuscarID(int id_Categoria);
}
