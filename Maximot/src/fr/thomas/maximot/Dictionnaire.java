package fr.thomas.maximot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Dictionnaire {
	
	private final static String PATH = "./src/resources/dictionnaire.txt";
	private final static int NB_MOTS = 22506;
	
	private static Random rdm = new Random();

	public static String motAlea() throws FileNotFoundException, IOException {
		int numMot = rdm.nextInt(NB_MOTS);
		try (FileInputStream file = new FileInputStream(PATH);
				Scanner s = new Scanner(file))
			{
				for(int i=1; i<numMot; i++)
					s.nextLine();
		
				return s.nextLine();
			}
	}

	public static boolean motExiste(String motSaisi) throws FileNotFoundException, IOException {
		try (FileInputStream file = new FileInputStream(PATH);
				Scanner s = new Scanner(file))
			{
				for(int i=1; i<NB_MOTS; i++)
				{
					if(s.nextLine().equals(motSaisi))
						return true;
				}
			}
		return false;
	}

}
