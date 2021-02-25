package allumettes;

import java.util.Random;

public class StrategieNaif implements Strategie {
	
	@Override
	public int getPrise(Jeu jeu) {
		int prise;
		Random r = new Random();
		prise = r.nextInt(jeu.PRISE_MAX) + 1;
		if (prise > jeu.getNombreAllumettes()) {
			prise = r.nextInt(jeu.getNombreAllumettes()) + 1;
		}
		return prise;
	}

}