package fr.eni.ecole.quelMedecin.bo;

public class MedecinGeneraliste extends Medecin {
	
	private static int tarif = 25;
	
	public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
		super(nom, prenom, numeroDeTelephone, adresse);
	}
	
	public void afficher() {
		super.afficher();
		System.out.println("Tarif : " + MedecinGeneraliste.getTarif() + "€");
		this.afficherAdresseEtCreneaux();
	}
	
	public static int getTarif() {
		return MedecinGeneraliste.tarif;
	}
	
	public static void setTarif(int tarif) {
		MedecinGeneraliste.tarif = tarif;
	}
}
