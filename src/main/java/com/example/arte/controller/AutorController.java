package com.example.arte.controller;

import com.example.arte.model.Autor;
import com.example.arte.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class AutorController {

    AutorService autorService;

    @Autowired
    public void setAutorService(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> findAll() {
        return autorService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Autor> findById(@PathVariable Long id) {

        Optional<Autor> autorOptional = autorService.findById(id);

        if (autorOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(autorOptional.get());
        }
    }

    @PostMapping
    public ResponseEntity<Autor> insert(@RequestBody Autor autor) {
        autorService.insert(autor);
        return ResponseEntity.created(URI.create("/autor" + autor.getId() )).body(autor);
    }

//    @PutMapping
//    public Autor update(@PathVariable Long id, @RequestBody Autor autor) {
//        return autorService.findById(id)
//                .map( record -> {
//                    autorService.delete(record);
//                    return ResponseEntity.status(202).build();
//                }).orElse(ResponseEntity.notFound().build());
//    }

}
