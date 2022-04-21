/*
Øving 4, oppgave 5.9.3 side 178
Dette programmet skal simulerer et spill med to spiller (A og B) som spiller terningspillet 100
Ønsket print vil være rundenummer og poengsum for begge spillerne, programmet skal stoppe så snart en spiller
når poengsummen 100
*/

import static javax.swing.JOptionPane.*;
import java.util.Random.*;

public class Terningspill {
	public static void main(String[] args) {

		// Oppretter de 2 spillerne (bruker navngir spillerne)
		String spiller1 = showInputDialog(null, "Spiller 1: (kaster først)");
		String spiller2 = showInputDialog(null, "Spiller 2:");
		Spiller sp1 = new Spiller(spiller1, 0);
		Spiller sp2 = new Spiller(spiller2, 0);

		int runde = 1;

		// Looper så lenge begge spillerne har poengsummer under 100
		while (sp1.getSumPoeng() < 100 && sp2.getSumPoeng() < 100) {

			// første spilleren kaster terningen
			sp1.kastTerningen();

			// oppretter en String for å få resultatene på en oversiktlig måte
			String res = "runde: " + runde + "	" + sp1.getSpiller() + ": " + sp1.getSumPoeng();

			// Dersom Spiller1 får poengsum over 100, vil ikke den andre spilleren få kaste
			// (dermed vil ikke begge kunne vinne ved å få 100 i samme runde)
			if (sp1.getSumPoeng() >= 100) {
				System.out.println(res);
				showMessageDialog(null, sp1.getSpiller() + " vant!");

				// Den første spilleren har ikke 100 eller mer poeng, og den andre spilleren
				// kaster
			} else {
				sp2.kastTerningen();
				res += "	" + sp2.getSpiller() + ": " + sp2.getSumPoeng();
				System.out.println(res);
				if (sp2.getSumPoeng() >= 100) {
					showMessageDialog(null, sp2.getSpiller() + " vant!");
				}
			}
			runde++;
		}

	}
}
