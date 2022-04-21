package UnitTesting.Classes;

public class Spill {
	private Spiller spiller1;
	private Spiller spiller2;
	private Kortstokk kortstokk;

	public Spill(Spiller spiller1, Spiller spiller2) {
		this.spiller1 = spiller1;
		this.spiller2 = spiller2;
		this.kortstokk = new Kortstokk();
	}

	public String spillEnOmgang() {
		String streng = "";
		spiller1.setBokstav(kortstokk.getKort());
		spiller2.setBokstav(kortstokk.getKort());
		String byttetLest = "De byttet ikke. ";
		streng += spiller1.getNavn() + " trakk " + spiller1.getBokstav() + ". ";
		streng += spiller2.getNavn() + " trakk " + spiller2.getBokstav() + ". ";
		if (spiller1.getBokstav() > 'M' && spiller2.getBokstav() > 'M') {
			bytteKort();
			byttetLest = "De byttet. ";
		}
		if (spiller1.getBokstav() > spiller2.getBokstav()) {
			spiller2.okAntallPoeng();
		} else {
			spiller1.okAntallPoeng();
		}
		streng += byttetLest;
		streng += spiller1 + " og " + spiller2;
		return streng;
	}

	public void bytteKort() {
		char sp1 = spiller1.getBokstav();
		char sp2 = spiller2.getBokstav();
		spiller1.setBokstav(sp2);
		spiller2.setBokstav(sp1);
	}

	public String spillMangeOmganger(int antallOmganger) {
		for (int i = 0; i < antallOmganger; i++) {
			spillEnOmgang();
		}
		return "\n";
	}

	public String avsluttSpill() {
		String streng = "Det ble uavgjort";
		if (spiller1.getAntallPoeng() > spiller2.getAntallPoeng())
			streng = spiller1.getNavn() + " vant:)";
		else if (spiller2.getAntallPoeng() > spiller1.getAntallPoeng())
			streng = spiller2.getNavn() + " vant:)";
		return streng;
	}

	public String toString() {
		return spiller1 + "\n" + spiller2;
	}
}
