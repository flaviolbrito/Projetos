package br.com.fmarxds.apiecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProdutoDTO {

    @JsonProperty("codigo")
    @EqualsAndHashCode.Include
    private String codigo;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("quantidade")
    private Integer quantidade;

    @JsonProperty("valor")
    private BigDecimal valor;

}
