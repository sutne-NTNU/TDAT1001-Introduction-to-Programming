/* 
oppretter klassen Brok
*/
public class Brok {
	private int teller;
	private int nevner;

	public Brok(int teller, int nevner) {
		this.teller = teller;
		this.nevner = nevner;
		if (nevner == 0) {
			throw new IllegalArgumentException("!MATH ERROR!, nevner kan ikke være 0");
		}
	}

	public Brok(int teller) {
		this.teller = teller;
		this.nevner = 1;
	}

	public Brok(Brok other) {
		teller = teller;
		nevner = nevner;
	}

	public String toString() { // blir automatisk hentet ut av "System.out.println", sørger for at dersom vi
								// vil skrive ut Brok "a" får vi det på formen "teller/nevner", og ikke som
								// "Brok@233c0b17"
		return " " + teller + "/" + nevner;
	}

	public int getTeller() {
		return teller;
	}

	public int getNevner() {
		return nevner;
	}

	public void pluss(Brok other) {
		teller = teller * other.nevner + other.teller * nevner;
		nevner = nevner * other.nevner;
	}

	public void minus(Brok other) {
		teller = teller * other.nevner - other.teller * nevner;
		nevner = nevner * other.nevner;
	}

	public void gange(Brok other) {
		teller = teller * other.teller;
		nevner = nevner * other.nevner;
	}

	public void dele(Brok other) {
		teller = teller * other.nevner;
		nevner = nevner * other.teller;
	}

	// Testklient
	public static void main(String[] args) {

		Brok a = new Brok(1, 2);
		Brok b = new Brok(2, 3);

		a.pluss(b);
		System.out.println(a); // forventet svar av a+b = 7/6

		a.minus(b); // a har nå forventet verdi 7/6
		System.out.println(a); // forventet svar av a-b = 9/18 (1/2)

		a.gange(b); // a har nå forventet verdi 9/18
		System.out.println(a); // Forventet svar av a*b = 18/54 (1/3)

		a.dele(b); // a har nå forventet verdi 18/54
		System.out.println(a); // forventet svar av a/b = 54/108 (1/2)

	}
}
