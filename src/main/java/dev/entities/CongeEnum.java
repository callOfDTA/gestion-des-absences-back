package dev.entities;

public enum CongeEnum {
	CONGE_PAYE("Congé payé"), RTT("RTT"), CONGE_SS("Congé sans solde");
	private String conge;

	private CongeEnum(String conge) {
		this.conge = conge;
	}

	public String getCongeEnum() {
		return conge;
	}

	public void setCongeEnum(String conge) {
		this.conge = conge;
	}
}
