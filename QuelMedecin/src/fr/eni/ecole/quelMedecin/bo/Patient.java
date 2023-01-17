package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Patient extends Personne{

	private char sexe;
	private long numeroSecu;
	private LocalDate dateDeNaissance;
	private String commentaires;
	
	public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numeroSecu, LocalDate dateDeNaissance, String commentaires, Adresse adresse) {
		super(nom, prenom, numeroDeTelephone, adresse);
		this.sexe = sexe;
		this.numeroSecu = numeroSecu;
		this.dateDeNaissance = dateDeNaissance;
		this.commentaires = commentaires;
	}
	
	public void afficher() {
		super.afficher();
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
		this.adresse.afficher();
	}
}
