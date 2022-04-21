import java.util.Random; //Class

public class Spiller {
	private String spiller;
	private int sumPoeng;

	public Spiller(String spiller, int sumPoeng) {
		this.spiller = spiller;
		this.sumPoeng = sumPoeng;
		System.out.println("Spilleren " + getSpiller() + " Ble med i spillet");
	}

	public String getSpiller() {
		return spiller;
	}

	public void kastTerningen() {
		Random terning = new Random();
		int terningkast = terning.nextInt(6) + 1;
		if (terningkast == 1) {
			sumPoeng = 0;
		} else {
			sumPoeng += terningkast;
		}
	}

	public int getSumPoeng() {
		return sumPoeng;
	}

	public void setSumPoeng(int sumPoeng) {
		this.sumPoeng = sumPoeng;
	}
}