package br.com.assemdf.consorcio.entity;

import java.time.LocalDate;

import br.com.assemdf.consorcio.dto.CartaRequest;
import br.com.assemdf.consorcio.enums.Administradora;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_carta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Carta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double credito;

    @Column(nullable = false)
    private Double entrada;

    @Column(nullable = false)
    private Integer saldoDevedorQntdMeses;

    @Column(nullable = false)
    private Double saldoDevedorValorMensal;

    @Column(nullable = false)
    @Future
    private LocalDate dataVencimento;

    private String observacao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Administradora administradora;

    public Carta(CartaRequest carta) {
        this.credito = carta.credito();
        this.entrada = carta.entrada();
        this.saldoDevedorQntdMeses = carta.saldoDevedorQntdMeses();
        this.saldoDevedorValorMensal = carta.saldoDevedorValorMensal();
        this.dataVencimento = carta.dataVencimento();
        this.observacao = carta.observacao();
        this.administradora = carta.administradora();
    }

}
