package fr.thomas.maximot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Maximot {
	
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Tirage tirage = new Tirage();
		System.out.println("Les lettres du mot sont : ");
		tirage.afficherLettres();
		//Récupération de la saisie d'un mot
		String motSaisi = input.nextLine();
		if(tirage.verifLettres(motSaisi))
		{
			if(Dictionnaire.motExiste(motSaisi))
			{
				System.out.println("Bravo");
			}
			else {
				System.out.println("Le mot n'est pas valide");
			}
		}
		else {
			System.out.println("Le mot contient des lettres invalides");
		}
		
		System.out.println("Le mot tiré au sort était : " + tirage.getMot());
	}

}
