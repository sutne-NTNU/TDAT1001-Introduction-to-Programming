/*
Testkjøring av logikken til oppgave 4 
*/

public class kilo {
	public static void main(String[] args) {
		Double vareA = 35.90 / 0.450; //
		Double vareB = 39.50 / 0.500;

		if (vareA == vareB) {
			System.out.println("varene er like billige");
		}
		if (vareA > vareB) {
			System.out.println("vare B er billigst");
		}
		if (vareB > vareA) {
			System.out.println("vare A er billigst");
		}
	}
}