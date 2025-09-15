package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Donacion;
import co.edu.ue.entity.Peticion;
import co.edu.ue.entity.Usuario;
import co.edu.ue.jpa.IDonacionJPA;

@Repository
public class DonacionDao implements IDonacionDao {

    @Autowired
    IDonacionJPA jpa;

    @Override
    public List<Donacion> listaCompleta() {
        return jpa.findAll();
    }

    @Override
    public List<Donacion> GuardarDonacion(Donacion donacion) {
        jpa.save(donacion);
        return listaCompleta();
    }

    @Override
    public Donacion ActualizarDonacion(Donacion donacion){
        return jpa.save(donacion);
    }

    @Override
    public Donacion BuscarID(int id_Donacion){
        return jpa.findById(id_Donacion).orElse(null);
    }

    @Override
    public List<Donacion> BuscarUsuarioID(Usuario usuarioId){
        return jpa.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Donacion> BuscarPeticionID(Peticion peticionId){
        return jpa.findByPeticionId(peticionId);
    }

}
