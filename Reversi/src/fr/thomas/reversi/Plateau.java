package fr.thomas.reversi;

import java.util.List;

public class Plateau<T> implements Affichable {
	
	private int largeur;
	private int hauteur;
	private List<T> pions;

	public Plateau(int ligne, int colonnes, T valCase) {
		this.pions.add(ligne*this.largeur+colonnes, valCase);
	}
	
	public void afficher() {
		
	}
	
	public T getCase() {
		return null;
	}
	
	public void setCase() {
		
	}

	@Override
	public char getSymbole() {
		// TODO Auto-generated method stub
		return 0;
	}

}
