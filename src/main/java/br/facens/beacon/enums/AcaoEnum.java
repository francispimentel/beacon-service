package br.facens.beacon.enums;

public enum AcaoEnum {
	EXIBIR_MENSAGEM(1);

	private Integer id;

	private AcaoEnum(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
