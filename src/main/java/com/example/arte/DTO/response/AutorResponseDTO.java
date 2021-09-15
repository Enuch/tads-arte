package com.example.arte.DTO.response;

import com.example.arte.controller.AutorController;
import com.example.arte.model.Autor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorResponseDTO extends RepresentationModel<AutorResponseDTO>{
    private String nome;
    private Integer idade;
    private String epoca;
    private Date nascimento;
    private String biografia;

    public AutorResponseDTO (Autor autor) {
        this.nome = autor.getNome();
        this.idade = autor.getIdade();
        this.epoca = autor.getEpoca();
        this.nascimento = autor.getNascimento();
        this.biografia = autor.getBiografia();

        this.add(linkTo(AutorController.class).slash(autor.getId()).withSelfRel());
        this.add(linkTo(AutorController.class).slash("/editar/" + autor.getId()).withRel("Editar autor"));
        this.add(linkTo(AutorController.class).slash("/deletar/" + autor.getId()).withRel("Deletar autor"));
        this.add(linkTo(AutorController.class).withRel("Listar todos os autores"));

    }
}
