package dev.entities;

// TODO: Auto-generated Javadoc
/**
 * The Enum CongeEnum.
 */
public enum CongeEnum {

	/** The conge paye. */
	CONGE_PAYE("Congé payé"),
	/** The rtt. */
	RTT("RTT"),
	/** The conge sans solde. */
	CONGE_SANS_SOLDE("Congé sans solde"),
	/** The mission. */
	MISSION("Mission");

	/** The conge. */
	private String conge;

	/**
	 * Instantiates a new conge enum.
	 *
	 * @param conge
	 *            the conge
	 */
	private CongeEnum(String conge) {
		this.conge = conge;
	}

	/**
	 * Gets the conge enum.
	 *
	 * @return the conge enum
	 */
	public String getCongeEnum() {
		return conge;
	}

	/**
	 * Sets the conge enum.
	 *
	 * @param conge
	 *            the new conge enum
	 */
	public void setCongeEnum(String conge) {
		this.conge = conge;
	}
}
