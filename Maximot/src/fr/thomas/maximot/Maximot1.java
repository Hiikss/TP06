package fr.thomas.maximot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * TP 1 du module 01 : Maximot 1
 * @author Thomas
 *
 */
public class Maximot1 {
	
	private final String PATH = "./src/resources/dictionnaire.txt";
	private final int nbMots = 22506;
	
	private Random rdm = new Random();
	private Scanner input = new Scanner(System.in);
	
	public Maximot1() throws FileNotFoundException, IOException{
		
		//Tirage d'un mot aléatoire
		String mot = motAlea();
		//Mélange des lettres
		char[] lettresMel  = melange(mot);
		//Affichage des lettres mélangées
		System.out.println("Les lettres du mot sont : " + String.valueOf(lettresMel).replace("", " ").trim());
		//Récupération de la saisie d'un mot
		String motSaisi = input.nextLine();
		
		if(lettersCheck(motSaisi, lettresMel))
		{
			if(motDansDico(motSaisi))
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
		
		System.out.println("Le mot tiré au sort était : " + mot);
	}
	
	/**
	 * Éxécution du programme.
	 * Instanciation de la classe Maximot1
	 * @see #Maximot1()
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		new Maximot1();
	}
	
	/**
	 * Tire un mot aléatoirement
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private String motAlea() throws FileNotFoundException, IOException{
		int numMot = rdm.nextInt(nbMots);
		try (FileInputStream file = new FileInputStream(PATH);
			Scanner s = new Scanner(file))
		{
			for(int i=1; i<numMot; i++)
				s.nextLine();
	
			return s.nextLine();
		}
	}
	
	/**
	 * Mélange les lettres du mot tiré au sort
	 * @param mot Mot tiré au sort
	 * @return
	 */
	private char[] melange(String mot)
	{
		//Les lettres sont mises dans un tableau de charactère
		char[] motFinal = mot.toCharArray();
		//Charactère intermédiaire
		char inter;
		//Pour chaque lettre du mot en commençant par lère et en finissant par l'avant-dernière 
		for(int i=0; i<mot.length(); i++)
		{
			//Génère un nombre aléatoire
			int randomInt = rdm.nextInt(mot.length());
			//On change deux charactères entre eux dans le mot (a=b; b=c; c=a)
			inter = motFinal[randomInt];
			motFinal[randomInt] = motFinal[i];
			motFinal[i] = inter;
		}
		//retourne le tableau de charactère sous type de String
		return motFinal;
	}
	
	/**
	 * Vérifie si les lettres utilisées sont présentes dans le mot tiré au sort
	 * @param saisie Mot saisie
	 * @param lettres Lettres du mot tiré au sort
	 * @return
	 */
	private boolean lettersCheck(String saisie, char[] lettres) {
		for(int i=0; i<saisie.length(); i++)
		{
			if(!String.valueOf(lettres).contains(String.valueOf(saisie.charAt(i))))
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Vérifie si le mot est contenu dans le dictionnaire
	 * @param saisie Mot à vérifier
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private boolean motDansDico(String saisie) throws FileNotFoundException, IOException {
		try (FileInputStream file = new FileInputStream(PATH);
				Scanner s = new Scanner(file))
			{
				for(int i=1; i<nbMots; i++)
				{
					if(s.nextLine().equals(saisie))
						return true;
				}
			}
		return false;
	}
}
