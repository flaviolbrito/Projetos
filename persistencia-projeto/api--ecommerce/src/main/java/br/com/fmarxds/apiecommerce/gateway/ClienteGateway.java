package br.com.fmarxds.apiecommerce.gateway;

import br.com.fmarxds.apiecommerce.config.property.ClienteGatewayProperty;
import br.com.fmarxds.apiecommerce.dto.ClienteDTO;
import br.com.fmarxds.apiecommerce.dto.ProdutoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClienteGateway {

    private final RestTemplate restTemplate;
    private final ClienteGatewayProperty properties;

    @Cacheable(cacheNames = "ClienteGateway:buscarTodos", unless = "#result.size() == 0")
    public List<ClienteDTO> buscarTodos() {

        ResponseEntity<List<ClienteDTO>> responseEntity = restTemplate.exchange(
                properties.getUrlBuscarTodos(),
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                new ParameterizedTypeReference<>() {
                }
        );

        return responseEntity.getBody();

    }

    @Cacheable(cacheNames = "ClienteGateway:buscarPorCpf", key = "#cpf", unless = "#result == null")
    public Optional<ClienteDTO> buscarPorCpf(String cpf) {

        try {

            ResponseEntity<ClienteDTO> responseEntity = restTemplate.exchange(
                    properties.getUrlBuscarPorCpf(),
                    HttpMethod.GET,
                    new HttpEntity<>(new HttpHeaders()),
                    new ParameterizedTypeReference<>() {
                    },
                    cpf
            );

            return Optional.ofNullable(responseEntity.getBody());

        } catch (HttpClientErrorException ex) {
            log.warn(ex.getLocalizedMessage());
            return Optional.empty();
        }

    }

}
