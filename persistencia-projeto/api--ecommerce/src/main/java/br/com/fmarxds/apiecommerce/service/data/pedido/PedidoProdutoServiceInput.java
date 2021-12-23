package br.com.fmarxds.apiecommerce.service.data.pedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoProdutoServiceInput {

    private String codigo;
    private Integer quantidade;

}
