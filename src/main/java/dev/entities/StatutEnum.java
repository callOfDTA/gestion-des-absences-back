package dev.entities;

// TODO: Auto-generated Javadoc
/**
 * The Enum StatutEnum.
 */
public enum StatutEnum {

	/** The initiale. */
	INITIALE("INITIALE"),
	/** The en attente validation. */
	EN_ATTENTE_VALIDATION("EN_ATTENTE_VALIDATION"),
	/** The validee. */
	VALIDEE("VALIDEE"),
	/** The rejetee. */
	REJETEE("REJETEE");

	/** The statut. */
	private String statut;

	/**
	 * Instantiates a new statut enum.
	 *
	 * @param statut
	 *            the statut
	 */
	private StatutEnum(String statut) {
		this.statut = statut;
	}

	/**
	 * Gets the statut enum.
	 *
	 * @return the statut enum
	 */
	public String getStatutEnum() {
		return statut;
	}

	/**
	 * Sets the statut enum.
	 *
	 * @param statut
	 *            the new statut enum
	 */
	public void setStatutEnum(String statut) {
		this.statut = statut;
	}
}
