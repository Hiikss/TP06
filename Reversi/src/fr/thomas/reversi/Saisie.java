package fr.thomas.reversi;

import java.util.Scanner;

public class Saisie {
	
	static Scanner input = new Scanner(System.in);

	/**
	 * Retourne un entier saisi qui doit être dans un intervalle
	 * @param min Borne minimale
	 * @param max Borne Maximale
	 * @return la valeur saisie
	 */
	public static int getInt(int min, int max) {
		int saisie;
		do {
			try {
				saisie = Integer.parseInt(input.nextLine());
				if(saisie>=min && saisie<=max)
					return saisie;
			}
			catch(NumberFormatException  e) {
			}
			System.err.println("Veuillez saisir une valeur correcte");
		} while(true);
	}

}
