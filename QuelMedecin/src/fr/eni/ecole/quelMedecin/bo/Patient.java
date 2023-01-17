package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Patient {

	private String nom;
	private String prenom;
	private String numeroDeTelephone;
	private char sexe;
	private long numeroSecu;
	private LocalDate dateDeNaissance;
	private String commentaires;
	private Adresse adresse;
	
	public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numeroSecu, LocalDate dateDeNaissance, String commentaires, Adresse adresse) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom;
		this.numeroDeTelephone = numeroDeTelephone;
		this.sexe = sexe;
		this.numeroSecu = numeroSecu;
		this.dateDeNaissance = dateDeNaissance;
		this.commentaires = commentaires;
		this.adresse = adresse;
	}
	
	public void afficher() {
		System.out.println(this.nom + " " + this.prenom);
		System.out.println("Téléphone : " + this.numeroDeTelephone);
		if(this.sexe=='M')
			System.out.println("Sexe : Masculin");
		else
			System.out.println("Sexe : Feminin");
		System.out.println("Numéro de Sécurité sociale : " + this.numeroSecu);
		System.out.println("Date de naissance : " + this.dateDeNaissance.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
		if(this.commentaires!=null)
			System.out.println("Commentaires : " + this.commentaires);
		else
			System.out.println("Commentaires : [aucun commentaire]");
		System.out.println("Adresse :");
		this.adresse.afficher();
	}
}
