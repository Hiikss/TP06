package fr.thomas.reversi;

import java.util.Random;

public class JoueurIA implements Joueur{
	
	private Random rdm = new Random();

	@Override
	public int[] jouer(PlateauDeReversi plateau, Pion pion) {
		int[] co = new int[2];
		do {
			co[0] = rdm.nextInt(PlateauDeReversi.SIZE);
			co[1] = rdm.nextInt(PlateauDeReversi.SIZE);
		} while(plateau.tester(pion, co[0], co[1])==0);
		return co;
	}

	@Override
	public String getNom() {
		return "IA";
	}

}
