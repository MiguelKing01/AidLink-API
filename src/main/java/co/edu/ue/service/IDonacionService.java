package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Donacion;
import co.edu.ue.entity.Peticion;
import co.edu.ue.entity.Usuario;

public interface IDonacionService {

    List<Donacion> GuardarDonacion(Donacion donacion);
    Donacion ActualizarDonacion(Donacion donacion);
    List<Donacion> listaCompleta();
    Donacion BuscarID(int id_Donacion);
    List<Donacion> BuscarUsuarioID(Usuario usuarioId);
    List<Donacion> BuscarPeticionID(Peticion peticionId);
}
