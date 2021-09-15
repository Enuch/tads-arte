package com.example.arte.service;

import com.example.arte.model.Museu;
import com.example.arte.repository.MuseuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MuseuService {

    MuseuRepository museuRepository;

    @Autowired
    public void setMuseuRepository(MuseuRepository museuRepository) {
        this.museuRepository = museuRepository;
    }

    public Museu insert(Museu museu) {
        museuRepository.save(museu);
        return museu;
    }

    public Museu update(Museu museu) {
        museuRepository.save(museu);
        return museu;
    }

    public void delete(Museu museu) {
        museu.setDeleted(new Date());
        museuRepository.save(museu);
    }

    public Museu getById(Long id) {
        return museuRepository.findById(id).orElse(null);
    }

    public Museu saveAndFlush(Museu museu) {
        museuRepository.saveAndFlush(museu);
        return museu;
    }

    public Optional<Museu> findById(Long id) {
        return museuRepository.findAllByDeletedIsNullAndId(id);
    }

    public List<Museu> findAll() {
        return museuRepository.findAllByDeletedIsNull();
    }

}
