package br.com.assemdf.consorcio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.assemdf.consorcio.entity.Carta;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Long> {

}
