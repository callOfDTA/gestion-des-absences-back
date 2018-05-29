package dev.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Absence.
 */
@Entity
@Table(name = "Absence")
public class Absence {

	/** The id. */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The date debut. */
	@Column(name = "DATE_DEBUT")
	private String dateDebut;

	/** The date fin. */
	@Column(name = "DATE_FIN")
	private String dateFin;

	/** The type conge. */
	@Column(name = "TYPE_CONGE")
	@Enumerated(EnumType.STRING)
	private CongeEnum typeConge;

	/** The motif. */
	@Column(name = "MOTIF")
	private String motif;

	/** The statut. */
	@Column(name = "STATUT")
	@Enumerated(EnumType.STRING)
	private StatutEnum statut;

	@ManyToOne
	@JoinColumn(name = "COLLABORATEUR_ID")
	private Collaborateur collaborateur;

	/**
	 * Instantiates a new absence.
	 */
	public Absence() {
	}

	public Absence(String dateDebut, String dateFin, CongeEnum typeConge, String motif, StatutEnum statut,
			Collaborateur collaborateur) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.typeConge = typeConge;
		this.motif = motif;
		this.statut = statut;
		this.collaborateur = collaborateur;
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
	 * Gets the date debut.
	 *
	 * @return the date debut
	 */
	public String getDateDebut() {
		return dateDebut;
	}

	/**
	 * Sets the date debut.
	 *
	 * @param dateDebut
	 *            the new date debut
	 */
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Gets the date fin.
	 *
	 * @return the date fin
	 */
	public String getDateFin() {
		return dateFin;
	}

	/**
	 * Sets the date fin.
	 *
	 * @param dateFin
	 *            the new date fin
	 */
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * Gets the type conge.
	 *
	 * @return the type conge
	 */
	public CongeEnum getTypeConge() {
		return typeConge;
	}

	/**
	 * Sets the type conge.
	 *
	 * @param typeConge
	 *            the new type conge
	 */
	public void setTypeConge(CongeEnum typeConge) {
		this.typeConge = typeConge;
	}

	/**
	 * Gets the motif.
	 *
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * Sets the motif.
	 *
	 * @param motif
	 *            the new motif
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/**
	 * Gets the statut.
	 *
	 * @return the statut
	 */
	public StatutEnum getStatut() {
		return statut;
	}

	/**
	 * Sets the statut.
	 *
	 * @param statut
	 *            the new statut
	 */
	public void setStatut(StatutEnum statut) {
		this.statut = statut;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

}
