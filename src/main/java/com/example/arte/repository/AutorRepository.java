package com.example.arte.repository;

import com.example.arte.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findAllByDeletedIsNull();
    Optional<Autor> findAllByDeletedIsNullAndId(Long id);
}
