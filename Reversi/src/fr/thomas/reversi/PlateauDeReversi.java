package fr.thomas.reversi;

public class PlateauDeReversi {
	
	private final int SIZE = 8;

	private Pion[][] board;
	
	public PlateauDeReversi() {
		this.board = new Pion[SIZE][SIZE];
		for(int l=0; l<SIZE; l++) {
			for(int c=0; c<SIZE; c++) {
				this.board[l][c] = Pion.LIBRE;
			}
		}
		this.board[SIZE/2][SIZE/2] = Pion.BLANC;
		this.board[SIZE/2-1][SIZE/2] = Pion.NOIR;
		this.board[SIZE/2][SIZE/2-1] = Pion.NOIR;
		this.board[SIZE/2-1][SIZE/2-1] = Pion.BLANC;
	}

	public void afficher() {
		System.out.println(" " + Pion.NOIR.getNombre() + " ●");
		System.out.println(" " + Pion.BLANC.getNombre() + " o");
		System.out.println("  1 2 3 4 5 6 7 8");
		for(int l=0; l<SIZE; l++) {
			System.out.print(l+1);
			for(int c=0; c<SIZE; c++) {
				System.out.print(" " + this.board[l][c].getSymbole());
			}
			System.out.println();
		}
	}
	
	public int tester(Pion pion, int l, int c) {
		return 0;
	}
	
	public boolean peutJouer(Pion pion) {
		return false;
	}
	
	public void poser(Pion pion, int l, int c) {
		this.board[l][c] = pion;
	}
	
	public void jouer() {
		Pion.NOIR.choixJoueur();
		Pion.BLANC.choixJoueur();
		afficher();
	}
	
	public static void main(String[] args) {
		PlateauDeReversi plateau = new PlateauDeReversi();
		plateau.jouer();
	}
}
