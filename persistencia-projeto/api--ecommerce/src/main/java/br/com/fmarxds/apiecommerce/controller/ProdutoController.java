package br.com.fmarxds.apiecommerce.controller;

import br.com.fmarxds.apiecommerce.dto.ProdutoDTO;
import br.com.fmarxds.apiecommerce.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> buscarTodosProdutos() {
        return ResponseEntity.ok(produtoService.buscarTodos());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ProdutoDTO> buscarProdutoPorCodigo(
            @PathVariable("codigo") String codigo
    ) {
        return ResponseEntity.of(produtoService.buscarPorCodigo(codigo));
    }

}
