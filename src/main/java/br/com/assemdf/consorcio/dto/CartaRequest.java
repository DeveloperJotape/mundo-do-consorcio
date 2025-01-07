package br.com.assemdf.consorcio.dto;

import java.time.LocalDate;

import br.com.assemdf.consorcio.entity.Carta;
import br.com.assemdf.consorcio.enums.Administradora;
import br.com.assemdf.consorcio.enums.TipoCarta;

public record CartaRequest(
        TipoCarta tipoCarta,
        Double credito,
        Double entrada,
        Integer saldoDevedorQntdMeses,
        Double saldoDevedorValorMensal,
        LocalDate dataVencimento,
        String observacao,
        Administradora administradora,
        Boolean status) {

    public CartaRequest(Carta carta) {
        this(
                carta.getTipoCarta(),
                carta.getCredito(),
                carta.getEntrada(),
                carta.getSaldoDevedorQntdMeses(),
                carta.getSaldoDevedorValorMensal(),
                carta.getDataVencimento(),
                carta.getObservacao(),
                carta.getAdministradora(),
                carta.getStatus());
    }

}