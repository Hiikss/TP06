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
	public void jouer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNom() {
		return this.nom;
	}

}
