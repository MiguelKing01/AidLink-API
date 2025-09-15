package co.edu.ue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import co.edu.ue.entity.Usuario;
import co.edu.ue.service.IUsuarioService;

import java.util.List;

@RestController
@RequestMapping("/Usuario") 
public class UsuarioController {

    @Autowired
    IUsuarioService service;

    @PostMapping(value = "/crear", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuario>> postUser(@RequestBody Usuario user) {
        List<Usuario> listUser = service.addUser(user);
        return new ResponseEntity<>(listUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuario>> getAll() {
        List<Usuario> listUser = service.listAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Usuarios", String.valueOf(listUser.size()));
        return new ResponseEntity<>(listUser, headers, HttpStatus.OK);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Usuario> putUser(@RequestBody Usuario user) {
        Usuario actualizado = service.UpdateDato(user);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/id")
    public ResponseEntity<Usuario> getIdUser(@RequestParam("id") int id) {
        Usuario usuario = service.FindID(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/correo")
    public ResponseEntity<Usuario> getByCorreo(@RequestParam("correo") String correo) {
        Usuario usuario = service.FindCorreo(correo);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
