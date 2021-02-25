package allumettes;

public class Joueur {
	private String nom; // nom du joueur 
	private Strategie strategie; //stratégie du joueur
	
	
	public Joueur (String nv_nom, Strategie nv_strat ) {
		this.nom = nv_nom;
		this.strategie = nv_strat;
	}
	
	public String getNom() {
		return this.nom;
	}

	public Strategie getStrategie() {
	    	return this.strategie;
	}

	
	public int getPrise(Jeu jeu) {
		return this.strategie.getPrise(jeu); 
	}
}
