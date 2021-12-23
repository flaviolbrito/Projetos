package br.com.fmarxds.apiecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClienteDTO {

    @JsonProperty("cpf")
    @EqualsAndHashCode.Include
    private String cpf;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("enderecos")
    private List<EnderecoDTO> enderecos;

}
