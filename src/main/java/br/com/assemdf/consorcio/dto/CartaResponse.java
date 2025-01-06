package br.com.assemdf.consorcio.dto;

import java.time.LocalDate;

import br.com.assemdf.consorcio.entity.Carta;
import br.com.assemdf.consorcio.enums.Administradora;

public record CartaResponse(
        Long id,
        Double credito,
        Double entrada,
        Integer saldoDevedorQntdMeses,
        Double saldoDevedorValorMensal,
        LocalDate dataVencimento,
        String observacao,
        Administradora administradora) {

    public CartaResponse(Carta carta) {
        this(
                carta.getId(),
                carta.getCredito(),
                carta.getEntrada(),
                carta.getSaldoDevedorQntdMeses(),
                carta.getSaldoDevedorValorMensal(),
                carta.getDataVencimento(),
                carta.getObservacao(),
                carta.getAdministradora());
    }

}
