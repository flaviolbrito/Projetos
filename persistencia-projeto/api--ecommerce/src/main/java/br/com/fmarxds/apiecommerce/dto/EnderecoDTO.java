package br.com.fmarxds.apiecommerce.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EnderecoDTO {

    @JsonProperty("id")
    @EqualsAndHashCode.Include
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String id;

    @JsonProperty("logradouro")
    private String logradouro;

    @JsonProperty("numero")
    private String numero;

    @JsonProperty("cep")
    private String cep;

    @JsonProperty("cidade")
    private String cidade;

    @JsonProperty("estado")
    private String estado;

}
