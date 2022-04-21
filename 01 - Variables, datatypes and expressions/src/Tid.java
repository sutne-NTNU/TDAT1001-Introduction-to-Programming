
/*
Program 5
Dette programmet gjør motsatt av program 4, og beregner antall timer, minutter og sekunder fra et totalt antall sekunder.
*/
import static javax.swing.JOptionPane.*;

class Tid {
	public static void main(String[] args) {
		System.out.println("Follow the instructions on screen");
		String sekLest = showInputDialog("Sekunder:");
		int sek = Integer.parseInt(sekLest);
		int timer = sek / 3600;
		int minutter = (sek % 3600) / 60;
		int sekunder = ((sek % 3600) % 60);
		showMessageDialog(null, +sek + " sekunder tilsvarer " + timer + " timer " + minutter + " minutter og "
				+ sekunder + " sekunder");
	}
}
