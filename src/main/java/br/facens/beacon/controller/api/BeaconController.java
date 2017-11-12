package br.facens.beacon.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facens.beacon.dto.UsuarioBeaconDto;
import br.facens.beacon.service.BeaconService;

@RestController
@RequestMapping("api/beacon")
public class BeaconController {

	@Autowired
	private BeaconService beaconService;

	@PostMapping("registrarBeaconsVistos")
	public UsuarioBeaconDto registrarBeaconsVistos(@RequestBody UsuarioBeaconDto req) {
		return beaconService.registrarBeaconsVistos(req);
	}
}