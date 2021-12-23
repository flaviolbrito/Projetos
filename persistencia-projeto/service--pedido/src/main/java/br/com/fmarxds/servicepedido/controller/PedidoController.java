package br.com.fmarxds.servicepedido.controller;

import br.com.fmarxds.servicepedido.model.PedidoModel;
import br.com.fmarxds.servicepedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoModel>> buscarTodos() {
        return ResponseEntity.ok(pedidoService.buscarTodos());
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<List<PedidoModel>> buscarPorCpf(
            @PathVariable("cpf") String cpf
    ) {
        return ResponseEntity.ok(pedidoService.buscarPorCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<PedidoModel> criarPedido(
            @RequestBody PedidoModel pedido
    ) {
        return new ResponseEntity<>(pedidoService.criarPedido(pedido), HttpStatus.CREATED);
    }

}
