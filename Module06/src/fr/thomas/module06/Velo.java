package fr.thomas.module06;

import java.time.LocalDate;

public class Velo extends Cycle{
	
	private int vitesses;

	public Velo(String marque, String modele, LocalDate dateAchat, int vitesses) {
		super(marque, modele, dateAchat);
		this.vitesses = vitesses;
	}

	@Override
	public double getTarifLocation() {
		return 4.90;
	}
}
