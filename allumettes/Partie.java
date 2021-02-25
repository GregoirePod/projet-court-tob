package allumettes;

/** Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * @author	Xavier Crégut
 * @version	$Revision: 1.5 $
 */
public class Partie {
	
	public static boolean confiant;

	/** Lancer une partie. En argument sont donnés les deux joueurs sous
	 * la forme nom@stratégie.
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {
		try {
			Joueur joueur1;
			Joueur joueur2;
			int c;
			if (args.length == 3) {
				verifierConfiant(args[0]);
				System.out.println(args[2]);	
				c = 1;
			} 
			else {
				verifierNombreArguments(args);
				c = 0;
			}
			String[] j1 = args[c + 0].split("@");
			String[] j2 = args[c + 1].split("@");
			joueur1 = new Joueur(j1[0], getStrategie(j1[1]));
			joueur2 = new Joueur(j2[0], getStrategie(j2[1]));
			Arbitre arbitre = new Arbitre(joueur1, joueur2);
			Jeu nv_jeu = new Jeu_Allumettes(13);
			arbitre.arbitrer(nv_jeu);

		} catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		} 
		
		
	}

	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Trop peu d'arguments : "
					+ args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Trop d'arguments : "
					+ args.length);
		}
	}
	
	private static void verifierConfiant(String args) {
		if (!args.equals("-confiant")) {
			throw new ConfigurationException("Argument inconnu : " + args);
		} else { 
			confiant = true;
		}
	}
	
	/** Choix de la strategie en fonction du nom de la strategie
	 * @param nom nom de la strategie
	 */
	private static Strategie getStrategie(String nom) throws ConfigurationException {
		switch (nom) {
			case "humain" : 
				return new StrategieHumain();
			case "naif" :
				return new StrategieNaif();
			case "rapide" : 
				return new StrategieRapide();
			case "expert" :
				return new StrategieExpert();
			case "tricheur" : 
				return new StrategieTricheur();
			default : 
				throw new ConfigurationException("Strategie inconnue " + nom);
		}
	}

	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :"
				+ "\n\t" + "java allumettes.Partie joueur1 joueur2"
				+ "\n\t\t" + "joueur est de la forme nom@stratégie"
				+ "\n\t\t" + "strategie = naif | rapide | expert | humain | tricheur"
				+ "\n"
				+ "\n\t" + "Exemple :"
				+ "\n\t" + "	java allumettes.Partie Xavier@humain "
					   + "Ordinateur@naif"
				+ "\n"
				);
	}

}
