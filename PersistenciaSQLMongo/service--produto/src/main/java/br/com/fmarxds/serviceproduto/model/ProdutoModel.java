package br.com.fmarxds.serviceproduto.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produto")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProdutoModel {

    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "codigo", unique = true, nullable = false)
    private String codigo;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    public boolean removerDoEstoque(Integer quantidade) {
        if (this.quantidade < quantidade) {
            return false;
        }
        this.quantidade -= quantidade;
        return true;
    }

}
