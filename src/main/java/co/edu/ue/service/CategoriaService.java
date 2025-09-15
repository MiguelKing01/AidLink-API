package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.ICategoriaDao;
import co.edu.ue.entity.Categoria;

@Service
public class CategoriaService implements ICategoriaService{

    @Autowired
    ICategoriaDao dao;

    @Override
    public List<Categoria> listaCompleta(){
        return dao.listaCompleta();
    }

    @Override
    public List<Categoria> GuardarCategoria(Categoria categoria){
        dao.GuardarCategoria(categoria);
        return listaCompleta();
    }

    @Override
    public Categoria ActualizarCategoria(Categoria categoria){
        Categoria existente = BuscarID(categoria.getId_Categoria());
        if(existente != null){
            return dao.ActualizarCategoria(categoria);
        }

        return null;
    }

    @Override
    public Categoria BuscarID(int id_Categoria){
        return dao.BuscarID(id_Categoria);
    }
    
}
