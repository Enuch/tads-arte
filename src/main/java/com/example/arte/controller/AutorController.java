package com.example.arte.controller;

import com.example.arte.DTO.request.AutorRequestDTO;
import com.example.arte.DTO.response.AutorResponseDTO;
import com.example.arte.DTO.response.ObraResponseDTO;
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
    public List<AutorResponseDTO> findAll() {
        return autorService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<AutorResponseDTO> findById(@PathVariable Long id) {

        Optional<Autor> autorOptional = autorService.findById(id);

        if (autorOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(new AutorResponseDTO(autorOptional.get()));
        }
    }

    @PostMapping
    public ResponseEntity<AutorResponseDTO> insert(@RequestBody AutorRequestDTO autorDTO) {
        Autor autor = autorService.insert(autorDTO.build());
        return ResponseEntity.created(URI.create("/autor" + autor.getId() )).body(new AutorResponseDTO(autor));
    }

    @PutMapping(path = {"/editar/{id}"})
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Autor autor) {
       return autorService.findById(id)
               .map( record -> {

                   if (record.getId().equals(autor.getId())) {
                       autorService.saveAndFlush(record);
                       return ResponseEntity.ok(new AutorResponseDTO(autor));
                   } else {
                       return ResponseEntity.notFound().build();
                   }

               }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/deletar/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return autorService.findById(id)
                .map( record -> {
                        autorService.delete(record);
                        return ResponseEntity.ok("Deletado com sucesso");
                }).orElse(ResponseEntity.notFound().build());
    }


}
