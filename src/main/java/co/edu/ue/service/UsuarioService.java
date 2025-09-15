package co.edu.ue.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.ue.dao.IUserDao;
import co.edu.ue.entity.Usuario;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    IUserDao dao;

    @Override
    public List<Usuario> addUser(Usuario user) {
        return dao.GuardarUser(user);
    }

    @Override
    public Usuario UpdateDato(Usuario user) {
        Usuario existente = FindID(user.getId());
        if (existente != null) {
            return dao.ActualizarUser(user);
        }
        return null;
    }

    @Override
    public List<Usuario> listAll() {
        return dao.listaCompleta();
    }

    @Override
    public Usuario FindID(int id) {
        return dao.BuscarID(id);
    }

    @Override
    public Usuario FindCorreo(String correo) {
        return dao.BuscarCorreo(correo);
    }
}
