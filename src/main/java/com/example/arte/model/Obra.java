package com.example.arte.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "obra")
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "obra_id", nullable = false)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "ano")
    private Date ano;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "epoca")
    private String epoca;

    @Column(name = "deleted")
    private  Date deleted;

    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = true)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "museu_id")
    private Museu museu;
}
