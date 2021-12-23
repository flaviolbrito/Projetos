package br.com.fmarxds.apiecommerce.controller.data.produto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaixaEstoqueControllerRequest {

    @JsonProperty("quantidade")
    private Integer quantidade;

}
