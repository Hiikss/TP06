package fr.thomas.reversi;

public interface Joueur {

	public int[] jouer(PlateauDeReversi plateau, Pion pion);
	
	public String getNom();
}
