package br.com.fmarxds.apiecommerce.service.data.pedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoServiceInput {

    private String cpf;
    private String enderecoEntregaId;
    private List<PedidoProdutoServiceInput> produtos;

}
