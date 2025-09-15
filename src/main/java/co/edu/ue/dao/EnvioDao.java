package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Donacion;
import co.edu.ue.entity.Envio;
import co.edu.ue.entity.Estado;
import co.edu.ue.entity.Peticion;
import co.edu.ue.jpa.IEnvioJPA;

@Repository
public class EnvioDao implements IEnvioDao{

    @Autowired
    IEnvioJPA jpa;

    @Override
    public List<Envio> listaCompleta(){
        return jpa.findAll();
    }

    @Override
    public List<Envio> GuardarEnvio(Envio envio){
        jpa.save(envio);
        return listaCompleta();
    }

    @Override
    public Envio ActualizarEnvio(Envio envio){
        return jpa.save(envio);
    }

    @Override
    public Envio BuscarID(int id_Envio){
        return jpa.findById(id_Envio).orElse(null);
    }

    @Override
    public List<Envio> BuscarPeticionID(Peticion peticionId){
        return jpa.findByPeticionId(peticionId);
    }

    @Override
    public List<Envio> BuscarDonacionID(Donacion donacionId){
        return jpa.findByDonacionId(donacionId);
    }

    @Override
    public List<Envio> BuscarEstadoID(Estado estadoId){
        return jpa.findByEstadoId(estadoId);
    }
    
}
