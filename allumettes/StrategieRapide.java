package allumettes;

public class StrategieRapide implements Strategie {

	@Override
	public int getPrise(Jeu jeu) {
		int prise;
		if (jeu.getNombreAllumettes() >= Jeu.PRISE_MAX) {
		    prise = Jeu.PRISE_MAX;
		} 
		else {
			prise = jeu.getNombreAllumettes();
		}
		return prise;
	}

}