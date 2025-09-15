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

import co.edu.ue.entity.Categoria;
import co.edu.ue.service.ICategoriaService;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {
    
    @Autowired
    ICategoriaService service;

    @PostMapping(value = "/crear-Categoria", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Categoria>> postCategoria(@RequestBody Categoria categoria) {
        List<Categoria> listCategoria = service.GuardarCategoria(categoria);
        return new ResponseEntity<>(listCategoria, HttpStatus.CREATED);
    }

    @GetMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Categoria>> getAll() {
        List<Categoria> listCategoria = service.listaCompleta();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Categorias", String.valueOf(listCategoria.size()));
        return new ResponseEntity<>(listCategoria, headers, HttpStatus.OK);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Categoria> putUser(@RequestBody Categoria categoria) {
        Categoria actualizado = service.ActualizarCategoria(categoria);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/id")
    public ResponseEntity<Categoria> getId_Categoria(@RequestParam("id") int id_Categoria) {
        Categoria categoria = service.BuscarID(id_Categoria);
        if (categoria != null) {
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
