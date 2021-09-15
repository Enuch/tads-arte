package com.example.arte.controller;

import com.example.arte.DTO.request.ObraRequestDTO;
import com.example.arte.DTO.response.ObraResponseDTO;
import com.example.arte.model.Autor;
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
    public List<ObraResponseDTO> findAll() {
        return obraService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<ObraResponseDTO> findById(@PathVariable Long id) {
        Optional<Obra> obraOptional = obraService.findById(id);

        if (obraOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(new ObraResponseDTO(obraOptional.get()));
        }
    }

    @PostMapping
    public ResponseEntity<ObraResponseDTO> insert(@RequestBody ObraRequestDTO obraDTO) {
        Obra obra = obraService.insert(obraDTO.build());
        return ResponseEntity.created(URI.create("/obra" + obra.getId() )).body(new ObraResponseDTO(obra));
    }

    @PutMapping(path = {"/editar/{id}"})
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Obra obra) {
        return obraService.findById(id)
                .map( record -> {

                    if (record.getId().equals(obra.getId())) {
                        obraService.saveAndFlush(obra);
                        return ResponseEntity.ok(new ObraResponseDTO(obra));
                    } else {
                        return ResponseEntity.notFound().build();
                    }

                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/deletar/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return obraService.findById(id)
                .map( record -> {
                    obraService.delete(record);
                    return ResponseEntity.ok("Deletado com sucesso");
                }).orElse(ResponseEntity.notFound().build());
    }

}
