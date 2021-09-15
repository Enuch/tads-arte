package com.example.arte.repository;

import com.example.arte.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ObraRepository extends JpaRepository<Obra, Long> {
    List<Obra> findAllByDeletedIsNull();
    Optional<Obra> findAllByDeletedIsNullAndId(Long id);
}
