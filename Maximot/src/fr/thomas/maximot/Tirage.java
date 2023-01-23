package fr.thomas.maximot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Tirage {

	private String mot;
	private ArrayList<Character> lettres = new ArrayList<>();
	private Map<Integer, List<String>> possibilites = new HashMap<>();
	
	private Random rdm = new Random();
	
	public Tirage() throws FileNotFoundException, IOException {
		this.mot = Dictionnaire.motAlea();
		for(int i=0; i<this.mot.length(); i++)
		{
			this.lettres.add(rdm.nextInt(this.lettres.size()+1), this.mot.charAt(i));
		}
		for (String motDico : Dictionnaire.getMots()) {
			if (verifLettres(motDico)) {
				List<String> motsDeLaMemeTaille = this.possibilites.get(motDico.length());
				if (motsDeLaMemeTaille == null) {
					this.possibilites.put(motDico.length(), new ArrayList<>());
					motsDeLaMemeTaille = this.possibilites.get(motDico.length());
				}
				motsDeLaMemeTaille.add(motDico);
			}
		}
	}

	public void afficherLettres() {
		for(char c : this.lettres) {
			System.out.print(c + " ");
		}
		System.out.println();
	}
	
	public boolean verifLettres(String mot) {
		ArrayList<Character> clone = new ArrayList<>(this.lettres);
		int i = 0;
		while (i < mot.length() && clone.contains(mot.charAt(i))) {
			clone.remove(Character.valueOf(mot.charAt(i)));
			i++;
		}
		return i == mot.length();
	}
	
	public Map<Integer, List<String>> getPossibilites() {
		return this.possibilites;
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
