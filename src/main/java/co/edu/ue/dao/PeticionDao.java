package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Peticion;
import co.edu.ue.entity.Usuario;
import co.edu.ue.jpa.IPeticionJPA;

@Repository
public class PeticionDao implements IPeticionDao{

    @Autowired
    IPeticionJPA jpa;

    @Override
    public List<Peticion> GuardarPeticion(Peticion peticion){
        jpa.save(peticion);
        return listaCompleta();
    }

    @Override
    public Peticion ActualizarPeticion (Peticion peticion){
        return jpa.save(peticion);
    }

    @Override
    public List<Peticion> listaCompleta(){
        return jpa.findAll();
    }

    @Override
    public Peticion BuscarID (int id_Peticion){
        return jpa.findById(id_Peticion).orElse(null);
    }

    @Override
    public List<Peticion> BuscarUsuarioID (Usuario usuarioId){
        return jpa.findByUsuario(usuarioId);
    }
    
}
