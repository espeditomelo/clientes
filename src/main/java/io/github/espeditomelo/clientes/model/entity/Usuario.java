package io.github.espeditomelo.clientes.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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
    @NotEmpty(message = "{campo.login.obrigatorio}")
    private String username;

    @Column
    @NotEmpty(message = "{campo.senha.obrigatorio}")
    private String senha;
}
