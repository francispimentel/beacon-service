package br.facens.beacon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.facens.beacon.model.BeaconModel;

public interface BeaconRepository extends JpaRepository<BeaconModel, Long> {

	BeaconModel findByUuid(String uuid);
}
