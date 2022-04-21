
/*
Øving 2, oppgave 3.12.4 side 113
finne ut hvilken kilopris som er billigst av to brukerinnlagte valg
*/
import javax.swing.*;
import static javax.swing.JOptionPane.*;

public class Kilopris {
	public static void main(String[] args) {

		// Legger til flere bokser for at bruker skal legge inn egne priser og mengder
		JTextField wField = new JTextField(5);
		JTextField xField = new JTextField(5);
		JTextField yField = new JTextField(5);
		JTextField zField = new JTextField(5);
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Vare A; Pris (Kr):"));
		myPanel.add(wField);
		myPanel.add(Box.createHorizontalStrut(0));
		myPanel.add(new JLabel("Mengde (kg):"));
		myPanel.add(xField);
		myPanel.add(Box.createHorizontalStrut(100)); // ekstra mellomrom mellom vareA og vareB
		myPanel.add(new JLabel("Vare B; Pris (Kr):"));
		myPanel.add(yField);
		myPanel.add(Box.createHorizontalStrut(0));
		myPanel.add(new JLabel("Mengde (kg):"));
		myPanel.add(zField);

		// skriver boksen for brukeren
		int result = JOptionPane.showConfirmDialog(null, myPanel, "Hvilken vare er billigst?",
				JOptionPane.OK_CANCEL_OPTION); // dersom bruker trykker "cancel" avlsuttes porgrammet
		if (result == JOptionPane.OK_OPTION) {

			// henter ut de oppgitte verdiene fra tekstboksene
			String w = wField.getText();
			String x = xField.getText();
			String y = yField.getText();
			String z = zField.getText();
			double a = Double.valueOf(w) / Double.valueOf(x); // finner kiloprisen til vare A
			double b = Double.valueOf(y) / Double.valueOf(z); // finner kiloprisen til vare B

			if (a < 0 || b < 0) {
				showMessageDialog(null, "Vennligst bruk positive verdier, takk");
			} else if (a == b) {
				showMessageDialog(null, "Varene er like billige\n\n" + "Vare A koster " + a + " Kr/kg\n"
						+ "Vare B koster " + a + " Kr/kg");
			} else if (a > b) {
				showMessageDialog(null, "Vare B er billigst!\n\n" + "Vare A koster " + a + " Kr/kg\n" + "Vare B koster "
						+ b + " Kr/kg");
			} else if (a < b) {
				showMessageDialog(null,
						"Vare A er billigst\n\n" + "Vare A koster " + a + " Kr/kg\n" + "Vare B koster " + b + " Kr/kg");
			}
		}
	}
}