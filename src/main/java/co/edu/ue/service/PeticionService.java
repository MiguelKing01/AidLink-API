package co.edu.ue.service;

import java.util.List;

import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IPeticionDao;
import co.edu.ue.entity.Peticion;
import co.edu.ue.entity.Usuario;

@Service
public class PeticionService implements IPeticionService{
    
    @Autowired
    IPeticionDao dao;

    @Override
    public List<Peticion> GuardarPeticion(Peticion peticion){
        return dao.GuardarPeticion(peticion);
    }

    @Override
    public List<Peticion> listaCompleta(){
        return dao.listaCompleta();
    }

    @Override
    public Peticion BuscarID (int id_Peticion){
        return dao.BuscarID(id_Peticion);
    }

    @Override
    public List<Peticion> BuscarUsuarioID (Usuario usuarioId){
        return dao.BuscarUsuarioID(usuarioId);
    }

    @Override
    public Peticion ActualizarPeticion (Peticion peticion){
        Peticion existente = BuscarID(peticion.getId_peticion());
        if(existente != null){
            return dao.ActualizarPeticion(peticion);
        }
        return null;
    }
}