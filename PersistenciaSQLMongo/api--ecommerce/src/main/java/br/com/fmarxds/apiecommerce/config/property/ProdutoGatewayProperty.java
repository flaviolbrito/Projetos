package br.com.fmarxds.apiecommerce.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("gateway.produto")
public class ProdutoGatewayProperty {

    private String urlBuscarTodos;
    private String urlBuscarPorCodigo;
    private String urlBaixarEstoque;

}
