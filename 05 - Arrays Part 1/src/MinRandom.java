
/*
Oppgave 6.10.3 Side 207-208
få tilfeldige tall i et gitt intervall med både heltall og desimaltall.
*/
import java.util.Random;

public class MinRandom {
	private int nedre;
	private int ovre;

	public MinRandom() {
	}

	public int nesteHeltall(int nedre, int ovre) {
		Random rHeltall = new Random();
		return nedre + rHeltall.nextInt(ovre - nedre + 1);
	}

	public double nesteDesimaltall(double nedre, double ovre) {
		Random r = new Random();
		return nedre + (ovre - nedre) * r.nextDouble();
	}

	// Testklient
	public static void main(String... args) {

		MinRandom test = new MinRandom();
		for (int i = 0; i < 100; i++) { // Tester 100 tall.

			int h = test.nesteHeltall(4, 10);
			double d = test.nesteDesimaltall(4, 5);

			System.out.println(h + "   " + d); // h skal ha verdier fra og med 10, til og med 20. d skal ha verdier fra
												// 5.50 til 10.00.
		}
	}
}
