package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Categoria;
import co.edu.ue.jpa.ICategoriaJPA;

@Repository
public class CategoriaDao implements ICategoriaDao{
    
    @Autowired
    ICategoriaJPA jpa;

    @Override
    public List<Categoria> listaCompleta(){
        return jpa.findAll();
    }

    @Override
    public List<Categoria> GuardarCategoria(Categoria categoria){
        jpa.save(categoria);
        return listaCompleta();
    }

    @Override
    public Categoria ActualizarCategoria(Categoria categoria){
        return jpa.save(categoria);
    }

    @Override
    public Categoria BuscarID(int id_Categoria){
        return jpa.getById(id_Categoria);
    }


}
