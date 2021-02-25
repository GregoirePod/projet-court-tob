package allumettes;

public class JeuProxy implements Jeu {
	
	protected Jeu jeuReel;
	
	public JeuProxy(Jeu jeu) {
		assert(jeu != null);
		this.jeuReel = jeu;
	}
	
	public Jeu getJeu() {
		return this.jeuReel;
	}
	
	@Override
	public int getNombreAllumettes() {
		return this.jeuReel.getNombreAllumettes();
	}

	@Override
	public void retirer(int nbPrises) throws CoupInvalideException {
		throw new OperationInterditeException();
	}
}
