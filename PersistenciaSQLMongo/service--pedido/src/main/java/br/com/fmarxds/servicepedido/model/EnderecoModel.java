package br.com.fmarxds.servicepedido.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoModel {

    @Field("logradouro")
    private String logradouro;

    @Field("numero")
    private String numero;

    @Field("cep")
    private String cep;

    @Field("cidade")
    private String cidade;

    @Field("estado")
    private String estado;

}
