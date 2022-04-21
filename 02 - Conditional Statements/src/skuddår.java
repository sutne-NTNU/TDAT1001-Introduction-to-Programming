
/*
Øving 2 (Oppgave 3.12.3 side 113)
Avgjør om et gitt år er/var/vil være et skuddår
*/
import static javax.swing.JOptionPane.*;

public class skuddår {
	public static void main(String[] args) {
		System.out.println("Program for å finne ut om et år er et skuddår");

		// loopen starter programmet på nytt dersom bruker gir negativt/ugyldig årstall
		int i = 0;
		int j = 1;
		while (i < j) {
			i++;

			// Leser årstallet fra brukeren, kaller det variabelen "aar"
			String aarLest = showInputDialog("Årstall:");
			int aar = Integer.parseInt(aarLest);

			// Forteller brukerer at positivt tall må brukes
			if (aar <= 0) {
				showMessageDialog(null, "Vennligst bruk et positivt tall");
				j++; // gjør at i<j, og programmet starter på nytt

				// Sjekker om tallet er deleilig med 400 eller 4 og Bygger opp
				// resultatutskriften trinnvis.
			} else {
				String resultat = "året " + aar + " er";
				if (aar % 4 != 0) {
					resultat += " IKKE";
				}
				if (aar % 100 == 0) {
					if (aar % 400 != 0) {
						resultat += " IKKE";
					}
				}
				resultat += " et skuddår";

				// skriver ut resultatet
				showMessageDialog(null, resultat);
			}
		}
	}
}