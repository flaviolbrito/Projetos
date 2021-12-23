package br.com.fmarxds.apiecommerce.gateway;

import br.com.fmarxds.apiecommerce.config.property.PedidoGatewayProperty;
import br.com.fmarxds.apiecommerce.dto.PedidoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoGateway {

    private final RestTemplate restTemplate;
    private final PedidoGatewayProperty properties;

    @Cacheable(cacheNames = "PedidoGateway:buscarTodos", unless = "#result.size() == 0")
    public List<PedidoDTO> buscarTodos() {

        ResponseEntity<List<PedidoDTO>> responseEntity = restTemplate.exchange(
                properties.getUrlBuscarTodos(),
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                new ParameterizedTypeReference<>() {
                }
        );

        return responseEntity.getBody();

    }

    @Cacheable(cacheNames = "PedidoGateway:buscarPorCpf", unless = "#result.size() == 0")
    public List<PedidoDTO> buscarPorCpf(String cpf) {

        ResponseEntity<List<PedidoDTO>> responseEntity = restTemplate.exchange(
                properties.getUrlBuscarTodosPorCpf(),
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                new ParameterizedTypeReference<>() {
                },
                cpf
        );

        return responseEntity.getBody();

    }

    @CacheEvict(cacheNames = {"PedidoGateway:buscarTodos", "PedidoGateway:buscarPorCpf"}, allEntries = true)
    public PedidoDTO criarPedido(PedidoDTO pedido) {

        ResponseEntity<PedidoDTO> responseEntity = restTemplate.exchange(
                properties.getUrlCriarPedido(),
                HttpMethod.POST,
                new HttpEntity<>(pedido, new HttpHeaders()),
                new ParameterizedTypeReference<>() {
                }
        );

        return responseEntity.getBody();

    }

}
