package br.com.fmarxds.apiecommerce.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("data")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private LocalDate data;

    @JsonProperty("enderecoEntrega")
    private EnderecoDTO enderecoEntrega;

    @JsonProperty("produtos")
    private List<ProdutoPedidoDTO> produtos;

}
