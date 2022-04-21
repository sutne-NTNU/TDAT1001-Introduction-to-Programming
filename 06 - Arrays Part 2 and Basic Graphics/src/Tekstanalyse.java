
/*
Øving 6 oppgave 7.10.3 side 231
klasse for tekstanalyse
*/
import static javax.swing.JOptionPane.*;

public class Tekstanalyse {
	private char tegn;
	private int verdi;
	private int maks;
	private String tekst;
	int[] antallTegn = new int[30];

	public Tekstanalyse(String rawTekst) {
		String tekst = rawTekst.toUpperCase();

		for (int i = 0; i < tekst.length(); i++) {
			tegn = tekst.charAt(i);
			verdi = tegn - 65;

			if (0 <= verdi && verdi <= 30) {
				antallTegn[verdi]++;
			} else {
				switch (verdi) {
					case 133:
						antallTegn[26]++;
						break;
					case 151:
						antallTegn[27]++;
						break;
					case 132:
						antallTegn[28]++;
						break;
					default:
						antallTegn[29]++;
				}
			}
		}
	}

	public int antBokstaver() {
		int antBokstaver = 0;
		for (int i = 0; i < 29; i++) {
			if (antallTegn[i] > 0) {
				antBokstaver++;
			}
		}
		return antBokstaver;
	}

	public int totBokstaver() {
		int totBokstaver = 0;
		for (int i = 0; i < antallTegn.length - 1; i++) {
			totBokstaver += antallTegn[i];
		}
		return totBokstaver;
	}

	public int ikkeBokstaver() {
		int ikkeBokstaver = antallTegn[29];
		return ikkeBokstaver;
	}

	public int antallForekomster(char bokstav) {
		verdi = Character.toUpperCase(bokstav) - 65;

		int antallForekomster = 0;
		if (0 <= verdi && verdi <= 25) {
			antallForekomster = antallTegn[verdi];
		} else {
			switch (verdi) {
				case 133:
					antallForekomster = antallTegn[26];
					break;
				case 151:
					antallForekomster = antallTegn[27];
					break;
				case 132:
					antallForekomster = antallTegn[28];
					break;
				default:
					antallForekomster = antallTegn[29];
			}
		}
		return antallForekomster;
	}

	public int antMestBrukt() {
		int bokstav = 0;
		maks = antallTegn[0];
		for (int i = 0; i < 30; i++) {
			if (antallTegn[i] > maks) {
				maks = antallTegn[i];
			}
		}
		return maks;
	}

	public String mestBrukt() {
		char bokstav = ' ';
		String bokstaver = "";
		int bokstavTall = 0;
		maks = antallTegn[0];

		for (int i = 0; i < antallTegn.length; i++) {
			if (antallTegn[i] > maks) {
				if (0 <= i && i <= 25) {
					maks = antallTegn[i];
					bokstavTall = 65 + i;
					bokstav = (char) (bokstavTall);
					bokstaver = "" + bokstav;
				} else {
					switch (i) {
						case 26:
							maks = antallTegn[i];
							bokstavTall = 65 + i;
							bokstaver = "Æ";
							break;
						case 27:
							maks = antallTegn[i];
							bokstavTall = 65 + i;
							bokstaver = "Ø";
							break;
						case 28:
							maks = antallTegn[i];
							bokstavTall = 65 + i;
							bokstaver = "Å";
							break;
						default:
							maks = antallTegn[i];
							bokstavTall = 65 + i;
							bokstaver = "Symboler";
					}
				}
			}
		}
		for (int i = 0; i < antallTegn.length; i++) {
			if (antallTegn[i] == maks && i != bokstavTall - 65) {
				if (0 <= i && i <= 25) {
					bokstavTall = 65 + i;
					bokstav = (char) (bokstavTall);
					bokstaver += " og " + bokstav;
				} else {
					switch (i) {
						case 26:
							bokstaver += " og Æ";
							break;
						case 27:
							bokstaver += " og Ø";
							break;
						case 28:
							bokstaver += " og Å";
							break;
						default:
							maks = antallTegn[i];
							bokstavTall = 65 + i;
							bokstaver = "Symboler";
					}
				}
			}
		}
		return bokstaver;
	}

	// Testklient
	public static void main(String[] args) {

		Tekstanalyse test = new Tekstanalyse("Dette er en: Tekstanalyse Test!");
		System.out.println("6 Tester:");

		int antBokstaver = test.antBokstaver();
		if (antBokstaver == 10) {
			System.out.println("1: antBokstaver 	= OK");
		} else {
			System.out.println("1: antBokstaver 	= ERROR");
		}

		int totBokstaver = test.totBokstaver();
		if (totBokstaver == 25) {
			System.out.println("2: totBokstaver 	= OK");
		} else {
			System.out.println("2: totBokstaver 	= ERROR");
		}

		int ikkeBokstaver = test.ikkeBokstaver();
		if (ikkeBokstaver == 6) {
			System.out.println("3: ikkeBokstaver 	= OK");
		} else {
			System.out.println("3: ikkeBokstaver 	= ERROR");
		}

		int antallForekomster = test.antallForekomster('a');
		if (antallForekomster == 2) {
			System.out.println("4: antallForekomster 	= OK");
		} else {
			System.out.println("4: antallForekomster 	= ERROR");
		}

		int antMestBrukt = test.antMestBrukt();
		if (antMestBrukt == 7) {
			System.out.println("5: antMestBrukt 	= OK");
		} else {
			System.out.println("5: antMestBrukt	= ERROR");
		}

		String mestBrukt = test.mestBrukt();
		if (mestBrukt.equals("E")) {
			System.out.println("6: mestBrukt 		= OK");
		} else {
			System.out.println("6: mestBrukt 		= ERROR");
		}
	}
}