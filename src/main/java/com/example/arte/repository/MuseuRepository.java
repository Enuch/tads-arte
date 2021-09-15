package com.example.arte.repository;

import com.example.arte.model.Museu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MuseuRepository extends JpaRepository<Museu, Long> {
    List<Museu> findAllByDeletedIsNull();
    Optional<Museu> findAllByDeletedIsNullAndId(Long id);
}
