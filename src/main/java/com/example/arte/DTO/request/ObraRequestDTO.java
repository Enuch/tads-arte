package com.example.arte.DTO.request;

import com.example.arte.model.Autor;
import com.example.arte.model.Museu;
import com.example.arte.model.Obra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraRequestDTO {
    private String nome;
    private Date ano;
    private String tipo;
    private String epoca;
    private Autor autor;
    private Museu museu;

    public Obra build() {
        Obra obra = new Obra();
        obra.setNome(this.nome);
        obra.setAno(this.ano);
        obra.setTipo(this.tipo);
        obra.setEpoca(this.epoca);
        obra.setAutor(this.autor);
        obra.setMuseu(this.museu);

        return obra;
    }

}
