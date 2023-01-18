package fr.thomas.module06;

import java.time.LocalDate;

public abstract class Gyro extends Cycle{
	
	private int autonomie;
	
	public Gyro(String marque, String modele, LocalDate dateAchat, int autonomie) {
		super(marque, modele, dateAchat);
		this.autonomie = autonomie;
	}

}
