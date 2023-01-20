package fr.thomas.reversi;

public enum Pion {
	LIBRE, NOIR, BLANC;
	
	private int nombre = 2;
	private Joueur joueur;
	
	/**
	 * Retourne le symbole du pion
	 * @return
	 */
	public char getSymbole() {
		switch(this) {
		case NOIR :
			return '●';
		case BLANC :
			return 'o';
		default :
			return '·';
		}
	}
	
	/**
	 * Retourne le pion opposé
	 * @return pion opposé
	 */
	public Pion autrePion() {
		switch(this) {
		case NOIR :
			return BLANC;
		case BLANC :
			return NOIR;
		default :
			return LIBRE;
		}
	}
	
	/**
	 * 
	 * @param pions
	 */
	public void gagne(int pions) {
		this.nombre += pions;
	}
	
	/**
	 * Choisi qui jouera entre un joueur humain et une IA
	 */
	public void choixJoueur() {
		System.out.println("Qui joue les pions " + this.getSymbole() + " ? 1 = humain; 2 = ordinateur");
		int saisie = Saisie.getInt(1, 2);
		if(saisie==1)
			this.joueur = new JoueurHumain();
		else
			this.joueur = new JoueurIA();
	}
	
	/**
	 * @return the nombre
	 */
	public int getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the joueur
	 */
	public Joueur getJoueur() {
		return joueur;
	}

	/**
	 * @param joueur the joueur to set
	 */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
}
