package com.example.arte.DTO.request;

import com.example.arte.model.Museu;
import com.example.arte.model.Obra;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MuseuRequestDTO {
    private String nome;
    private String localizacao;
    private String descricao;
    private Date data;
    private List<Obra> obras;

    public Museu build() {
        Museu museu = new Museu();
        museu.setNome(this.nome);
        museu.setLocalizacao(this.localizacao);
        museu.setDescricao(this.descricao);
        museu.setData(this.data);
        museu.setObras(this.obras);

        return museu;
    }
}
