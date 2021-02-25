package allumettes;

import java.util.Scanner;

public class StrategieHumain implements Strategie {

	@Override
	public int getPrise(Jeu jeu) {
		int prise = 0;
		boolean b = true;
		while (b) {
			System.out.println("Combien prenez-vous d'allumettes ?");
			Scanner scan = new Scanner(System.in);
			b = false;
			try {
				prise = scan.nextInt();
			} catch (java.util.InputMismatchException e) {
				System.out.println("Vous devez entrer un entier.");
				b = true;
				
			} catch (java.util.NoSuchElementException e) {
				System.out.println("Vous devez entrer un entier.");
				b = true;
			}
		}
		return prise;
	}

}
