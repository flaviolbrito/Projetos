package br.com.fmarxds.apiecommerce.config;

import br.com.fmarxds.apiecommerce.config.property.ClienteGatewayProperty;
import br.com.fmarxds.apiecommerce.config.property.PedidoGatewayProperty;
import br.com.fmarxds.apiecommerce.config.property.ProdutoGatewayProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        ClienteGatewayProperty.class,
        PedidoGatewayProperty.class,
        ProdutoGatewayProperty.class,
})
public class PropertyConfig {
}
