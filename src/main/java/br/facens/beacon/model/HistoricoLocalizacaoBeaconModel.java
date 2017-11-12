package br.facens.beacon.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HistoricoLocalizacaoBeaconModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private BeaconModel beacon;

	@ManyToOne
	private LocalizacaoModel localizacao;

	private Date desde;

	private Date ate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BeaconModel getBeacon() {
		return beacon;
	}

	public void setBeacon(BeaconModel beacon) {
		this.beacon = beacon;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getAte() {
		return ate;
	}

	public void setAte(Date ate) {
		this.ate = ate;
	}

	public LocalizacaoModel getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(LocalizacaoModel localizacao) {
		this.localizacao = localizacao;
	}
}
