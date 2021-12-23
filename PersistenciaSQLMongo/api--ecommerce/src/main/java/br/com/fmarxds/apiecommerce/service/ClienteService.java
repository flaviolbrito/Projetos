package br.com.fmarxds.apiecommerce.service;

import br.com.fmarxds.apiecommerce.dto.ClienteDTO;
import br.com.fmarxds.apiecommerce.gateway.ClienteGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteGateway clienteGateway;

    public List<ClienteDTO> buscarTodos() {
        return clienteGateway.buscarTodos();
    }

    public Optional<ClienteDTO> buscarPorCpf(String cpf) {
        return clienteGateway.buscarPorCpf(cpf);
    }

}
