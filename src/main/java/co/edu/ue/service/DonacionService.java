package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IDonacionDao;
import co.edu.ue.entity.Donacion;
import co.edu.ue.entity.Peticion;
import co.edu.ue.entity.Usuario;

@Service
public class DonacionService implements IDonacionService {

    @Autowired
    IDonacionDao dao;

    @Override
    public List<Donacion> listaCompleta() {
        return dao.listaCompleta();
    }

    @Override
    public List<Donacion> GuardarDonacion(Donacion donacion) {
        dao.GuardarDonacion(donacion);
        return listaCompleta();
    }

    @Override
    public Donacion BuscarID(int id_Donaicon) {
        return dao.BuscarID(id_Donaicon);
    }

    @Override
    public List<Donacion> BuscarUsuarioID(Usuario usuarioId) {
        return dao.BuscarUsuarioID(usuarioId);
    }

    @Override
    public List<Donacion> BuscarPeticionID(Peticion peticionId) {
        return dao.BuscarPeticionID(peticionId);
    }

    @Override
    public Donacion ActualizarDonacion(Donacion donacion){
        Donacion existente = BuscarID(donacion.getId_Donacion());
        if(existente != null){
            return dao.ActualizarDonacion(donacion);
        }

        return null;
    }

}
