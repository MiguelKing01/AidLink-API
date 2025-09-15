package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Donacion;
import co.edu.ue.entity.Envio;
import co.edu.ue.entity.Estado;
import co.edu.ue.entity.Peticion;

public interface IEnvioService {

    List<Envio> GuardarEnvio(Envio envio);
    Envio ActualizarEnvio(Envio envio);
    List<Envio> listaCompleta();
    Envio BuscarID(int id_Envio);
    List<Envio> BuscarPeticionID(Peticion peticionId);
    List<Envio> BuscarDonacionID(Donacion donacionId);
    List<Envio> BuscarEstadoID(Estado estadoId);
}
