package com.example.arte.controller;

import com.example.arte.model.Autor;
import com.example.arte.model.Museu;
import com.example.arte.service.MuseuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/museu")
public class MuseuController {

    MuseuService museuService;

    @Autowired
    public void setMuseuService(MuseuService museuService) {
        this.museuService = museuService;
    }

    @GetMapping
    public List<Museu> findAll() {
        return museuService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Museu> findById(@PathVariable Long id) {
        Optional<Museu> museuOptional = museuService.findById(id);

        if (museuOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(museuOptional.get());
        }
    }

    @PostMapping
    public ResponseEntity<Museu> insert(@RequestBody Museu museu) {
        museuService.insert(museu);
        return ResponseEntity.created(URI.create("/museu" + museu.getId() )).body(museu);
    }

    @PutMapping(path = {"/editar/{id}"})
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Museu museu) {
        return museuService.findById(id)
                .map( record -> {

                    if (record.getId().equals(museu.getId())) {
                        museuService.saveAndFlush(museu);
                        return ResponseEntity.ok(museu);
                    } else {
                        return ResponseEntity.notFound().build();
                    }

                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/deletar/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return museuService.findById(id)
                .map( record -> {
                    museuService.delete(record);
                    return ResponseEntity.ok("Deletado com sucesso");
                }).orElse(ResponseEntity.notFound().build());
    }
}
