package fr.thomas.module07;

import java.math.BigInteger;
import java.util.Scanner;

public class Calculatrice {
	
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int valeur1 = getInt();
		int valeur2;
		int resultat = 0;
		char choix = 0;
		do {
			choix = getChoice();
			if(choix=='q')
				break;
			valeur2 = getInt();
			try {
				switch(choix) {
				case '+' :
					resultat = Operation.ajouter(valeur1, valeur2);
					break;
				case '-' :
					resultat = Operation.soustraire(valeur1, valeur2);
					break;
				case '*' :
					resultat = Operation.multiplier(valeur1, valeur2);
					break;
				case '/' :
					resultat = valeur1/valeur2;
					break;
				case '%' :
					resultat = valeur1%valeur2;
					break;
				}
			System.out.printf("%d %s %d = %d\n", valeur1, choix, valeur2, resultat);
			}
			catch (DepassementCapaciteException e){
				System.err.println(e.getMessage());
			}
			catch (ArithmeticException e){
				System.err.println("La division par zéro n'est pas définie !");
			}
			
			valeur1 = getInt();
		} while(true);
	}

	private static char getChoice() {
		String result = null;
		do
		{
			System.out.println("opérateur ? (+ - * / % ou q pour quitter)");
			result = input.nextLine();
			if(result.matches("[-+*%/q]") && result.length()==1)
				return result.charAt(0);
			System.err.println("Opérateur invalide");
		} while(true);	
	}
	
	private static int getInt() {
		System.out.println("Saisir un nombre entier :");
		String resultString = input.nextLine();
		int resultInt;
		do {
			try {
				resultInt =  Integer.parseInt(resultString);
				break;
			}
			catch (NumberFormatException e) {
				try {
					new BigInteger(resultString);
					System.err.println("La valeur saisie dépasse les capacités de cette calculatrice. Réessayez...");
				} catch (NumberFormatException f) {
					System.err.println("Saisie incorrecte. Réessayez...");
				}
        	}
			resultString = input.nextLine();
		} while(true);
		return resultInt;
	}

}
