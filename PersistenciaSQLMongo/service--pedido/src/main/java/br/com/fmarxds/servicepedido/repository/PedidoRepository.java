package br.com.fmarxds.servicepedido.repository;

import br.com.fmarxds.servicepedido.model.PedidoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PedidoRepository extends MongoRepository<PedidoModel, String> {

    List<PedidoModel> findAllByCpf(String cpf);

}
