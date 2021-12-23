package br.com.fmarxds.apiecommerce.controller;

import br.com.fmarxds.apiecommerce.dto.PedidoDTO;
import br.com.fmarxds.apiecommerce.exception.ClienteNaoEncontradoException;
import br.com.fmarxds.apiecommerce.exception.EnderecoNaoEncontradoException;
import br.com.fmarxds.apiecommerce.exception.EstoqueNaoBaixadoException;
import br.com.fmarxds.apiecommerce.exception.ProdutoNaoEncontradoException;
import br.com.fmarxds.apiecommerce.service.PedidoService;
import br.com.fmarxds.apiecommerce.service.data.pedido.PedidoServiceInput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> buscarTodosPedidos() {
        return ResponseEntity.ok(pedidoService.buscarTodos());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<List<PedidoDTO>> buscarTodosPedidosPorCpf(
        @PathVariable("cpf") String cpf
    ) {
        return ResponseEntity.ok(pedidoService.buscarPorCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<?> criarPedido(
            @RequestBody PedidoServiceInput body
    ) {
        try {
            return new ResponseEntity<>(pedidoService.criarPedido(body), HttpStatus.CREATED);
        } catch (ClienteNaoEncontradoException | ProdutoNaoEncontradoException | EstoqueNaoBaixadoException | EnderecoNaoEncontradoException e) {
            return new ResponseEntity<>(Map.of("mensagem", e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
