package io.github.espeditomelo.clientes.rest;

import io.github.espeditomelo.clientes.model.entity.Cliente;
import io.github.espeditomelo.clientes.model.entity.ServicoPrestado;
import io.github.espeditomelo.clientes.model.repository.ClienteRepository;
import io.github.espeditomelo.clientes.model.repository.ServicoPrestadoRepository;
import io.github.espeditomelo.clientes.rest.dto.ServicoPrestadoDTO;
import io.github.espeditomelo.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository servicoPrestadoRepository;
    private final BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar (@RequestBody ServicoPrestadoDTO dto) {

        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        ServicoPrestado servicoPrestado = new ServicoPrestado();

        Integer idCLiente = dto.getIdCliente();
        Optional<Cliente> clienteOptional = clienteRepository.findById(idCLiente);
        Cliente cliente = clienteRepository
                .findById(idCLiente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não encontrado"));

        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor( bigDecimalConverter.converter(dto.getPreco()) );

        return servicoPrestadoRepository.save(servicoPrestado);
    }

    @GetMapping
    public List<ServicoPrestado> pesquisar(
            @RequestParam(value =  "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ){
        return servicoPrestadoRepository.findByNomeClienteAndMes("%" + nome + "%", mes );
    }
}
