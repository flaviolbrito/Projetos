package br.com.fmarxds.apiecommerce.service;

import br.com.fmarxds.apiecommerce.dto.ProdutoDTO;
import br.com.fmarxds.apiecommerce.exception.EstoqueNaoBaixadoException;
import br.com.fmarxds.apiecommerce.gateway.ProdutoGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoGateway produtoGateway;

    public List<ProdutoDTO> buscarTodos() {
        return produtoGateway.buscarTodos();
    }

    public Optional<ProdutoDTO> buscarPorCodigo(String codigo) {
        return produtoGateway.buscarPorCodigo(codigo);
    }

    public void baixarEstoque(String codigo, Integer quantidade) throws EstoqueNaoBaixadoException {
        produtoGateway.baixarEstoque(codigo, quantidade);
    }

}
