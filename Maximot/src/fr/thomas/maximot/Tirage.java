package fr.thomas.maximot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Tirage {

	private String mot;
	private ArrayList<Character> lettres = new ArrayList<>();
	
	private Random rdm = new Random();
	
	public Tirage() throws FileNotFoundException, IOException {
		this.mot = Dictionnaire.motAlea();
		for(int i=0; i<this.mot.length(); i++)
		{
			this.lettres.add(rdm.nextInt(this.lettres.size()+1), this.mot.charAt(i));
		}
	}

	public void afficherLettres() {
		for(char c : this.lettres) {
			System.out.print(c + " ");
		}
		System.out.println();
	}
	
	public boolean verifLettres(String mot) {
		for(int i=0; i<mot.length(); i++) {
			if(!lettres.contains(mot.charAt(i)))
				return false;
		}
		return true;
	}
	
	/**
	 * @return the mot
	 */
	public String getMot() {
		return mot;
	}

	/**
	 * @param mot the mot to set
	 */
	public void setMot(String mot) {
		this.mot = mot;
	}

}
