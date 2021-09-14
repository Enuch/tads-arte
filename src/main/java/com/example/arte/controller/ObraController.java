package com.example.arte.controller;

import com.example.arte.model.Obra;
import com.example.arte.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/obra")
public class ObraController {

    ObraService obraService;

    @Autowired
    public void setObraService(ObraService obraService) {
        this.obraService = obraService;
    }

    @GetMapping
    public List<Obra> findAll() {
        return obraService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Obra> findById(@PathVariable Long id) {
        Optional<Obra> obraOptional = obraService.findById(id);

        if (obraOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(obraOptional.get());
        }
    }

    @PostMapping
    public ResponseEntity<Obra> insert(@RequestBody Obra obra) {
        obraService.insert(obra);
        return ResponseEntity.created(URI.create("/obra" + obra.getId() )).body(obra);
    }

}
