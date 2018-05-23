package dev.entities;

public enum StatutEnum {
	INITIALE("INITIALE"), EN_ATTENTE_VALIDATION("EN_ATTENTE_VALIDATION"), VALIDEE("VALIDEE"), REJETEE("REJETEE");
	private String statut;

	private StatutEnum(String statut) {
		this.statut = statut;
	}

	public String getStatutEnum() {
		return statut;
	}

	public void setStatutEnum(String statut) {
		this.statut = statut;
	}
}
