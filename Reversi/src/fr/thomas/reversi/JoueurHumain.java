package fr.thomas.reversi;

import java.util.Scanner;

public class JoueurHumain implements Joueur{

	private String nom;
	
	Scanner input = new Scanner(System.in);
	
	public JoueurHumain() {
		System.out.println("Quel est le nom du joueur ?");
		this.nom = input.nextLine();
	}

	@Override
	public int[] jouer(PlateauDeReversi plateau, Pion pion) {
		int[] co = new int[2];
		System.out.print("ligne ");
		co[0] = Saisie.getInt(1, PlateauDeReversi.SIZE)-1;
		System.out.print("colonne ");
		co[1] = Saisie.getInt(1, PlateauDeReversi.SIZE)-1;
		return co;
	}

	@Override
	public String getNom() {
		return this.nom;
	}

}
