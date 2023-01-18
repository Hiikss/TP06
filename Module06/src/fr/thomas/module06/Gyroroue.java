package fr.thomas.module06;

import java.time.LocalDate;

public class Gyroroue extends Gyro {
	
	public Gyroroue(String marque, String modele, LocalDate dateAchat, int autonomie) {
		super(marque, modele, dateAchat, autonomie);
	}

	@Override
	public double getTarifLocation() {
		return 18.90;
	}
}
