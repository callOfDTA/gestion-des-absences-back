package dev.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class JourFerie.
 */
@Entity
@Table(name = "jour_ferie")
public class JourFerie {
	/** The id. */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The date. */
	@Column(name = "DATE")
	private String date;

	/** The commentaire. */
	@Column(name = "COMMENTAIRE")
	private String commentaire;

	/**
	 * Instantiates a new jour ferie.
	 */
	public JourFerie() {
		super();
	}

	/**
	 * Instantiates a new jour ferie.
	 *
	 * @param date
	 *            the date
	 * @param jour
	 *            the jour
	 * @param commentaire
	 *            the commentaire
	 */
	public JourFerie(String date, String commentaire) {
		super();
		this.date = date;
		this.commentaire = commentaire;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date
	 *            the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Gets the jour.
	 *
	 * @return the jour
	 */

	/**
	 * Gets the commentaire.
	 *
	 * @return the commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * Sets the commentaire.
	 *
	 * @param commentaire
	 *            the new commentaire
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

}
