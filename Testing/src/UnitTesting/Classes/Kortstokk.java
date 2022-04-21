package UnitTesting.Classes;

import java.util.ArrayList;
import java.util.Random;

public class Kortstokk {
	private ArrayList<Character> kortstokk;

	public Kortstokk() {
		kortstokk = new ArrayList<Character>();
		for (int i = 'A'; i <= 'Z'; i++) {
			kortstokk.add((char) i);
		}
	}

	public ArrayList<Character> getKortstokk() {
		return kortstokk;
	}

	public int getAntallBokstaver() {
		return kortstokk.size();
	}

	public char getKort() {
		Random random = new Random();
		int trekk = random.nextInt(kortstokk.size());
		char retur = kortstokk.get(trekk);
		kortstokk.remove(trekk);
		return retur;
	}

}
