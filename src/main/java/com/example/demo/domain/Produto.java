package com.example.demo.domain;

import com.example.demo.domain.generic.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@SQLDelete(sql = "UPDATE Produto SET deleted_at = CURRENT_TIMESTAMP where id=?")
@SQLRestriction("deleted_at is null")
public class Produto extends AbstractEntity {

    @NotBlank (message = "O nome não pode estar em branco")
    String nome;

    @NotBlank (message = "A descrilção não pode estar em branco")
    String descricao;

    @NotBlank (message = "O preço não pode estar em branco")
    float preco;

    @NotBlank (message = "A quantidade não pode estar em branco")
    int quantidade;

    @ManyToMany
    @JoinTable(
            name = "Produto_categoria",
            joinColumns = @JoinColumn(name = "id_produto"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private Set<Categoria> categorias;
}
