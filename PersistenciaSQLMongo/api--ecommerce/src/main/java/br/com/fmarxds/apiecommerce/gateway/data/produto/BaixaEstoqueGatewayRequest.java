package br.com.fmarxds.apiecommerce.gateway.data.produto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaixaEstoqueGatewayRequest {

    @JsonProperty("quantidade")
    private Integer quantidade;

}
