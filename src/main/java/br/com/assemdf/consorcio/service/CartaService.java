package br.com.assemdf.consorcio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.assemdf.consorcio.dto.CartaRequest;
import br.com.assemdf.consorcio.dto.CartaResponse;
import br.com.assemdf.consorcio.entity.Carta;
import br.com.assemdf.consorcio.repository.CartaRepository;

@Service
public class CartaService {

    @Autowired
    private CartaRepository cartaRepository;

    public CartaResponse save(CartaRequest cartaRequest) {
        Carta carta = new Carta(cartaRequest);
        cartaRepository.save(carta);
        return new CartaResponse(carta);
    }

    public List<CartaResponse> findAll() {
        return this.cartaRepository.findAll().stream().map(CartaResponse::new).toList();
    }

    public CartaResponse findById(Long id) {
        return new CartaResponse(cartaRepository.findById(id).get());
    }

    public CartaResponse update(Long id, CartaRequest cartaRequest) {
        var idCarta = cartaRepository.findById(id);
        if (idCarta.isPresent()) {
            var carta = idCarta.get();
            if (carta.getCredito() != null) {
                carta.setCredito(cartaRequest.credito());
            }
            if (carta.getEntrada() != null) {
                carta.setEntrada(cartaRequest.entrada());
            }
            if (carta.getSaldoDevedorQntdMeses() != null) {
                carta.setSaldoDevedorQntdMeses(cartaRequest.saldoDevedorQntdMeses());
            }
            if (carta.getSaldoDevedorValorMensal() != null) {
                carta.setSaldoDevedorValorMensal(cartaRequest.saldoDevedorValorMensal());
            }
            if (carta.getDataVencimento() != null) {
                carta.setDataVencimento(cartaRequest.dataVencimento());
            }
            if (carta.getObservacao() != null) {
                carta.setObservacao(cartaRequest.observacao());
            }
            if (carta.getAdministradora() != null) {
                carta.setAdministradora(cartaRequest.administradora());
            }
            return new CartaResponse(cartaRepository.save(carta));
        }
        return null;
    }

    public void delete(Long id) {
        var carta = cartaRepository.existsById(id);
        if (carta) {
            cartaRepository.deleteById(id);
        }
    }

}
