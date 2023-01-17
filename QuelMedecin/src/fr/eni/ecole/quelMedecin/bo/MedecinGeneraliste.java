package fr.eni.ecole.quelMedecin.bo;

public class MedecinGeneraliste {
	
	private String nom;
	private String prenom;
	private String numeroDeTelephone;
	
	private static int tarif = 25;
	
	public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone) {
		this.nom = nom.toUpperCase();
		this.prenom= prenom ;
		this.numeroDeTelephone = numeroDeTelephone;
	}
	
	public void afficher() {
		System.out.println(this.nom + " " + this.prenom);
		System.out.println("Téléphone : " + this.numeroDeTelephone);
		System.out.println("Tarif : " + MedecinGeneraliste.tarif + "€");
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
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNumeroDeTelephone() {
		return numeroDeTelephone;
	}
	
	public void setNumeroDeTelephone(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}

}
