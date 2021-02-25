package allumettes;

public class StrategieTricheur implements Strategie {

	@Override
	public int getPrise(Jeu jeu) {
		int prise;
		while (jeu.getNombreAllumettes() > 2) {
			try {
				jeu.retirer(1);
			} catch (CoupInvalideException e) {
			}
		}
		prise = 1;
		return prise;
	}

}
