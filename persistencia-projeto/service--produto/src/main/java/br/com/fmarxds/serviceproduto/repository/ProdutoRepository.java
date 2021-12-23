package br.com.fmarxds.serviceproduto.repository;

import br.com.fmarxds.serviceproduto.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

    Optional<ProdutoModel> findOneByCodigo(String codigo);

}
