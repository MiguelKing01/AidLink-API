package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IEnvioDao;
import co.edu.ue.entity.Donacion;
import co.edu.ue.entity.Envio;
import co.edu.ue.entity.Estado;
import co.edu.ue.entity.Peticion;

@Service
public class EnvioService implements IEnvioService {

    @Autowired
    IEnvioDao dao;

    @Override
    public List<Envio> listaCompleta() {
        return dao.listaCompleta ();
    }

    @Override
    public List<Envio> GuardarEnvio(Envio envio) {
        dao.GuardarEnvio(envio);
        return listaCompleta();
    }

    @Override
    public Envio ActualizarEnvio(Envio envio) {
        Envio existente = BuscarID(envio.getId_Envio());
        if(existente != null){
            return dao.ActualizarEnvio(envio);
        }

        return null;
    }

    @Override
    public Envio BuscarID(int id_Envio) {
        return dao.BuscarID(id_Envio);
    }

    @Override
    public List<Envio> BuscarPeticionID(Peticion peticionId) {
        return dao.BuscarPeticionID(peticionId);
    }

    @Override
    public List<Envio> BuscarDonacionID(Donacion donacionId) {
        return dao.BuscarDonacionID(donacionId);
    }

        @Override
    public List<Envio> BuscarEstadoID(Estado estadoId) {
        return dao.BuscarEstadoID(estadoId);
    }

}
