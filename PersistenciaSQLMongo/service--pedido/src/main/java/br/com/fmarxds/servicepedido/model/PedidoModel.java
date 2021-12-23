package br.com.fmarxds.servicepedido.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pedido")
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PedidoModel {

    @Id
    @Field("id")
    @EqualsAndHashCode.Include
    private String id;

    @Field("cpf")
    private String cpf;

    @Field("data")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private LocalDate data;

    @Field("endereco_entrega")
    private EnderecoModel enderecoEntrega;

    @Field("produtos")
    private List<ProdutoModel> produtos;


}
