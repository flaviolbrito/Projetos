package br.com.fmarxds.apiecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoPedidoDTO {

    @JsonProperty("codigo")
    private String codigo;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("quantidade")
    private Integer quantidade;

}
