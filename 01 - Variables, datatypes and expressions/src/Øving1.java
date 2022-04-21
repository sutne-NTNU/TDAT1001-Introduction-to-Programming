import static javax.swing.JOptionPane.*;

class Øving1 {
	public static void main(String[] args) {
		System.out.println("Follow the instructions on screen");

		String lengdeLest = showInputDialog("Lengde: (meter)");
		String breddeLest = showInputDialog("Bredde: (meter)");
		double lengde = Integer.parseInt(lengdeLest);
		double bredde = Integer.parseInt(breddeLest);
		double arealet = lengde * bredde;
		showMessageDialog(null, "Arealet av rektangelet er " + arealet + " kvadratmeter");

		String inchesLest = showInputDialog("Tommer:");
		double inches = Integer.parseInt(inchesLest);
		double cm = inches * 2.54;
		showMessageDialog(null, +inches + " tommer tilsvarer " + cm + " centimeter");

		String timersLest = showInputDialog("Timer:");
		String minsLest = showInputDialog("Minutter:");
		String seksLest = showInputDialog("Sekunder:");
		int timers = Integer.parseInt(timersLest);
		int mins = Integer.parseInt(minsLest);
		int seks = Integer.parseInt(seksLest);
		int sekunders = timers * 3600 + mins * 60 + seks;
		showMessageDialog(null, timers + " Timer " + mins + " minutter og " + seks + " sekund(er) er totalt "
				+ sekunders + " sekunder");

		String sekLest = showInputDialog("Sekunder:");
		int sek = Integer.parseInt(sekLest);
		int timer = sek / 3600;
		int minutter = (sek % 3600) / 60;
		int sekunder = ((sek % 3600) % 60);
		showMessageDialog(null, sek + " sekunder tilsvarer\n" + timer + " time(r)\n" + minutter + " minutt(er)\n"
				+ sekunder + " sekund(er)");
	}
}
