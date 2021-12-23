package br.com.fmarxds.apiecommerce.controller;

import br.com.fmarxds.apiecommerce.dto.ClienteDTO;
import br.com.fmarxds.apiecommerce.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> buscarTodosClientes() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> buscarClientesPorCpf(
            @PathVariable("cpf") String cpf
    ) {
        return ResponseEntity.of(clienteService.buscarPorCpf(cpf));
    }

}
