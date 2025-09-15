package co.edu.ue.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.ue.entity.Usuario;
import co.edu.ue.jpa.IUsuarioJPA;

@Repository
public class UserDao implements IUserDao {

    @Autowired
    IUsuarioJPA jpa;

    @Override
    public List<Usuario> GuardarUser(Usuario user) {
        jpa.save(user);
        return listaCompleta();
    }

    @Override
    public Usuario ActualizarUser(Usuario user) {
        return jpa.save(user);
    }

    @Override
    public List<Usuario> listaCompleta() {
        return jpa.findAll();
    }

    @Override
    public Usuario BuscarID(int id) {
        return jpa.findById(id).orElse(null);
    }

    @Override
    public Usuario BuscarCorreo(String correo) {
        return jpa.findByCorreo(correo);
    }
}
