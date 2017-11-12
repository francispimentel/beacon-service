package br.facens.beacon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.facens.beacon.model.BeaconModel;

public interface BeaconRepository extends JpaRepository<BeaconModel, Long> {
	
	List<BeaconModel> findByUuid(String uuid);
}
