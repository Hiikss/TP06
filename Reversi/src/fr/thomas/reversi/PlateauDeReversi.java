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
		int nbPions = 0;
		if(this.board[l][c]==Pion.LIBRE) {
			for(int y=-1; y<=1; y++) {
				for(int x=-1; x<=1; x++) {
					if(l+y<SIZE & c+x<SIZE && l+y>0 && c+x>0 && this.board[l+y][c+x]==pion.autrePion()) {
						int i = 1;
						while(this.board[l+i*y][c+i*x]==pion.autrePion()) {
							if(l+(i+1)*y==SIZE || c+(i+1)*x==SIZE || l+(i+1)*y==-1 || c+(i+1)*x==-1 || this.board[l+(i+1)*y][c+(i+1)*x]==Pion.LIBRE)
							{
								i = 0;
								break;
							}
							if(this.board[l+(i+1)*y][c+(i+1)*x]==pion)
								break;
							i++;
						}
						nbPions+=i;
					}
				}
			}
		}
		return nbPions;
	}
	
	/**
	 * Teste s'il existe une position où l'on peut poser un pion
	 * @param pion
	 * @return
	 */
	public boolean peutJouer(Pion pion) {
		for(int l=0; l<SIZE; l++) {
			for(int c=0; c<SIZE; c++) {
				if(tester(pion, l, c)>=1)
					return true;
			}
		}
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
		for(int y=-1; y<=1; y++) {
			for(int x=-1; x<=1; x++) {
				if(l+y<SIZE & c+x<SIZE && l+y>0 && c+x>0 && this.board[l+y][c+x]==pion.autrePion()) {
					int i = 1;
					while(this.board[l+i*y][c+i*x]==pion.autrePion()) {
						if(l+(i+1)*y==SIZE || c+(i+1)*x==SIZE || l+(i+1)*y==-1 || c+(i+1)*x==-1 || this.board[l+(i+1)*y][c+(i+1)*x]==Pion.LIBRE)
						{
							i = 0;
							break;
						}
						if(this.board[l+(i+1)*y][c+(i+1)*x]==pion) {
							for(int j=1; j<=i; j++) {
								this.board[l+j*y][c+j*x] = pion;
							}
							break;
						}
						i++;
					}
				}
			}
		}		
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
		//Joue tant que les joueurs peuvent jouer
		while(peutJouer(currentPlayer) || peutJouer(currentPlayer.autrePion())) {
			//Si le joueur peut jouer
			if(peutJouer(currentPlayer)) {
				//Affiche le plateau en début de tour
				System.out.println("Au tour de " + currentPlayer.getSymbole() + " " + currentPlayer.getJoueur().getNom());
				afficher();
				//Demande au joueur de placer un pion
				int co[] = currentPlayer.getJoueur().jouer(this, currentPlayer);
				//Récupère le nombre de pions changés à la position choisie
				int nbPionsChanges = tester(currentPlayer, co[0], co[1]);
				//Test si au moins un pion change, donc si le coup peut être joué
				if(nbPionsChanges >= 1) {
					//Pose les pions
					poser(currentPlayer, co[0], co[1]);
					//Met à jour le nombre de pions de chaque joueurs
					currentPlayer.gagne(nbPionsChanges);
					//Change le joueur qui doit jouer
					currentPlayer = currentPlayer.autrePion();
				}
				else
					System.err.println("Le pion ne peut pas être posé ici");
				}
			else {
				System.err.println(currentPlayer.getSymbole() + " ne peut pas jouer ce tour");
				//Change le joueur qui doit jouer
				currentPlayer = currentPlayer.autrePion();
			}
		}
		//Le joueur noir gagne
		if(Pion.NOIR.getNombre() > Pion.BLANC.getNombre())
			System.out.println(Pion.NOIR.getSymbole() + " " + Pion.NOIR.getJoueur().getNom() + " gagne la partie");
		//Le joueur blanc gagne
		else
			System.out.println(Pion.BLANC.getSymbole() + " " + Pion.BLANC.getJoueur().getNom() + " gagne la partie");
		//Affiche le nombre de pions de chaque joueur
		System.out.println(Pion.NOIR.getSymbole() + " " + Pion.NOIR.getJoueur().getNom() + " : " + Pion.NOIR.getNombre() + " pions");
		System.out.println(Pion.BLANC.getSymbole() + " " + Pion.BLANC.getJoueur().getNom() + " : " + Pion.BLANC.getNombre() + " pions");
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
