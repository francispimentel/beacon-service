package br.facens.beacon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.facens.beacon.model.LocalizacaoModel;

public interface LocalizacaoRepository extends JpaRepository<LocalizacaoModel, Long> {

}
