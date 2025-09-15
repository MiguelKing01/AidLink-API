package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IEstadoDao;
import co.edu.ue.entity.Estado;

@Service
public class EstadoService implements IEstadoService {

    @Autowired
    IEstadoDao dao;

    @Override
    public List<Estado> listaCompleta() {
        return dao.listaCompleta();
    }

    @Override
    public List<Estado> GuardarEstado(Estado estado) {
        dao.GuardarEstado(estado);
        return listaCompleta();
    }

    @Override
    public Estado ActualizarEstado(Estado estado) {
        Estado existente = BuscarID(estado.getId_Estado());
        if (existente != null) {
            return dao.ActualizarEstado(estado);
        }

        return null;
    }

    @Override
    public Estado BuscarID(int id_Estado) {
        return dao.BuscarID(id_Estado);
    }

}
