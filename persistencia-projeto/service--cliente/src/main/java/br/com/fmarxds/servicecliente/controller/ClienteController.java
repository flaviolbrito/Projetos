package br.com.fmarxds.servicecliente.controller;

import br.com.fmarxds.servicecliente.model.ClienteModel;
import br.com.fmarxds.servicecliente.service.ClienteService;
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
    public ResponseEntity<List<ClienteModel>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteModel> buscarPorCpf(
            @PathVariable("cpf") String cpf
    ) {
        return ResponseEntity.of(clienteService.buscarPorCpf(cpf));
    }

}
