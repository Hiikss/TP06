package fr.thomas.reversi;

public enum Pion {
	LIBRE, NOIR, BLANC;
	
	private int nombre;

	/**
	 * @return the nombre
	 */
	public int getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	public char getSymbole() {
		switch(this) {
		case NOIR :
			return '●';
		case BLANC :
			return 'o';
		default :
			return '·';
		}
	}
	
	public Pion autrePion() {
		switch(this) {
		case NOIR :
			return BLANC;
		case BLANC :
			return NOIR;
		default :
			return LIBRE;
		}
	}
	
	public void gagne(int pions) {
		
	}
}
