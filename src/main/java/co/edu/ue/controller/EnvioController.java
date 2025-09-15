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
import co.edu.ue.entity.Envio;
import co.edu.ue.entity.Estado;
import co.edu.ue.entity.Peticion;
import co.edu.ue.service.IEnvioService;

@RestController
@RequestMapping("/Envio")
public class EnvioController {

    @Autowired
    IEnvioService service;

    @PostMapping(value = "/crear-Envio", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Envio>> postEnvio(@RequestBody Envio envio) {
        List<Envio> listEnvio = service.GuardarEnvio(envio);
        return new ResponseEntity<>(listEnvio, HttpStatus.CREATED);
    }

    @GetMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Envio>> getAll() {
        List<Envio> listEnvio = service.listaCompleta();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Envios", String.valueOf(listEnvio.size()));
        return new ResponseEntity<>(listEnvio, headers, HttpStatus.OK);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Envio> putUser(@RequestBody Envio envio) {
        Envio actualizado = service.ActualizarEnvio(envio);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/id")
    public ResponseEntity<Envio> getId_Donacion(@RequestParam("id") int id_Envio) {
        Envio envio = service.BuscarID(id_Envio);
        if (envio != null) {
            return new ResponseEntity<>(envio, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/idPeticion")
    public ResponseEntity<List<Envio>> getIdPeticion(@RequestParam("idPeticion") Peticion peticionId) {
        List<Envio> envios = service.BuscarPeticionID(peticionId);
        if (envios == null || envios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(envios, HttpStatus.OK);
    }

    @GetMapping(value = "/idDonacion")
    public ResponseEntity<List<Envio>> getIdDonacion(@RequestParam("idDonacion") Donacion donacionId) {
        List<Envio> envios = service.BuscarDonacionID(donacionId);
        if (envios == null || envios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(envios, HttpStatus.OK);
    }

    @GetMapping(value = "/idEstado")
    public ResponseEntity<List<Envio>> getIdEstado(@RequestParam("idEstado") Estado estadoId) {
        List<Envio> envios = service.BuscarEstadoID(estadoId);
        if (envios == null || envios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(envios, HttpStatus.OK);
    }

}
