package br.com.fmarxds.serviceproduto.controller;

import br.com.fmarxds.serviceproduto.dto.BaixaEstoqueDTO;
import br.com.fmarxds.serviceproduto.exception.EstoqueInsuficienteException;
import br.com.fmarxds.serviceproduto.exception.ProdutoNaoEncontradoException;
import br.com.fmarxds.serviceproduto.model.ProdutoModel;
import br.com.fmarxds.serviceproduto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> buscarTodos() {
        return ResponseEntity.ok(produtoService.buscarTodos());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ProdutoModel> buscarPorCodigo(
            @PathVariable("codigo") String codigo
    ) {
        return ResponseEntity.of(produtoService.buscarPorCodigo(codigo));
    }

    @PutMapping("/{codigo}/baixa")
    public ResponseEntity<?> darBaixaEmEstoque(
            @PathVariable("codigo") String codigo,
            @RequestBody BaixaEstoqueDTO body
    ) {
        try {
            produtoService.removerDoEstoque(codigo, body.getQuantidade());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ProdutoNaoEncontradoException | EstoqueInsuficienteException e) {
            return new ResponseEntity<>(Map.of("mensagem", e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
