import static javax.swing.JOptionPane.*;

public class TekstAnalyseKlient {
	public static void main(String[] args) {

		boolean fortsett = true;
		while (fortsett) {
			String tekst = showInputDialog(null, "Skriv teksten som skal analyseres her");
			System.out.println("\n" + tekst);
			Tekstanalyse test = new Tekstanalyse(tekst);

			String bokstavLest = showInputDialog(null, "Hvilken bokstav vil du sjekke antallet av? skriv den her:");
			char bokstav = bokstavLest.charAt(0);

			System.out.println("\nForskjellige bokstaver:			" + test.antBokstaver());
			System.out.println("Antall bokstaver:			" + test.totBokstaver());
			System.out.println("Antall tegn (ikke bokstaver):		" + test.ikkeBokstaver());
			System.out.println("Forekomster av " + bokstav + " er: 			" + test.antallForekomster(bokstav));
			System.out.println("tegnet som er brukt mest er:	" + test.mestBrukt() + " som ble brukt "
					+ test.antMestBrukt() + " ganger");
		}
	}
}