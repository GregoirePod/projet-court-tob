package allumettes;

public class Jeu_Allumettes implements Jeu {
	
	private int nb_allumettes;
	
	public Jeu_Allumettes (int nb_initial_allumettes) {
		this.nb_allumettes = nb_initial_allumettes;
	}

	@Override
	public int getNombreAllumettes() {
		return this.nb_allumettes;
	}

	@Override
	public void retirer(int nbPrises) throws CoupInvalideException {
		if (nbPrises > PRISE_MAX) {
			throw new CoupInvalideException(nbPrises, "> " + Integer.toString(PRISE_MAX));
		}
		else if (nbPrises > this.nb_allumettes) {
			throw new CoupInvalideException(nbPrises, "> " + Integer.toString(this.nb_allumettes));
			
		}
		else if (nbPrises < 1) {
			throw new CoupInvalideException(nbPrises, "< 1");
		}
		else {
			this.nb_allumettes = this.nb_allumettes - nbPrises;
		}
	}
	
	public String toString() {
		return "Nombre d'allumettes restantes : " + Integer.toString(this.nb_allumettes);
	}

}
