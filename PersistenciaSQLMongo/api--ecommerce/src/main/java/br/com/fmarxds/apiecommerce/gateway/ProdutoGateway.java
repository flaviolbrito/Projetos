package br.com.fmarxds.apiecommerce.gateway;

import br.com.fmarxds.apiecommerce.config.property.ProdutoGatewayProperty;
import br.com.fmarxds.apiecommerce.dto.ProdutoDTO;
import br.com.fmarxds.apiecommerce.exception.EstoqueNaoBaixadoException;
import br.com.fmarxds.apiecommerce.gateway.data.produto.BaixaEstoqueGatewayRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
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
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProdutoGateway {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final ProdutoGatewayProperty properties;

    @Cacheable(cacheNames = "ProdutoGateway:buscarTodos", unless = "#result.size() == 0")
    public List<ProdutoDTO> buscarTodos() {

        ResponseEntity<List<ProdutoDTO>> responseEntity = restTemplate.exchange(
                properties.getUrlBuscarTodos(),
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                new ParameterizedTypeReference<>() {
                }
        );

        return responseEntity.getBody();

    }

    @Cacheable(cacheNames = "ProdutoGateway:buscarPorCodigo", key = "#codigo", unless = "#result == null")
    public Optional<ProdutoDTO> buscarPorCodigo(String codigo) {

        try {

            ResponseEntity<ProdutoDTO> responseEntity = restTemplate.exchange(
                    properties.getUrlBuscarPorCodigo(),
                    HttpMethod.GET,
                    new HttpEntity<>(new HttpHeaders()),
                    new ParameterizedTypeReference<>() {
                    },
                    codigo
            );

            return Optional.ofNullable(responseEntity.getBody());

        } catch (HttpClientErrorException ex) {
            log.warn(ex.getResponseBodyAsString());
            return Optional.empty();
        } catch (Exception ex) {
            log.error(ex.getLocalizedMessage());
            throw new RuntimeException("Ocorreu um erro desconhecido");
        }

    }

    @CacheEvict(cacheNames = {"ProdutoGateway:buscarTodos", "ProdutoGateway:buscarPorCodigo"}, allEntries = true)
    public void baixarEstoque(String codigo, Integer quantidade) throws EstoqueNaoBaixadoException {

        try {

            restTemplate.exchange(
                    properties.getUrlBaixarEstoque(),
                    HttpMethod.PUT,
                    new HttpEntity<>(new BaixaEstoqueGatewayRequest(quantidade), new HttpHeaders()),
                    new ParameterizedTypeReference<>() {
                    },
                    codigo
            );

        } catch (HttpClientErrorException ex) {
            try {
                log.warn(ex.getResponseBodyAsString());
                Map<String, String> responseBody = objectMapper.readValue(ex.getResponseBodyAsString(), new TypeReference<>() {
                });
                throw new EstoqueNaoBaixadoException(responseBody.get("mensagem"));
            } catch (JsonProcessingException e) {
                log.error(ex.getLocalizedMessage());
                throw new RuntimeException("Ocorreu um erro desconhecido");
            }
        }

    }

}
