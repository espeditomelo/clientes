package io.github.espeditomelo.clientes.model.repository;

import io.github.espeditomelo.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
