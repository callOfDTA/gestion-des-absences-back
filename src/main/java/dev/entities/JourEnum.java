package dev.entities;

// TODO: Auto-generated Javadoc
/**
 * The Enum JourEnum.
 */
public enum JourEnum {

	/** The lundi. */
	LUNDI("Lundi"),
	/** The mardi. */
	MARDI("Mardi"),
	/** The mercredi. */
	MERCREDI("Mercredi"),
	/** The jeudi. */
	JEUDI("Jeudi"),
	/** The vendredi. */
	VENDREDI("Vendredi"),
	/** The samedi. */
	SAMEDI("Samedi"),
	/** The dimanche. */
	DIMANCHE("Dimanche");

	/** The jour. */
	private String jour;

	/**
	 * Instantiates a new jour enum.
	 *
	 * @param jour
	 *            the jour
	 */
	private JourEnum(String jour) {
		this.jour = jour;
	}

	/**
	 * Gets the jour.
	 *
	 * @return the jour
	 */
	public String getJour() {
		return jour;
	}

	/**
	 * Sets the jour.
	 *
	 * @param jour
	 *            the new jour
	 */
	public void setJour(String jour) {
		this.jour = jour;
	}
}
