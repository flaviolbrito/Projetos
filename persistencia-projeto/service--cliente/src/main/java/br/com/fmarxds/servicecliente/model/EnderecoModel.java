package br.com.fmarxds.servicecliente.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EnderecoModel {

    @Field("id")
    @EqualsAndHashCode.Include
    private String id;

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
