package br.com.fmarxds.servicecliente.service;

import br.com.fmarxds.servicecliente.model.ClienteModel;
import br.com.fmarxds.servicecliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<ClienteModel> buscarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> buscarPorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

}
