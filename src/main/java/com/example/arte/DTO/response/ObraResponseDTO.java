package com.example.arte.DTO.response;

import com.example.arte.controller.AutorController;
import com.example.arte.model.Autor;
import com.example.arte.model.Museu;
import com.example.arte.model.Obra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraResponseDTO extends RepresentationModel<ObraResponseDTO> {
    private String nome;
    private Date ano;
    private String tipo;
    private String epoca;
    private Autor autor;
    private Museu museu;

    public ObraResponseDTO (Obra obra) {
        this.nome = obra.getNome();
        this.ano = obra.getAno();
        this.tipo = obra.getTipo();
        this.epoca = obra.getEpoca();
        this.autor = obra.getAutor();
        this.museu = obra.getMuseu();

        this.add(linkTo(AutorController.class).slash(obra.getId()).withSelfRel());
        this.add(linkTo(AutorController.class).slash("/editar/" + obra.getId()).withRel("Editar obra"));
        this.add(linkTo(AutorController.class).slash("/deletar/" + obra.getId()).withRel("Deletar obra"));
        this.add(linkTo(AutorController.class).withRel("Listar todos os obra"));
    }
}
