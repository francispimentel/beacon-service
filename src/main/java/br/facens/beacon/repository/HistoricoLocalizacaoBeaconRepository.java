package br.facens.beacon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.facens.beacon.model.BeaconModel;
import br.facens.beacon.model.HistoricoLocalizacaoBeaconModel;
import br.facens.beacon.model.LocalizacaoModel;

public interface HistoricoLocalizacaoBeaconRepository extends JpaRepository<HistoricoLocalizacaoBeaconModel, Long> {

	List<HistoricoLocalizacaoBeaconModel> findByBeaconAndLocalizacao(BeaconModel beacon, LocalizacaoModel localizacao);
}
