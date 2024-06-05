package io.github.espeditomelo.clientes.model.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column
    private String senha;
}
