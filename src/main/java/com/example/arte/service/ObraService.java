package com.example.arte.service;

import com.example.arte.model.Obra;
import com.example.arte.repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObraService {

    ObraRepository obraRepository;

    @Autowired
    public void setObraRepository(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    public Obra insert(Obra obra) {
        obraRepository.save(obra);
        return obra;
    }

    public Obra update(Obra obra) {
        obraRepository.save(obra);
        return obra;
    }

    public void delete(Obra obra) {
        obraRepository.deleteById(obra.getId());
    }

    public Obra getById(Long id) {
        return obraRepository.findById(id).orElse(null);
    }

    public Obra saveAndFlush(Obra obra) {
        obraRepository.saveAndFlush(obra);
        return obra;
    }

    public Optional<Obra> findById(Long id) {
        return obraRepository.findById(id);
    }

    public List<Obra> findAll() {
        return obraRepository.findAll();
    }
}
