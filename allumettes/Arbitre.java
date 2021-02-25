package allumettes;

public class Arbitre {
	
	private Joueur joueur1;
	private Joueur joueur2;
	
	/** Construire un Arbitre à partir de deux joueurs qui vont s'affronter.
	 * @param j1 le premier joueur
	 * @param j2 le deuxième joueur 
	 */
	public Arbitre(Joueur j1, Joueur j2) {
		this.joueur1 = j1;
		this.joueur2 = j2;
	}
	
	/**Arbitrer une partie 
	 * @param jeu le jeu utiliser pour la partie
	 * @throws CoupInvalideException si l'un des joueurs tire le mauvais nombre d'allumettes
	 */
	public void arbitrer(Jeu jeu) {
		int nb_prise;
		int i = 1; // numéro du tour 
		Joueur joueur; // joueur au tour de jouer
		while (jeu.getNombreAllumettes() > 0) {
			System.out.println("\nNombre d'allumettes restantes : " + Integer.toString(jeu.getNombreAllumettes()));
			if (i%2 == 1) {
				joueur = this.joueur1;
			} else {
				joueur = this.joueur2;	
				}
			System.out.println("Au tour de " + joueur.getNom() + ".");
			try {
			if (Partie.confiant) {
				nb_prise = joueur.getPrise(jeu);
			}
			else {
				nb_prise = joueur.getPrise(new JeuProxy(jeu));
			}
			if (nb_prise <= 1) {
				System.out.println(joueur.getNom() + " prend " + Integer.toString(nb_prise) + " allumette.");				
			}
			else {
				System.out.println(joueur.getNom() + " prend " + Integer.toString(nb_prise) + " allumettes.");	
			}
				jeu.retirer(nb_prise);				
			i++;
			} catch (CoupInvalideException e) {
				System.out.println("Erreur ! " + e.getMessage());
				System.out.println("Recommencez !");
			} catch (OperationInterditeException e) {
				System.out.println("Partie abandonnée car " + joueur.getNom() + " a triché !");
				throw new ConfigurationException("Un joueur a triché.");
			}
		} // Fin de partie, affichage des résultats
		if (i%2 == 1 ) {
			System.out.println(this.joueur2.getNom() + " a perdu !");
			System.out.println(this.joueur1.getNom() + " a gagné !\n");
		} 
		else {
			System.out.println(this.joueur1.getNom() + " a perdu !");
			System.out.println(this.joueur2.getNom() + " a gagné !\n");

		}
	}
	
}
