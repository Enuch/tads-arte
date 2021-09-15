package com.example.arte.DTO.request;

import com.example.arte.model.Autor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorRequestDTO {

    private String nome;
    private Integer idade;
    private String epoca;
    private Date nascimento;
    private String biografia;

    public Autor build() {
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setIdade(this.idade);
        autor.setEpoca(this.epoca);
        autor.setNascimento(this.nascimento);
        autor.setBiografia(this.biografia);

        return autor;
    }

}
