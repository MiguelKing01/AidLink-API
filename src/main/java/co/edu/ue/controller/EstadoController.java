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

import co.edu.ue.entity.Estado;
import co.edu.ue.service.IEstadoService;

@RestController
@RequestMapping("/Estado")
public class EstadoController {

    @Autowired
    IEstadoService service;
    
    @PostMapping(value = "/crear-Estado", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Estado>> postEstado(@RequestBody Estado estado) {
        List<Estado> listEstado = service.GuardarEstado(estado);
        return new ResponseEntity<>(listEstado, HttpStatus.CREATED);
    }

    @GetMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Estado>> getAll() {
        List<Estado> listEstado = service.listaCompleta();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Estados", String.valueOf(listEstado.size()));
        return new ResponseEntity<>(listEstado, headers, HttpStatus.OK);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Estado> putUser(@RequestBody Estado estado) {
        Estado actualizado = service.ActualizarEstado(estado);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/id")
    public ResponseEntity<Estado> getId_Estado(@RequestParam("id") int id_Donacion) {
        Estado estado = service.BuscarID(id_Donacion);
        if (estado != null) {
            return new ResponseEntity<>(estado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
