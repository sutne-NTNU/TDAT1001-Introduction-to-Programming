public class Student{
	private String navn;
	private int antOppg;
	
	public Student(String navn, int antOppg){
		this.navn = navn;
		this.antOppg = antOppg;
	}
	public String getNavn(){
		return navn;
	}
	public int getAntOppg(){
		return antOppg;
	}
	public void endreAntOppg(int endring){
		this.antOppg += endring;
		if(antOppg < 0){
			this.antOppg = 0;
		}
	}
	public String toString(){
		return navn + "Har gjort " + antOppg + " oppgaver";
	}
}