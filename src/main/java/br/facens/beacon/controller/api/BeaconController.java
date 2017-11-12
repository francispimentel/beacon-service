package br.facens.beacon.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facens.beacon.model.BeaconModel;
import br.facens.beacon.model.UsuarioBeaconModel;
import br.facens.beacon.repository.BeaconRepository;

@RestController
@RequestMapping("api/beacon")
public class BeaconController {

	@Autowired
	private BeaconRepository beaconRepository;

	@GetMapping
	public List<BeaconModel> buscarTodos() {
		return beaconRepository.findAll();
	}

	@GetMapping("{uuid}")
	public BeaconModel buscarPorUuid(@PathVariable("uuid") String uuid) {
		return beaconRepository.findByUuid(uuid);
	}
	
	@PostMapping("registrarBeaconsVistos")
	public List<BeaconModel> registrarBeaconsVistos(@RequestBody List<UsuarioBeaconModel> request) {
		return beaconRepository.findAll();
	}
}