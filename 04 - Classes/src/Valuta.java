public class Valuta {
	private String name;
	private double kurs;

	public Valuta(String name, double kurs) {
		this.name = name;
		this.kurs = kurs;
		System.out.println("Genererer" + getName() + " kurs: " + getKurs());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getKurs() {
		return kurs;
	}

	public void setKurs(double kurs) {
		this.kurs = kurs;
	}
}
