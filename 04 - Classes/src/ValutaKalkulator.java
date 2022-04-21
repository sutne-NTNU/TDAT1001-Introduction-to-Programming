
/*
Øving 4, oppgave 5.9.2 side 177
Dette programmet skal gi brukeren muligheten til å velge en valuta
*/
import static javax.swing.JOptionPane.*;

public class ValutaKalkulator {
	public static void main(String[] args) {

		// Oppretter valutaene (og printer ut bekreftende melding i konsollen)
		Valuta euro = new Valuta(" Euro ", 9.37);
		Valuta usd = new Valuta(" Amerikanske Dollar ", 8.35);
		Valuta gbp = new Valuta(" Britiske Pund ", 10.78);
		Valuta sek = new Valuta(" Svenske Kroner ", 0.91);
		Valuta bit = new Valuta(" Bitcoin", 60601.57);

		// lager loopen som fortsetter helt til bruker avslutter programmet
		int i = 0;
		while (i == 0) {

			// Brukeren velger om h*n vil regne til eller fra norske kroner
			String input1Lest = showInputDialog(null,
					"Vil du regne til eller fra norske kroner?\n1: Fra NOK\n2: Til NOK\n3: Avslutt");
			int input1 = Integer.parseInt(input1Lest);
			switch (input1) {
				case 1:
					// omregning fra norske kroner (kan lese inn kroner før programmet har tatt
					// valutaen i betraktning)
					String input2Lest = showInputDialog(null,
							"Du vil regne om fra norske kroner; Vennligst velg ønsket Valuta:\n1: Euro\n2: Amerikanske dollar\n3: Britiske Pund\n4: Svenske Kroner\n5: Bitcoin\n6: Start på nytt\n7: Avslutt");
					int input2 = Integer.parseInt(input2Lest);

					if (input2 < 7) {
						String mengdeLest = showInputDialog(null, "Hvor mange Norske kroner vil du veksle?");
						double mengde = Double.parseDouble(mengdeLest);
						switch (input2) {
							case 1:
								showMessageDialog(null, mengde + " Norske kroner tilsvarer " + mengde / euro.getKurs()
										+ euro.getName());
								break;
							case 2:
								showMessageDialog(null, mengde + " Norske kroner tilsvarer " + mengde / usd.getKurs()
										+ " Amerikanske Dollar");
								break;
							case 3:
								showMessageDialog(null, mengde + " Norske kroner tilsvarer " + mengde / gbp.getKurs()
										+ " Britiske Pund");
								break;
							case 4:
								showMessageDialog(null, mengde + " Norske kroner tilsvarer " + mengde / sek.getKurs()
										+ " Svenske Kroner");
								break;
							case 5:
								showMessageDialog(null,
										mengde + " Norske kroner tilsvarer " + mengde / bit.getKurs() + " Bitcoin");
								break;
							case 6: // starter programmet på nytt (dersom bruker har valgt feil alternativ osv.)
								break;
							default:
								;
								i++;
								System.out.println("Avslutter programmet");
						}
					} else {
						i++;
						System.out.println("Avslutter programmet");
					}
					break;
				case 2: // Omregning fra annen valuta til norske kroner, Her må valg av Valuta tas i
						// betraktning FØR brukeren skriver inn mengden
					String input3Lest = showInputDialog(null,
							"Du vil regne om til norske kroner; Vennligst velg ønsket Valuta:\n1: Euro\n2: Amerikanske dollar\n3: Britiske Pund\n4: Svenske Kroner\n5: Bitcoin\n6: Start på nytt\n7: Avslutt");
					int input3 = Integer.parseInt(input3Lest);
					switch (input3) {
						case 1:
							String mengde1Lest = showInputDialog(null, "Hvor mange Euro vil du veksle?");
							double mengde1 = Double.parseDouble(mengde1Lest);
							showMessageDialog(null, mengde1 + " Euro tilsvarer " + mengde1 * euro.getKurs() + " NOK");
							break;
						case 2:
							String mengde2Lest = showInputDialog(null, "Hvor mange Amerikanske Dollar vil du veksle?");
							double mengde2 = Double.parseDouble(mengde2Lest);
							showMessageDialog(null,
									mengde2 + " Amerikanske Dollar tilsvarer " + mengde2 * usd.getKurs() + " NOK");
							break;
						case 3:
							String mengde3Lest = showInputDialog(null, "Hvor mange Britiske Pund vil du veksle?");
							double mengde3 = Double.parseDouble(mengde3Lest);
							showMessageDialog(null,
									mengde3 + " Britiske Pund tilsvarer " + mengde3 * gbp.getKurs() + " NOK");
							break;
						case 4:
							String mengde4Lest = showInputDialog(null, "Hvor mange Svenske kroner vil du veksle?");
							double mengde4 = Double.parseDouble(mengde4Lest);
							showMessageDialog(null,
									mengde4 + " Svenske Kroner tilsvarer " + mengde4 * sek.getKurs() + " NOK");
							break;
						case 5:
							String mengde5Lest = showInputDialog(null, "Hvor mange Bitcoin vil du veksle?");
							double mengde5 = Double.parseDouble(mengde5Lest);
							showMessageDialog(null, mengde5 + " Bitcoin tilsvarer " + mengde5 * bit.getKurs() + " NOK");
							break;
						case 6: // starter programmet på nytt
							break;
						default:
							;
							i++;
							System.out.println("Avslutter programmet");
					}
					break;
				default:
					;
					i++;
					System.out.println("Avslutter Programmet");
			}
		}

	}
}