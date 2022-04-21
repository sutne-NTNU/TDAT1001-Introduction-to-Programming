/*
Program 2
Dette programmet skal beregne arealet av rektangeler, ved bruk av Pop-up bokser.
*/

import static javax.swing.JOptionPane.*;

class Arealberegning {
	public static void main(String[] args) {
		String lengdeLest = showInputDialog("Lengde: (meter)");
		String breddeLest = showInputDialog("Bredde: (meter)");
		double lengde = Integer.parseInt(lengdeLest);
		double bredde = Integer.parseInt(breddeLest);
		double arealet = lengde * bredde;
		showMessageDialog(null, "Arealet av rektangelet er " + arealet + " kvadratmeter");
	}
}
