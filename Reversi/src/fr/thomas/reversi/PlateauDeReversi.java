package fr.thomas.reversi;

/**
 * 
 * @author Thomas
 *
 */
public class PlateauDeReversi {
	
	public static final int SIZE = 8;

	private Pion[][] board;
	
	/**
	 * Constructeur
	 * Initialise le plateau
	 */
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

	/**
	 * Affiche le plateau avec les pions
	 */
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
	
	/**
	 * Retourne le nombre de pions qui changeraient de couleur si le joueur choisi cette case
	 * @param pion
	 * @param l ligne du plateau
	 * @param c colonne du plateau
	 * @return nombre de pion
	 */
	public int tester(Pion pion, int l, int c) {
		return 0;
	}
	
	/**
	 * Teste s'il existe une position où on peut poser un pion
	 * @param pion
	 * @return
	 */
	public boolean peutJouer(Pion pion) {
		return false;
	}
	
	/**
	 * Positionne un pion et change la couleur des pions capturés
	 * @param pion
	 * @param l ligne
	 * @param c colonne
	 */
	public void poser(Pion pion, int l, int c) {
		this.board[l][c] = pion;
	}
	
	/**
	 * Crée les joueurs et les fait jouer à tour de rôle
	 */
	public void jouer() {
		//Crée le joueur noir
		Pion.NOIR.choixJoueur();
		//Crée le joueur blanc
		Pion.BLANC.choixJoueur();
		//On commence avec le joueur noir
		Pion currentPlayer = Pion.NOIR;
		//Joue tant que le plateau n'est pas rempli
		while(true) {
			//Affiche le plateau en début de tour
			System.out.println("Au tour de " + currentPlayer.getSymbole() + " " + currentPlayer.getJoueur().getNom());
			afficher();
			//Demande au joueur de placer un pion
			int co[] = currentPlayer.getJoueur().jouer(this, currentPlayer);
			
			if(tester(currentPlayer, co[0], co[1])>0) {
				
			}
			//Change le joueur qui doit jouer
			currentPlayer = currentPlayer.autrePion();
		}
	}
	
	/**
	 * Méthode principale
	 * @see #jouer()
	 * @param args
	 */
	public static void main(String[] args) {
		PlateauDeReversi plateau = new PlateauDeReversi();
		plateau.jouer();
	}
}
