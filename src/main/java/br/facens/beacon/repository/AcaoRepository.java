package br.facens.beacon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.facens.beacon.model.AcaoModel;

public interface AcaoRepository extends JpaRepository<AcaoModel, Long> {

}
