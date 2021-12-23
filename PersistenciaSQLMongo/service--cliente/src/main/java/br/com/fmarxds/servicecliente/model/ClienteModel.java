package br.com.fmarxds.servicecliente.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cliente")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClienteModel {

    @Id
    @Field("id")
    @EqualsAndHashCode.Include
    private String id;

    @Field("cpf")
    private String cpf;

    @Field("nome")
    private String nome;

    @Field("telefone")
    private String telefone;

    @Field("enderecos")
    private List<EnderecoModel> enderecos;

}
