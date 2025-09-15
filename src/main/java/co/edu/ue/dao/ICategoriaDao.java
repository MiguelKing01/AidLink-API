package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Categoria;

public interface ICategoriaDao{
    List<Categoria> GuardarCategoria(Categoria categoria);
    Categoria ActualizarCategoria(Categoria categoria);
    List<Categoria> listaCompleta();
    Categoria BuscarID(int id_Categoria);
}
