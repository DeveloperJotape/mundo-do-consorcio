package br.com.assemdf.consorcio.dto;

import java.time.LocalDate;

import br.com.assemdf.consorcio.entity.Carta;
import br.com.assemdf.consorcio.enums.Administradora;
import br.com.assemdf.consorcio.enums.TipoCarta;

public record CartaResponse(
        Long id,
        TipoCarta tipoCarta,
        Double credito,
        Double entrada,
        Integer saldoDevedorQntdMeses,
        Double saldoDevedorValorMensal,
        LocalDate dataVencimento,
        String observacao,
        Administradora administradora,
        Boolean status) {

    public CartaResponse(Carta carta) {
        this(
                carta.getId(),
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
