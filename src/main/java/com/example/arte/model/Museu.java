package com.example.arte.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "museu")
public class Museu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "museu_id", nullable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "localizacao")
    private String localizacao;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data")
    private Date data;

    @Column(name = "deleted")
    private java.util.Date deleted;

    @OneToMany(mappedBy = "museu", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Obra> obras;

}
