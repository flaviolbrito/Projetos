package br.com.fmarxds.apiecommerce.service;

import br.com.fmarxds.apiecommerce.dto.*;
import br.com.fmarxds.apiecommerce.exception.ClienteNaoEncontradoException;
import br.com.fmarxds.apiecommerce.exception.EnderecoNaoEncontradoException;
import br.com.fmarxds.apiecommerce.exception.EstoqueNaoBaixadoException;
import br.com.fmarxds.apiecommerce.exception.ProdutoNaoEncontradoException;
import br.com.fmarxds.apiecommerce.gateway.PedidoGateway;
import br.com.fmarxds.apiecommerce.service.data.pedido.PedidoProdutoServiceInput;
import br.com.fmarxds.apiecommerce.service.data.pedido.PedidoServiceInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoGateway pedidoGateway;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    public List<PedidoDTO> buscarTodos() {
        return pedidoGateway.buscarTodos();
    }

    public List<PedidoDTO> buscarPorCpf(String cpf) {
        return pedidoGateway.buscarPorCpf(cpf);
    }

    public PedidoDTO criarPedido(PedidoServiceInput pedido) throws ClienteNaoEncontradoException, ProdutoNaoEncontradoException, EstoqueNaoBaixadoException, EnderecoNaoEncontradoException {

        ClienteDTO cliente = buscarCliente(pedido);
        EnderecoDTO endereco = buscarEndereco(pedido, cliente);
        List<ProdutoPedidoDTO> produtos = buscarProdutosPedidos(pedido);

        darBaixaNosProdutos(produtos);

        PedidoDTO pedidoDTO = PedidoDTO.builder()
                .cpf(cliente.getCpf())
                .data(LocalDate.now())
                .enderecoEntrega(endereco)
                .produtos(produtos)
                .build();

        return pedidoGateway.criarPedido(pedidoDTO);

    }

    private void darBaixaNosProdutos(List<ProdutoPedidoDTO> produtos) throws EstoqueNaoBaixadoException {
        for (ProdutoPedidoDTO produto : produtos) {
            produtoService.baixarEstoque(produto.getCodigo(), produto.getQuantidade());
        }
    }

    private ClienteDTO buscarCliente(PedidoServiceInput pedido) throws ClienteNaoEncontradoException {
        return clienteService.buscarPorCpf(pedido.getCpf())
                .orElseThrow(() -> new ClienteNaoEncontradoException("O cpf informado é inválido"));
    }

    private EnderecoDTO buscarEndereco(PedidoServiceInput pedido, ClienteDTO cliente) throws EnderecoNaoEncontradoException {
        return cliente.getEnderecos().stream()
                .filter(endereco -> endereco.getId().equals(pedido.getEnderecoEntregaId()))
                .findFirst()
                .orElseThrow(() -> new EnderecoNaoEncontradoException("O endereço informado é inválido"));
    }

    private List<ProdutoPedidoDTO> buscarProdutosPedidos(PedidoServiceInput pedido) throws ProdutoNaoEncontradoException {
        List<ProdutoPedidoDTO> produtosPedidos = new ArrayList<>();
        for (PedidoProdutoServiceInput produto : pedido.getProdutos()) {
            produtosPedidos.add(new ProdutoPedidoDTO(produto.getCodigo(), buscarNomeProduto(produto), produto.getQuantidade()));
        }
        return produtosPedidos;
    }

    private String buscarNomeProduto(PedidoProdutoServiceInput produto) throws ProdutoNaoEncontradoException {
        return produtoService.buscarPorCodigo(produto.getCodigo())
                .map(ProdutoDTO::getNome)
                .orElseThrow(() -> new ProdutoNaoEncontradoException("O produto informado é inválido"));
    }

}
