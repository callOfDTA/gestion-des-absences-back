package dev.entities.modelView;

import java.time.ZonedDateTime;

import dev.entities.CongeEnum;
import dev.entities.StatutEnum;

public class AbsenceMV {
	private ZonedDateTime dateDebut;
	private ZonedDateTime dateFin;
	private CongeEnum typeConge;
	private StatutEnum statut;
	private String motif;

	public AbsenceMV(ZonedDateTime dateDebut, ZonedDateTime dateFin, CongeEnum typeConge, StatutEnum statut,
			String motif) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.typeConge = typeConge;
		this.statut = statut;
		this.motif = motif;
	}

	public ZonedDateTime getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(ZonedDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	public ZonedDateTime getDateFin() {
		return dateFin;
	}

	public void setDateFin(ZonedDateTime dateFin) {
		this.dateFin = dateFin;
	}

	public CongeEnum getTypeConge() {
		return typeConge;
	}

	public void setTypeConge(CongeEnum typeConge) {
		this.typeConge = typeConge;
	}

	public StatutEnum getStatut() {
		return statut;
	}

	public void setStatut(StatutEnum statut) {
		this.statut = statut;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

}
