package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Donacion;
import co.edu.ue.entity.Peticion;
import co.edu.ue.entity.Usuario;
import co.edu.ue.service.IDonacionService;

@RestController
@RequestMapping("/Donacion")
public class DonacionController {

    @Autowired
    IDonacionService service;

    @PostMapping(value = "/crear-Donacion", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Donacion>> postDonacion(@RequestBody Donacion donacion) {
        List<Donacion> listDonacion = service.GuardarDonacion(donacion);
        return new ResponseEntity<>(listDonacion, HttpStatus.CREATED);
    }

    @GetMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Donacion>> getAll() {
        List<Donacion> listDonacion = service.listaCompleta();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Donacion", String.valueOf(listDonacion.size()));
        return new ResponseEntity<>(listDonacion, headers, HttpStatus.OK);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Donacion> putUser(@RequestBody Donacion donacion) {
        Donacion actualizado = service.ActualizarDonacion(donacion);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/id")
    public ResponseEntity<Donacion> getId_Donacion(@RequestParam("id") int id_Donacion) {
        Donacion donacion = service.BuscarID(id_Donacion);
        if (donacion != null) {
            return new ResponseEntity<>(donacion, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/idUsuario")
    public ResponseEntity<List<Donacion>> getIdUsuario(@RequestParam("idUsuario") Usuario usuarioId) {
        List<Donacion> donacion = service.BuscarUsuarioID(usuarioId);
        if (donacion == null || donacion.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(donacion, HttpStatus.OK);
    }

    @GetMapping(value = "/idPeticion")
    public ResponseEntity<List<Donacion>> getIdPeticion(@RequestParam("idPeticion") Peticion peticionId) {
        List<Donacion> donacion = service.BuscarPeticionID(peticionId);
        if (donacion == null || donacion.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(donacion, HttpStatus.OK);
    }

}
