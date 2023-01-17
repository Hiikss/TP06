package fr.eni.ecole.quelMedecin.bo;

public class MedecinGeneraliste {
	
	private String nom;
	private String prenom;
	private String numeroDeTelephone;
	private Adresse adresse;
	private Creneau[] creneaux = new Creneau[15];
	
	private static int tarif = 25;
	
	public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
		this.nom = nom.toUpperCase();
		this.prenom= prenom ;
		this.numeroDeTelephone = numeroDeTelephone;
		this.adresse = adresse;
	}
	
	public void afficher() {
		System.out.println(this.nom + " " + this.prenom);
		System.out.println("Téléphone : " + this.numeroDeTelephone);
		System.out.println("Tarif : " + MedecinGeneraliste.tarif + "€");
		System.out.println("Adresse :");
		this.adresse.afficher();
		System.out.println("Créneaux :");
		for(int i=0; i<this.creneaux.length; i++) {
			if(this.creneaux[i]!=null)
				this.creneaux[i].afficher();
		}
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
	
	public static int getTarif() {
		return MedecinGeneraliste.tarif;
	}
	
	public static void setTarif(int tarif) {
		MedecinGeneraliste.tarif = tarif;
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

}
