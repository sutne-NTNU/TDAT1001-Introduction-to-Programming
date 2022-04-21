/*
Øving 3, oppgave 4.14.5 side 144
Dette programmet skal avgjøre om et tall gitt av brukeren er et primtall, programmet skal startes på nytt etter bruk.
*/

import javax.swing.*;

public class Primtall {
	public static void main(String[] args) {

		// Looper programmet helt til brukerer; Ikke skriver inn et tall, klikker
		// "cancel" eller lukker vinduet
		int i = 0;
		while (i == 0) {

			// Henter tall fra brukeren
			String tallLest = JOptionPane.showInputDialog("Tall:");
			int tall = Integer.parseInt(tallLest);
			int a = 0; // variabelen a blir brukt som en budbringer for om tallet er et primtall a==1
						// gir false, a==0 gir true

			// Fjerner alle negative tall og 0, samt sjekker for de "spesielle""
			// tilfellene/reglene av primtall for 1 og 2"
			if (tall <= 0) {
				JOptionPane.showMessageDialog(null, "Kun positive tall kan være primtall");
			} else if (tall == 1) {
				JOptionPane.showMessageDialog(null, "1 regnes IKKE som et primtall");
			} else if (tall == 2) {
				JOptionPane.showMessageDialog(null,
						"2 er et primtall! \nDet eneste primtallet som også er et partall ");

				// sjekker om tallet er et primtall
			} else {
				if (tall % 2 == 0) {
					a = 1;
				} // dersom tallet er et paratall endres variabelen "a" til 1
				for (int s = 3; s * s <= tall; s += 2) { // lager en loop som sjekker et nytt oddetall for hver
															// gjennomkjøring av loopen
					if (tall % s == 0) {
						a = 1;
					} // dersom tallet er deleilig på et oddetall som sjekkes endres også variabelen
						// "a" til 1
				}

				// dersom variabelen "a" ikke har blitt endret til 1, betyr det at tallet er et
				// primtall
				if (a == 0) {
					JOptionPane.showMessageDialog(null, tall + " er et primtall!");
				}
				// hvis a har fått verdien 1, er tallet IKKE et primtall
				if (a == 1) {
					JOptionPane.showMessageDialog(null, tall + " er IKKE et primtall");
				}
			}
		}
	}
}
