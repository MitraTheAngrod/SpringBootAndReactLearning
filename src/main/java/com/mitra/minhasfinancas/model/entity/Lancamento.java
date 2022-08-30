package com.mitra.minhasfinancas.model.entity;

import com.mitra.minhasfinancas.model.enums.StatusLancamento;
import com.mitra.minhasfinancas.model.enums.TipoLancamento;
import lombok.*;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table (name = "lancamento", schema = "financas")
// Data is used to generate getters, setters, hashCode, equals, toString and constructors
@Data
// Builder is similar to a constructor, useful in some situations
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lancamento {

    // Attributes and Mapping
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "mes")
    private Integer mes;

    @Column(name = "ano")
    private Integer ano;

    // Indicates relationship between "Lancamento" and "Usuario"
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "valor")
    private BigDecimal valor;

    // Converts Java LocalDate format to match the database date format
    @Column(name = "data_cadastro")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate dataCadastro;

    @Column(name = "tipo")
    @Enumerated(value = EnumType.STRING)
    private TipoLancamento tipo;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private StatusLancamento status;
}
