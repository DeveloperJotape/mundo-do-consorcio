package br.com.assemdf.consorcio.dto;

import java.time.LocalDate;

import br.com.assemdf.consorcio.entity.Carta;
import br.com.assemdf.consorcio.enums.Administradora;

public record CartaRequest(
        Double credito,
        Double entrada,
        Integer saldoDevedorQntdMeses,
        Double saldoDevedorValorMensal,
        LocalDate dataVencimento,
        String observacao,
        Administradora administradora) {

    public CartaRequest(Carta carta) {
        this(
                carta.getCredito(),
                carta.getEntrada(),
                carta.getSaldoDevedorQntdMeses(),
                carta.getSaldoDevedorValorMensal(),
                carta.getDataVencimento(),
                carta.getObservacao(),
                carta.getAdministradora());
    }

}