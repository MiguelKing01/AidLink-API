package co.edu.ue.service;

import java.util.List;
import co.edu.ue.entity.Usuario;

public interface IUsuarioService {
    List<Usuario> addUser(Usuario user);
    Usuario UpdateDato(Usuario user);
    List<Usuario> listAll();
    Usuario FindID(int id);
    Usuario FindCorreo(String correo);
}
