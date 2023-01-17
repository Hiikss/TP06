package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalTime;

public class Creneau {
	
	private LocalTime heureDebut;
	private int duree;
	private Medecin medecin;

	public Creneau(LocalTime heureDebut, int duree, Medecin medecin) {
		this.heureDebut = heureDebut;
		this.duree = duree;
		this.medecin = medecin;
		this.medecin.ajouterCreneau(this);
	}
	
	public void afficher() {
		System.out.println(this.heureDebut + " - " + this.heureDebut.plusMinutes(duree) + " (" + duree + " minutes)");
	}

	/**
	 * @return the medecin
	 */
	public Medecin getMedecin() {
		return medecin;
	}

	/**
	 * @param medecin the medecin to set
	 */
	public void setMedecin(MedecinGeneraliste medecin) {
		this.medecin = medecin;
	}
}
