package fr.thomas.module07;

public class Operation {
	
	public static int ajouter(int a, int b) throws DepassementCapaciteException {
		int resultat = a+b;
		if(resultat != (long) a+b)
			throw new DepassementCapaciteException();
		return resultat;
	}
	
	public static int soustraire(int a, int b) throws DepassementCapaciteException {
		int resultat = a-b;
		if(resultat != (long) a-b)
			throw new DepassementCapaciteException();
		return resultat;
	}
	
	public static int multiplier(int a, int b) throws DepassementCapaciteException {
		int resultat = a*b;
		if(resultat != (long) a*b)
			throw new DepassementCapaciteException();
		return resultat;
	}

}
