package fr.thomas.maximot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dictionnaire {
	
	private final static String PATH = "./src/resources/dictionnaire.txt";
	private final static int NB_MOTS = 22506;
	
	private static List<String> mots;
	
	private static Random rdm = new Random();

	public static String motAlea() throws FileNotFoundException, IOException {
		return Dictionnaire.getMots().get(rdm.nextInt(NB_MOTS));
	}

	public static boolean motExiste(String motSaisi) throws FileNotFoundException, IOException {
		if(mots.contains(motSaisi))
			return true;
		return false;
	}
	
	public static List<String> getMots() throws FileNotFoundException, IOException {
		Dictionnaire.mots = new ArrayList<>(NB_MOTS);
		try (FileInputStream file = new FileInputStream(PATH);
			Scanner s = new Scanner(file))
		{
			for(int i=0; i<NB_MOTS; i++)
				Dictionnaire.mots.add(s.nextLine());
		}
		return mots;
	}
}
