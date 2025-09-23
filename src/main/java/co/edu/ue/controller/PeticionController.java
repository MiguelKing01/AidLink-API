package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Peticion;
import co.edu.ue.entity.Usuario;
import co.edu.ue.service.IPeticionService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/Peticion")
public class PeticionController {

    @Autowired
    IPeticionService service;

    @PostMapping(value = "/crear-Peticion", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Peticion>> postPeticion(@RequestBody Peticion peticion) {
        List<Peticion> listPeticion = service.GuardarPeticion(peticion);
        return new ResponseEntity<>(listPeticion, HttpStatus.CREATED);
    }

    @GetMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Peticion>> getAll() {
        List<Peticion> listPeticion = service.listaCompleta();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Peticiones", String.valueOf(listPeticion.size()));
        return new ResponseEntity<>(listPeticion, headers, HttpStatus.OK);
    }

    @PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Peticion> actualizarPeticion(@RequestBody Peticion peticion) {

        Peticion existente = service.BuscarID(peticion.getId_peticion());
        if (existente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (peticion.getUsuario() == null) {
            peticion.setUsuario(existente.getUsuario());
        }

        Peticion actualizado = service.ActualizarPeticion(peticion);
        return new ResponseEntity<>(actualizado, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/id")
    public ResponseEntity<Peticion> getId_peticion(@RequestParam("id") int id_Peticion) {
        Peticion peticion = service.BuscarID(id_Peticion);
        if (peticion != null) {
            return new ResponseEntity<>(peticion, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/idUsuario")
    public ResponseEntity<List<Peticion>> getIdUsuario(@RequestParam("idUsuario") Usuario usuarioId) {
        List<Peticion> peticion = service.BuscarUsuarioID(usuarioId);
        if (peticion == null || peticion.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(peticion, HttpStatus.OK);
    }

}
