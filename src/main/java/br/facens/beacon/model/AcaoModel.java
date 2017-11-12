package br.facens.beacon.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.facens.beacon.enums.AcaoEnum;

@Entity
public class AcaoModel {

	@Id
	@GeneratedValue
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private AcaoEnum acao;
	
	private String informacaoExtra;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AcaoEnum getAcao() {
		return acao;
	}

	public void setAcao(AcaoEnum acao) {
		this.acao = acao;
	}

	public String getInformacaoExtra() {
		return informacaoExtra;
	}

	public void setInformacaoExtra(String informacaoExtra) {
		this.informacaoExtra = informacaoExtra;
	}
}
