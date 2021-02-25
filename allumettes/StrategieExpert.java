package allumettes;

import java.util.Random;

public class StrategieExpert implements Strategie {

	@Override
	public int getPrise(Jeu jeu) {
		int prise; 
		if (jeu.getNombreAllumettes() > Jeu.PRISE_MAX) {
			Random r = new Random();
			prise = r.nextInt(Jeu.PRISE_MAX) + 1;
		}
		else if (jeu.getNombreAllumettes() == 1) {
			prise = 1; 
		}
		else {
			prise = jeu.getNombreAllumettes() - 1; 
		}
		return prise;
	}

}