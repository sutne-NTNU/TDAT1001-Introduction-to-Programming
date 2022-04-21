/*
Program 3
Følgende program skal konvertere oppgitt lengde i tommer (inches), til centimeter (cm)
*/

import static javax.swing.JOptionPane.*;

class Converter {
	public static void main(String[] args) {
		String inchesLest = showInputDialog("Tommer:");
		double inches = Integer.parseInt(inchesLest);
		double cm = inches * 2.54;
		showMessageDialog(null, +inches + " tommer tilsvarer " + cm + " centimeter");
	}
}
