package fr.thomas.module02;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

/**
 *  TP 1 du module 02 : Calendrier
 * @author Thomas
 *
 */
public class Calendrier {
	
	private Scanner input = new Scanner(System.in);
	
	public Calendrier() {
		GregorianCalendar date = new GregorianCalendar();
		String saisie;
		do {
			//Affiche le calendrier
			afficherMois(date.get(GregorianCalendar.YEAR), date.get(GregorianCalendar.MONTH));
			System.out.println("Entrez une valeur : 1 pour le mois précédent; 2 pour le mois suivant;\n3 pour choisir un mois et une année; 4 pour quitter");
			saisie = input.nextLine();
			switch(saisie) {
			case "1":
				date.add(GregorianCalendar.MONTH, -1);
				break;
			case "2":
				date.add(GregorianCalendar.MONTH, 1);
				break;
			case "3":
				System.out.println("Quel mois ?");
				int mois = input.nextInt();
				System.out.println("Quelle année ?");
				int annee = input.nextInt();
				date.set(annee, mois-1, 1);
				break;
			case "4":
				break;
			default:
				System.out.println("La valeur saisie est incorrecte");
				break;
			}
		} while(!saisie.equals("4"));
	}

	/**
	 * Éxécution du programme.
	 * Instanciation de la classe Calendrier
	 * @see #Calendrier()
	 * @param args
	 */
	public static void main(String[] args) {
		new Calendrier();
	}
	
	/**
	 * Affiche le calendrier du mois
	 * @param annee année à afficher
	 * @param mois mois à afficher
	 */
	public void afficherMois(int annee, int mois) {
		GregorianCalendar jour = new GregorianCalendar(annee, mois, 1);
		System.out.println("* " + jour.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG_FORMAT, Locale.FRANCE) + " " + jour.get(GregorianCalendar.YEAR) + " *");
		System.out.println("L  Ma Me J  V  S  D ");
		//Mettre un décalage en fonction du premier jour
		int dec = 0;
		switch(jour.get(GregorianCalendar.DAY_OF_WEEK)) {
		case GregorianCalendar.TUESDAY:
			dec = 1;
			break;
		case GregorianCalendar.WEDNESDAY:
			dec = 2;
			break;
		case GregorianCalendar.THURSDAY:
			dec = 3;
			break;
		case GregorianCalendar.FRIDAY:
			dec = 4;
			break;
		case GregorianCalendar.SATURDAY:
			dec = 5;
			break;
		case GregorianCalendar.SUNDAY:
			dec = 6;
			break;
		}
		for(int i=0; i<dec; i++) {
			System.out.print("   ");
		}
		int nbJours = jour.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		for(int i=0; i<nbJours; i++)
		{
			//Affichage du jour
			System.out.format("%02d ", jour.get(GregorianCalendar.DAY_OF_MONTH));
			if(jour.get(GregorianCalendar.DAY_OF_WEEK)==GregorianCalendar.SUNDAY)
				System.out.println();
			//Ajoute un jour à la date sauf pour le dernier jour pour ne pas aller au mois suivant
			if(i<nbJours)
				jour.add(GregorianCalendar.DAY_OF_MONTH, 1);
		}
		System.out.println("\n");
	}

}
