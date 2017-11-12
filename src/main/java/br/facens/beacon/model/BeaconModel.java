package br.facens.beacon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BeaconModel {

	@Id
	@GeneratedValue
	private Long id;

	private String uuid;

	private Integer minor;

	private Integer major;

	private String descricao;

	@ManyToOne
	private AcaoModel acaoAssociada;

	@ManyToOne
	private LocalizacaoModel localizacaoAtual;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getMinor() {
		return minor;
	}

	public void setMinor(Integer minor) {
		this.minor = minor;
	}

	public Integer getMajor() {
		return major;
	}

	public void setMajor(Integer major) {
		this.major = major;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalizacaoModel getLocalizacaoAtual() {
		return localizacaoAtual;
	}

	public void setLocalizacaoAtual(LocalizacaoModel localizacaoAtual) {
		this.localizacaoAtual = localizacaoAtual;
	}

	public AcaoModel getAcaoAssociada() {
		return acaoAssociada;
	}

	public void setAcaoAssociada(AcaoModel acaoAssociada) {
		this.acaoAssociada = acaoAssociada;
	}
}
