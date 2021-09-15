package com.example.arte.DTO.response;

import com.example.arte.controller.AutorController;
import com.example.arte.model.Museu;
import com.example.arte.model.Obra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.sql.Date;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MuseuResponseDTO extends RepresentationModel<MuseuResponseDTO> {
    private String nome;
    private String localizacao;
    private String descricao;
    private Date data;
    private List<Obra> obras;

    public MuseuResponseDTO (Museu museu) {
        this.nome = museu.getNome();
        this.localizacao = museu.getLocalizacao();
        this.descricao = museu.getDescricao();
        this.data = museu.getData();
        this.obras = museu.getObras();

        this.add(linkTo(AutorController.class).slash(museu.getId()).withSelfRel());
        this.add(linkTo(AutorController.class).slash("/editar/" + museu.getId()).withRel("Editar museu"));
        this.add(linkTo(AutorController.class).slash("/deletar/" + museu.getId()).withRel("Deletar museu"));
        this.add(linkTo(AutorController.class).withRel("Listar todos os museu"));
    }
}
