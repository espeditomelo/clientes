package io.github.espeditomelo.clientes.model.repository;

import io.github.espeditomelo.clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
