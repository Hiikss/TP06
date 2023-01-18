package fr.thomas.module06;

import java.time.LocalDate;

public abstract class Cycle {

	private String marque;
	private String modele;
	private LocalDate dateAchat;
	
	public Cycle(String marque, String modele, LocalDate dateAchat) {
		this.marque = marque;
		this.modele = modele;
		this.dateAchat = dateAchat;
	}
	
	public abstract double getTarifLocation();
	
	public int age() {
		return this.dateAchat.until(LocalDate.now()).getYears();
	}
	
	@Override
	public String toString() {
		int age = this.age();
		return String.format("%s %s %s (%dan%s)", this.getClass().getSimpleName(), this.marque, this.modele, age, age > 1 ? "s" : "");
	}
}
