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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProdutoModel {

    @Field("codigo")
    @EqualsAndHashCode.Include
    private String codigo;

    @Field("nome")
    private String nome;

    @Field("quantidade")
    private Integer quantidade;

}
