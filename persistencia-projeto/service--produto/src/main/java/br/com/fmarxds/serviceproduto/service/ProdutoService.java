package br.com.fmarxds.serviceproduto.service;

import br.com.fmarxds.serviceproduto.exception.EstoqueInsuficienteException;
import br.com.fmarxds.serviceproduto.exception.ProdutoNaoEncontradoException;
import br.com.fmarxds.serviceproduto.model.ProdutoModel;
import br.com.fmarxds.serviceproduto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<ProdutoModel> buscarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> buscarPorCodigo(String codigo) {
        return produtoRepository.findOneByCodigo(codigo);
    }

    @Transactional(value = Transactional.TxType.REQUIRED)
    public void removerDoEstoque(String codigo, Integer quantidade) throws ProdutoNaoEncontradoException, EstoqueInsuficienteException {

        ProdutoModel produto = produtoRepository
                .findOneByCodigo(codigo)
                .orElseThrow(() -> new ProdutoNaoEncontradoException("O codigo informado é inválido!"));

        if (!produto.removerDoEstoque(quantidade)) {
            throw new EstoqueInsuficienteException(String.format("O estoque disponível é de %d itens, não é possível remover %d itens!", produto.getQuantidade(), quantidade));
        }

        produtoRepository.saveAndFlush(produto);

    }

}
