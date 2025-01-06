package br.com.assemdf.consorcio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.assemdf.consorcio.dto.CartaRequest;
import br.com.assemdf.consorcio.dto.CartaResponse;
import br.com.assemdf.consorcio.service.CartaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/carta")
@CrossOrigin
public class CartaController {

    @Autowired
    private CartaService cartaService;

    @PostMapping("/save")
    @Transactional
    public ResponseEntity<CartaResponse> save(@RequestBody @Valid CartaRequest cartaRequest) {
        try {
            cartaService.save(cartaRequest);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<CartaResponse>> findAll() {
        try {
            List<CartaResponse> listAll = cartaService.findAll();
            if (listAll.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(listAll, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<CartaResponse> findById(@PathVariable Long id) {
        try {
            var carta = cartaService.findById(id);
            return new ResponseEntity<>(carta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    @Transactional
    public ResponseEntity<CartaResponse> update(@PathVariable Long id,
            @RequestBody @Valid CartaRequest cartaRequest) {
        try {
            cartaService.update(id, cartaRequest);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            cartaService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
