package br.com.fmarxds.servicepedido.service;

import br.com.fmarxds.servicepedido.model.PedidoModel;
import br.com.fmarxds.servicepedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public List<PedidoModel> buscarTodos() {
        return pedidoRepository.findAll();
    }

    public List<PedidoModel> buscarPorCpf(String cpf) {
        return pedidoRepository.findAllByCpf(cpf);
    }

    public PedidoModel criarPedido(PedidoModel pedido) {
        return pedidoRepository.save(pedido);
    }

}
