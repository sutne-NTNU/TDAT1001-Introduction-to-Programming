/*
Øving 3, oppgave 4.14.1 side 143
Dette programmet skal gi ut gangetabellen (*1 -> *10) for et intervall gitt av brukeren
*/

import javax.swing.*;
import javax.swing.JOptionPane.*;

public class Gangetabell {
	public static void main(String[] args) {

		// Lager interaktiv boks for brukeren med begge input i samme boks
		JTextField tall1 = new JTextField(3); // ny textbox
		JTextField tall2 = new JTextField(3); // ny textbox
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Nedre Grense:")); // ny label
		myPanel.add(tall1);
		myPanel.add(Box.createHorizontalStrut(0));
		myPanel.add(new JLabel("Øvre Grense:")); // ny label
		myPanel.add(tall2);

		int result = JOptionPane.showConfirmDialog(null, myPanel, "Hvilket intervall vil du ha gangetabellen for?",
				JOptionPane.OK_CANCEL_OPTION); // dersom bruker trykker "cancel" avlsuttes porgrammet
		if (result == JOptionPane.OK_OPTION) { // dersom bruker trykker "OK" vil programmet bruke input fra bruker

			// Henter ut dataene bruker har oppgitt og gjør dem om til "int"
			String xx = tall1.getText();
			int x = Integer.valueOf(xx);// x er nedre grense
			String yy = tall2.getText();
			int y = Integer.valueOf(yy);// y er øvre grense
			if (x > y) {
				JOptionPane.showMessageDialog(null, "Vennligst legg laveste tall under \"Nedre grense\"");

				// oppretter 2 løkker inni hverandre
				// når løkken er ferdig, begynner løkken over på nytt igjen, helt til verdien
				// når den øvre grensen
			} else {
				System.out.println("Resultater dukker opp her:");
				for (int tikk = x; tikk >= x && tikk <= y; tikk++, x++) {
					System.out.println("\n\n" + x + "-Tabellen:");
					for (int tokk = 1; tokk >= 0 && tokk <= 10; tokk++) {
						System.out.println(x + " * " + tokk + " = " + x * tokk);
					}

				}
			}
		}
	}
}