package fr.thomas.reversi;

import java.util.ArrayList;
import java.util.List;

public class Plateau<T extends Affichable> {
	
	private int largeur;
	private int hauteur;
	private List<T> plateau;

	public Plateau(int lignes, int colonnes, T valeurInitiale) {
		this.largeur = colonnes;
		this.hauteur = lignes;
		this.plateau = new ArrayList<>(this.hauteur * this.largeur);
		for(int i=0; i < this.hauteur * this.largeur; i++)
			this.plateau.add(valeurInitiale);
	}
	
	public void afficher() {
		System.out.print("  ");
		for(int i = 1; i <= this.largeur; i++)
			System.out.print(i + " ");
		System.out.println();
		for(int l = 0; l < this.hauteur; l++) {
			System.out.print(l+1);
			for(int c = 0; c < this.largeur; c++) {
				System.out.print(" " + this.getCase(l, c).getSymbole());
			}
			System.out.println();
		}
	}
	
	public T getCase(int ligne, int colonne) {
		return this.plateau.get(ligne * this.largeur + colonne);
	}
	
	public void setCase(int ligne, int colonnes, T valCase) {
		this.plateau.set(ligne * this.largeur + colonnes, valCase);
	}
}
