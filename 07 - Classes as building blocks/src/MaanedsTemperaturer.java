/* 
 * øving 7 oppgave 9.11.2 side 314-15
 * public class Temperaturer{
 *	to-dimensional tabell
 *		double[][] temperatur = new double[30][24];
 *	a) middeltemperatur for hver dag i måneden
 *	b) middeltemperatur for hver time i døgnet i måneden
 *	c) middeltemperatur for hele måneden
 *	d) antall døgn med: <- -5] , <-5, 0] , <0 , 5] , <5 , 10] , <10+

maanedTab.length = dager
maanedTab[x].length = timer på dag x (vil være den samme for alle dager)
*/

public class MaanedsTemperaturer {
	double[][] maanedTab;
	double[] avgTempDag;
	double[] avgTempTime;

	public MaanedsTemperaturer(double[][] maanedTab) {
		this.maanedTab = maanedTab;
		this.avgTempDag = new double[maanedTab.length];
		for (int i = 0; i < maanedTab.length; i++) {
			this.avgTempTime = new double[maanedTab[i].length];
		}

		// oppretter tabell med gjennomsnittlig tempertur per dag
		double midDag = 0;
		for (int i = 0; i < maanedTab.length; i++) { // for hver dag
			midDag = 0;
			for (int j = 0; j < maanedTab[i].length; j++) { // for hver time
				midDag += maanedTab[i][j];
			}
			midDag /= maanedTab[i].length;

			int temp = (int) (midDag * 10); // fjerner desimaler under ti-deler
			midDag = ((double) temp) / 10;
			this.avgTempDag[i] = midDag;
		}

		// oppretter tabell med gjennomsnittlig tempertur per time
		double midTime = 0;
		for (int j = 0; j < maanedTab[0].length; j++) { // for hver time
			midTime = 0;
			for (int i = 0; i < maanedTab.length; i++) { // for hver dag
				midTime += maanedTab[i][j];
			}
			midTime /= maanedTab.length;

			int temp = (int) (midTime * 10); // fjerner desimaler under ti-deler
			midTime = ((double) temp) / 10;
			this.avgTempTime[j] = midTime;
		}
	}

	public double getTemperatur(int dag, int time) {
		return maanedTab[dag - 1][time - 1];
	}

	public double midDag(int dag) {
		return avgTempDag[dag];
	}

	public double midTime(int time) {
		return avgTempTime[time];
	}

	public double midMaaned() {
		double midMaaned = 0;
		for (int i = 0; i < avgTempDag.length; i++) {
			midMaaned += avgTempDag[i];
		}
		midMaaned /= avgTempDag.length;

		int temp = (int) (midMaaned * 10); // fjerner desimaler under ti-deler
		midMaaned = ((double) temp) / 10;

		return midMaaned;
	}

	public String tempIntervaller() {
		int uminusFem = 0;
		int mminusFemNull = 0;
		int mNullFem = 0;
		int mFemTi = 0;
		int oTi = 0;

		for (int i = 0; i < avgTempDag.length; i++) {
			if (avgTempDag[i] < -5) {
				uminusFem++;
			} else if (avgTempDag[i] < 0) {
				mminusFemNull++;
			} else if (avgTempDag[i] < 5) {
				mNullFem++;
			} else if (avgTempDag[i] < 10) {
				mFemTi++;
			} else {
				oTi++;
			}
		}
		return "Antall dager innenfor følgende intervall:" + "\nMindre enn -5 grader: 	" + uminusFem
				+ "\nMellom -5 og 0 grader:	" + mminusFemNull + "\nMellom 0 og 5 grader:	" + mNullFem
				+ "\nMellom 5 og 10 grader:	" + mFemTi + "\nMer enn 10 grader:	" + oTi;
	}

	// Testklient
	public static void main(String[] args) {
		double[][] testTab = new double[][] { { -6, 1, 2, 3, 5, 11 }, // avg 2,6
				{ -4, 1, 2, 5, 7, 10 }, // avg 3,5
				{ -2, 3, 6, 7, 11, 12 }, // avg 6,1
				{ -8, -2, 5, 13, 14, 19 }, // avg 6,8
				{ -13, -8, -6, -3, -1 }, // avg -5,1
		};// avg time; -6,6 -1 1,8 5 7,2 10,4 avg Maaned = 2,7
		MaanedsTemperaturer test = new MaanedsTemperaturer(testTab);

		for (int i = 0; i < testTab.length; i++) {
			System.out.println("Gjennomsnitt Dag " + (i + 1) + ": " + test.midDag(i));
		}
		System.out.println("\n");
		for (int i = 0; i <= testTab[0].length - 1; i++) {
			System.out.println("Gjennomsnitt Time " + (i + 1) + ": " + test.midTime(i));
		}

		System.out.println("\nTemperatur dag 3, time 5: " + test.getTemperatur(3, 5));

		System.out.println("\nGjennomsnittlig temperatur denne måneden: " + test.midMaaned());

		System.out.println("\n" + test.tempIntervaller());

	}
}