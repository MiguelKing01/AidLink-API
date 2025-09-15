package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Estado;
import co.edu.ue.jpa.IEstadoJPA;

@Repository
public class EstadoDao implements IEstadoDao{

    @Autowired
    IEstadoJPA jpa;

    @Override
    public List<Estado> listaCompleta(){
        return jpa.findAll();
    }

    @Override
    public List<Estado> GuardarEstado(Estado estado){
        jpa.save(estado);
        return listaCompleta();
    }

    @Override
    public Estado ActualizarEstado(Estado estado){
        return jpa.save(estado);
    }

    @Override
    public Estado BuscarID(int id_Estado){
        return jpa.getById(id_Estado);
    }
    
}
