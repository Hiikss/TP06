package fr.eni.ecole.quelMedecin.bo;

public class Medecin extends Personne{
	
	private Creneau[] creneaux = new Creneau[15];

	public Medecin(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
		super(nom, prenom, numeroDeTelephone, adresse);
		// TODO Auto-generated constructor stub
	}
	
	public void ajouterCreneau(Creneau creneau) {
		if(this==creneau.getMedecin()) {
			int pos = 0;
			while(this.creneaux[pos]!=null && this.creneaux.length>pos) {
				pos++;
			}
			this.creneaux[pos] = creneau;
		}
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNumeroDeTelephone() {
		return numeroDeTelephone;
	}
	
	public void setNumeroDeTelephone(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}
	
	public void afficherAdresseEtCreneaux() {
		this.adresse.afficher();
		System.out.println("Créneaux :");
		for(int i=0; i<this.creneaux.length; i++) {
			if(this.creneaux[i]!=null)
				this.creneaux[i].afficher();
		}
	}
}
