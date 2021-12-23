package br.com.fmarxds.apiecommerce.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("gateway.pedido")
public class PedidoGatewayProperty {

    private String urlBuscarTodos;
    private String urlBuscarTodosPorCpf;
    private String urlCriarPedido;

}
