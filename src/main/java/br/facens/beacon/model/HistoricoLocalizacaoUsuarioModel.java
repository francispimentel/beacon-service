package br.facens.beacon.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HistoricoLocalizacaoUsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private UsuarioModel usuario;

	@ManyToOne
	private BeaconModel beacon;

	@ManyToOne
	private LocalizacaoModel localizacao;

	private Date data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public LocalizacaoModel getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(LocalizacaoModel localizacao) {
		this.localizacao = localizacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BeaconModel getBeacon() {
		return beacon;
	}

	public void setBeacon(BeaconModel beacon) {
		this.beacon = beacon;
	}
}
