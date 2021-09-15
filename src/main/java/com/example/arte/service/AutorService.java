package com.example.arte.service;

import com.example.arte.DTO.response.AutorResponseDTO;
import com.example.arte.model.Autor;
import com.example.arte.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    AutorRepository autorRepository;

    @Autowired
    public void setAutorRepository(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor insert(Autor autor) {
        autorRepository.save(autor);
        return autor;
    }

    public Autor update(Autor autor) {
        autorRepository.save(autor);
        return autor;
    }

    public void delete(Autor autor) {
        autor.setDeleted(new Date());
        autorRepository.save(autor);
    }

    public Autor getById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    public Autor saveAndFlush(Autor autor) {
        autorRepository.saveAndFlush(autor);
        return autor;
    }

    public Optional<Autor> findById(Long id) {
        return autorRepository.findAllByDeletedIsNullAndId(id);
    }

    public List<AutorResponseDTO> findAll() {
        ArrayList<AutorResponseDTO> autorResponseDTOS = new ArrayList<>();
        for (Autor autor: autorRepository.findAllByDeletedIsNull()) {
            autorResponseDTOS.add(new AutorResponseDTO(autor));
        }
        return autorResponseDTOS;
    }

}
