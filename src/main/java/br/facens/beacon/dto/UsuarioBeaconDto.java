package br.facens.beacon.dto;

import java.util.List;

import br.facens.beacon.model.BeaconModel;

public class UsuarioBeaconDto {

	private Long usuario;

	private List<BeaconModel> beacons;

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	public List<BeaconModel> getBeacons() {
		return beacons;
	}

	public void setBeacons(List<BeaconModel> beacons) {
		this.beacons = beacons;
	}
}
