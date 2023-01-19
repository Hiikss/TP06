package fr.thomas.reversi;

import java.util.Scanner;

public enum Pion {
	LIBRE, NOIR, BLANC;
	
	private int nombre=2;
	private Joueur joueur;
	
	Scanner input = new Scanner(System.in);
	
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
	
	public void gagne(int pions) {
		this.nombre += pions;
	}
	
	public void choixJoueur() {
		System.out.println("Qui joue les pions " + this.getSymbole() + " ? 1 = humain; 2 = ordinateur");
		int saisie = 0;
		do {
			try {
				saisie = Integer.parseInt(input.nextLine());
				if(saisie==1 || saisie==2)
					break;
			}
			catch(NumberFormatException  e) {
			}
			System.err.println("Veuillez saisir une valeur correcte");
		} while(true);
		
		this.joueur = new JoueurHumain();
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
