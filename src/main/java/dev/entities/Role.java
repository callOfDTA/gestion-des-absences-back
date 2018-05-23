package dev.entities;

//TODO: Auto-generated Javadoc
/**
 * The Enum Role.
 */
public enum Role {

	/** The administrateur. */
	ADMINISTRATEUR("admin"),

	/** The manager. */
	MANAGER("manager"),

	/** The employe. */
	EMPLOYE("employe");

	/** The role. */
	private String role;

	/**
	 * Instantiates a new role.
	 *
	 * @param role
	 *            the role
	 */
	private Role(String role) {
		this.role = role;
	}
}
