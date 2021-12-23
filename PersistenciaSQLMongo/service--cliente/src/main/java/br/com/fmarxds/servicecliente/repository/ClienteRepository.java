package br.com.fmarxds.servicecliente.repository;

import br.com.fmarxds.servicecliente.model.ClienteModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClienteRepository extends MongoRepository<ClienteModel, String> {

    Optional<ClienteModel> findByCpf(String cpf);

}
