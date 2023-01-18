package fr.thomas.module06;

import java.time.LocalDate;

public class Gyropode extends Gyro {

	private int tailleMin;
	
	public Gyropode(String marque, String modele, LocalDate dateAchat, int autonomie, int tailleMin) {
		super(marque, modele, dateAchat, autonomie);
		this.tailleMin = tailleMin;
	}

	@Override
	public double getTarifLocation() {
		return 29.90;
	}
	
	@Override
	public String toString() {
		return String.format("%s [%dm%d min]", super.toString(), this.tailleMin/100, this.tailleMin%100);
	}
}
