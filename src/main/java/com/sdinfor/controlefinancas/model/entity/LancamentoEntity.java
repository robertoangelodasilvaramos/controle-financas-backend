package com.sdinfor.controlefinancas.model.entity;

import com.sdinfor.controlefinancas.model.enums.StatusEnum;
import com.sdinfor.controlefinancas.model.enums.TipoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "lancamento", schema = "financas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LancamentoEntity {

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

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuarioEntity;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "data_cadastro")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate dataCadastro;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoEnum tipo;


    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum statusEnum;
}
