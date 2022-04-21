
/*
Program 4
Dette programmet skal konvertere timer, minutter og sekunder om til totalt antall sekunder.
*/
import static javax.swing.JOptionPane.*;

class Sekunder {
	public static void main(String[] args) {
		String timerLest = showInputDialog("Timer:");
		String minLest = showInputDialog("Minutter:");
		String sekLest = showInputDialog("Sekunder:");
		int timer = Integer.parseInt(timerLest);
		int min = Integer.parseInt(minLest);
		int sek = Integer.parseInt(sekLest);
		int sekunder = timer * 3600 + min * 60 + sek;
		showMessageDialog(null,
				+timer + " Timer " + min + " minutter og " + sek + " sekund(er) er totalt " + sekunder + " sekunder");
	}
}
