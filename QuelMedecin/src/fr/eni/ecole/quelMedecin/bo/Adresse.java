package fr.eni.ecole.quelMedecin.bo;

public class Adresse {

	private String mentions;
	private int numeroVoie;
	private String complementNum;
	private String nomVoie;
	private int codePostal;
	private String commune;

	public Adresse(String mentions, int numeroVoie, String complementNum, String nomVoie, int codePostal, String commune) {
		this.mentions = mentions;
		this.numeroVoie = numeroVoie;
		this.complementNum = complementNum;
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.commune = commune.toUpperCase();
	}
	
	public Adresse(int numeroVoie, String complementNum, String nomVoie, int codePostal, String commune) {
		this(null, numeroVoie, complementNum, nomVoie, codePostal, commune);
	}
	
	public void afficher() {
		if(this.mentions!=null)
			System.out.println(this.mentions);
		System.out.print(this.numeroVoie);
		if(complementNum!=null)
			System.out.print(this.complementNum);
		System.out.println(" " + this.nomVoie);
		System.out.println(this.codePostal + " " + this.commune);
	}
}