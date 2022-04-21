package UnitTesting.Classes;

public class Spiller {
	private final String navn;
	private char bokstav;
	private int poeng;

	public Spiller(String navn) {
		this.navn = navn;
	}

	public String getNavn() {
		return navn;
	}

	public char getBokstav() {
		return bokstav;
	}

	public void setBokstav(char c) {
		this.bokstav = c;
	}

	public int getAntallPoeng() {
		return poeng;
	}

	public void okAntallPoeng() {
		this.poeng++;
	}

	public String toString() {
		return navn + " har bokstav: " + bokstav + " og antall Poeng: " + poeng;
	}
}
