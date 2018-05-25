package dev.entities;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Collaborateur.
 */
@Entity
@Table(name = "Collaborateur")
public class Collaborateur {

	/** The id. */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** The role. */
	@Column(name = "ROLE")
	@Enumerated(EnumType.STRING)
	private Role role;

	/** The matricule. */
	@Column(name = "MATRICULE", unique = true)
	private String matricule;

	/** The nom. */
	@Column(name = "NOM")
	private String nom;

	/** The prenom. */
	@Column(name = "PRENOM")
	private String prenom;

	/** The email. */
	@Column(name = "EMAIL")
	private String email;

	/** The password. */
	@Column(name = "PASSWORD")
	private String password;

	/** The date naissance. */

	@Column(name = "DATE_NAISSANCE")
	private String dateNaissance;

	/** The sexe. */
	@Column(name = "SEXE")
	@Enumerated(EnumType.STRING)
	private Sexe sexe;

	/** The adresse. */
	@Column(name = "ADRESSE")
	private String adresse;

	/** The photo. */
	@Column(name = "PHOTO")
	private String photo;

	/** The sulbaternes. */
	@Column(name = "SUBALTERNES")
	private ArrayList<String> subalternes;

	/** The departements. */
	@Column(name = "DEPARTEMENT")
	private String departement;

	/** The jour RTT. */
	@Column(name = "JOUR_RTT_EMPLOYE")
	private int jourRTTEmploye;

	/** The jour RTT. */
	@Column(name = "JOUR_RTT_EMPLOYEUR")
	private int jourRTTEmployeur;

	/** The jour conge paye. */
	@Column(name = "JOUR_CONGE_PAYE")
	private int jourCongePaye;

	/**
	 * Instantiates a new collaborateur.
	 */
	public Collaborateur() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param role
	 * @param matricule
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param password
	 * @param dateNaissance
	 * @param sexe
	 * @param adresse
	 * @param photo
	 * @param subalternes
	 * @param departement
	 * @param jourRTTEmploye
	 * @param jourRTTEmployeur
	 * @param jourCongePaye
	 */
	public Collaborateur(Role role, String matricule, String nom, String prenom, String email, String password,
			String dateNaissance, Sexe sexe, String adresse, String photo, ArrayList<String> subalternes,
			String departement, int jourRTTEmploye, int jourRTTEmployeur, int jourCongePaye) {
		super();
		this.role = role;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.adresse = adresse;
		this.photo = photo;
		this.subalternes = subalternes;
		this.departement = departement;
		this.jourRTTEmploye = jourRTTEmploye;
		this.jourRTTEmployeur = jourRTTEmployeur;
		this.jourCongePaye = jourCongePaye;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Gets the matricule.
	 *
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * Sets the matricule.
	 *
	 * @param matricule
	 *            the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets the nom.
	 *
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Gets the prenom.
	 *
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Sets the prenom.
	 *
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the date naissance.
	 *
	 * @return the dateNaissance
	 */

	public String getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * Sets the date naissance.
	 *
	 * @param dateNaissance
	 *            the dateNaissance to set
	 */

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * Gets the sexe.
	 *
	 * @return the sexe
	 */
	public Sexe getSexe() {
		return sexe;
	}

	/**
	 * Sets the sexe.
	 *
	 * @param sexe
	 *            the sexe to set
	 */
	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	/**
	 * Gets the adresse.
	 *
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Sets the adresse.
	 *
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Gets the photo.
	 *
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Sets the photo.
	 *
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * Gets the departements.
	 *
	 * @return the departements
	 */
	public String getDepartement() {
		return departement;
	}

	/**
	 * Sets the departements.
	 *
	 * @param departement
	 *            the new departement
	 */
	public void setDepartement(String departement) {
		this.departement = departement;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the subalternes.
	 *
	 * @return the subalternes
	 */
	public ArrayList<String> getSubalternes() {
		return subalternes;
	}

	/**
	 * Sets the subalternes.
	 *
	 * @param subalternes
	 *            the subalternes to set
	 */
	public void setSubalternes(ArrayList<String> subalternes) {
		this.subalternes = subalternes;
	}

	/**
	 * @return the jourRTTEmploye
	 */
	public int getJourRTTEmploye() {
		return jourRTTEmploye;
	}

	/**
	 * @param jourRTTEmploye
	 *            the jourRTTEmploye to set
	 */
	public void setJourRTTEmploye(int jourRTTEmploye) {
		this.jourRTTEmploye = jourRTTEmploye;
	}

	/**
	 * @return the jourRTTEmployeur
	 */
	public int getJourRTTEmployeur() {
		return jourRTTEmployeur;
	}

	/**
	 * @param jourRTTEmployeur
	 *            the jourRTTEmployeur to set
	 */
	public void setJourRTTEmployeur(int jourRTTEmployeur) {
		this.jourRTTEmployeur = jourRTTEmployeur;
	}

	/**
	 * Gets the jour conge paye.
	 *
	 * @return the jour conge paye
	 */
	public int getJourCongePaye() {
		return jourCongePaye;
	}

	/**
	 * Sets the jour conge paye.
	 *
	 * @param jourCongePaye
	 *            the new jour conge paye
	 */
	public void setJourCongePaye(int jourCongePaye) {
		this.jourCongePaye = jourCongePaye;
	}
}
