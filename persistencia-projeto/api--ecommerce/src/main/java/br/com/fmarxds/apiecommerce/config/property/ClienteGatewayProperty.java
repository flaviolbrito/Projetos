package br.com.fmarxds.apiecommerce.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("gateway.cliente")
public class ClienteGatewayProperty {

    private String urlBuscarTodos;
    private String urlBuscarPorCpf;

}
